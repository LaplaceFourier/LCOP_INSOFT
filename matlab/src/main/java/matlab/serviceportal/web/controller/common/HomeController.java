package matlab.serviceportal.web.controller.common;

import matlab.serviceportal.base.controller.BaseController;
import matlab.serviceportal.base.vo.BaseVo;

//Menu항목과 관련된 부분
import matlab.serviceportal.web.vo.system.MenuVo;
//User항목과 관련된 부분
import matlab.serviceportal.web.vo.system.UserVo;

//logging 관련 library
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//javax HttpServletRequest와 HttpSession와 관련된 소스들
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//springframework 관련된 library들
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//기본적으로 포함되어 있는 Java클래스들
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


/*import insoft.serviceportal.util.CloudmeshException;
import insoft.serviceportal.util.common.Common;
import insoft.serviceportal.web.service.service.ServiceService;
import insoft.serviceportal.web.service.system.LocaleService;
import insoft.serviceportal.web.service.system.MenuService;
import insoft.serviceportal.web.service.system.UserMenuService;
import insoft.serviceportal.web.vo.openstack.CoTenantVo;
import insoft.serviceportal.web.vo.service.ServiceVo;
import insoft.serviceportal.web.vo.system.FileVo;
*/


/*
import java.util.Enumeration;
*/

/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;*/

/*import egovframework.rte.fdl.string.EgovStringUtil;*/

/**
 * Cloud Mesh : 메인 화면
 * @since 2016. 5. 9.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------       --------    ---------------------------
 *
 * </pre>
 */
@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//@Autowired LocaleService localeService;
	@Autowired MenuService menuService;
	//@Autowired UserMenuService userMenuService;
	//@Autowired ServiceService serviceService;
	
	public HomeController() {
		logger.debug("[inited] " + this.getClass());
	}

	@RequestMapping("home")
	public ModelAndView home(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("home");

		//여기서 메뉴는 하나의 메뉴에 해당한다.
		MenuVo menu = new MenuVo();
		//UserVo user = new UserVo();

		//user.setUser_id(getUser_id());   //세션에 저장된 로그인 정보를 반환
		//user.setSite_id(getSite_id());   //세션에 저장된 존 아이디를 반환

		// 메뉴별 기능 목록(등록, 수정, 삭제 등 특정 액션 및 특정 영역에 제한 및 허용을 위해 사용됨)
		List<MenuVo> functions_check = new ArrayList<MenuVo>();

		// 유저의 접근 가능한 메뉴 목록을 처리한다. 사용자 role에 맞는 Menu를 반환한다. 메뉴 기능을 체크하기 위한 List값을 가지고 있음
		init_menu(userMenuService.select_role(user), menu, functions_check);

		// 메뉴 목록
		List<MenuVo> menus = menu.getSub();

		// 허용된 메뉴가 없으면 대시보드 정보만 셋팅한다.
		if (menus.size() == 0) {
			menus = new ArrayList<MenuVo>();
			MenuVo param = new MenuVo();
			param.setMenu_id(1);

			menus.add(menuService.select_one(param));
			init_menu(menus, menu, functions_check);

			menus = menu.getSub();
		}

		request.getSession().setAttribute("user_functions", functions_check);

		// 지원되는 다국어 목록을 조회
		//view.addObject("locales", localeService.list(null));
		// 페이지 이동이 필요 한 경우
		//view.addObject("goPage", getGoPage());
		// 사용자에게 노출될 메뉴 목록
		view.addObject("menu", menus);
		
		return view;
	}
	
	/*@SuppressWarnings("rawtypes")
	@RequestMapping("goPage")
	public ModelAndView goPage(HttpServletRequest request, HttpSession session) {

		if(EgovStringUtil.isNotEmpty(request.getParameter("hash")))
		{
			Map<String, Object> params = new HashMap<String, Object>();
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				params.put(key, request.getParameter(key));
			}
			setSession("goPage", params);
		}

		if(userTopGranted() == null)
			return new ModelAndView("redirect:/login/login.do");
		else
			return new ModelAndView("redirect:/");
	}

	*//**
	 * 파일 다운로드
	 * @param param
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("download")
	public ModelAndView dn(FileVo param) throws Exception {
		return new ModelAndView(DOWNLOAD, "downloadFile", fileAttachService.select(param));
	}

	*//**
	 * 첨부파일 새로고침 용도
	 * @param param
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("file_refresh")
	public ModelAndView refresh(FileVo param) throws Exception {
		return new ModelAndView(JSON, "data", fileAttachService.list(param));
	}*/

	
	//메뉴에 관련하여, DB에서 뽑아내는 과정, init_menu(userMenuService.select_role(user), menu, functions_check);
	private int init_menu(List<MenuVo> menus, MenuVo data, List<MenuVo> functions_check) {

		// 최상위 노드를 먼저 찾는다. 
		if (data.getMenu_id() == 0) {
			for (int i = 0; i < menus.size(); i++) {
				if (menus.size() == 0)
					return 0;
				MenuVo menu = menus.get(i);

				if (menu.getParent_menu_id() == 0 && EgovStringUtil.equals("Y", menu.getUse_yn())) {
					data.getSub().add(menu);

					menus.remove(menu);
					functions_check.add(menu);

					i--;

					init_menu(menus, data.getSub().get(data.getSub().size() - 1), functions_check);
				}
			}
		} else { //메뉴가 총 112개로 구성되어 있다. 데이터에 값이 없으므로 이 것이 먼저 실행되게 된다. 
			for (int i = 0; i < menus.size(); i++) {
				if (menus.size() == 0)  //유저에 따른 메뉴 사이즈를 의미, 메뉴의 사이즈가 0이면
					return 0;
				MenuVo menu = menus.get(i);  //0부터 해서 i번째의 메뉴의 값들을 menu변수에 각각 집어 넣는다.
                
				//menu 아이디와 부모 menu 아이디의 값이 같고, 메뉴 사용여부가 Y인 경우
				if (EgovStringUtil.equals(String.valueOf(menu.getParent_menu_id()), String.valueOf(data.getMenu_id())) && EgovStringUtil.equals("Y", menu.getUse_yn())) {
											
					data.getSub().add(menu); //빈객체 menu data의 sub 변수에 현재의 menu 객체의 값을 집어 넣는다.

					menus.remove(menu); //menu List에 menu객체를 제거한다.
					functions_check.add(menu);

					i--;

					init_menu(menus, data.getSub().get(data.getSub().size() - 1), functions_check);
				}
			}
			return data.getSub().size();
		}
		return 0;
	}
}
