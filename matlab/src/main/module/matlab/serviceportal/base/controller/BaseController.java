package matlab.serviceportal.base.controller;

//HomeController를 객체로 하여 가지고 온다.
import matlab.serviceportal.web.controller.common.HomeController;
//Menu와 관련된 Vo객체를 만든다.
import matlab.serviceportal.web.vo.system.MenuVo;
//User와 관련된 Vo객체를 만든다.
import matlab.serviceportal.web.vo.system.UserVo;

//기본적인 자바와 관련된 클래스들을 임포트 시킨다.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.Validation;
import javax.validation.Validator;

/*import org.apache.commons.lang.math.RandomUtils;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;

import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/*import insoft.serviceportal.base.resulthandler.BaseResultHandler;
import insoft.serviceportal.base.resulthandler.impl.MapResultHandler;
import insoft.serviceportal.ext.springframework.context.ApplicationContextUtils;
import insoft.serviceportal.ext.springframework.event.CloudmeshEvent;
import insoft.serviceportal.ext.springframework.view.vo.ExcelVo;
import insoft.serviceportal.util.common.Common;
import insoft.serviceportal.util.common.OS;

import insoft.serviceportal.web.service.common.FileAttachService;
import insoft.serviceportal.web.service.openstack.CoRegionService;
import insoft.serviceportal.web.service.openstack.CoTenantService;
import insoft.serviceportal.web.service.resource.ConfigService;
import insoft.serviceportal.web.vo.openstack.CoRegionVo;
import insoft.serviceportal.web.vo.openstack.CoTenantVo;
import insoft.serviceportal.web.vo.resource.ConfigVo;
import insoft.serviceportal.web.vo.system.FileVo;
*/



/*import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;*/



/*import com.mysocloud.cloud.connection.AbstractConnection;
import com.mysocloud.cloud.connection.Connection;

import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrServiceImpl;
import egovframework.rte.fdl.string.EgovStringUtil;*/

/**
 * Cloud Mesh : 공통 컨트롤러 - 컨트롤러에서 사용되는 공통적인 메소드 포함
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
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//@Autowired protected MessageSourceAccessor message;
	//@Autowired protected Properties sysProps;
	//@Autowired protected FileAttachService fileAttachService;
	//@Autowired protected ServletContext sc;
	//@Autowired protected JavaMailSender mailSender;
	//@Autowired protected ConfigService configService;
	//@Autowired protected CoRegionService coRegionService;
	//@Autowired protected CoTenantService coTenantService;

	/**
	 * value = success
	 */
	protected String SUCCESS = "success";

	/**
	 * value = fail
	 */
	protected String FAIL = "fail";

	/**
	 * value = already
	 */
	protected String ALREADY = "already";

	/**
	 * value = diff_user
	 */
	protected String DIFF_USER = "diff_user";

	/**
	 * vale = result
	 */
	protected String RESULT = "result";

	/**
	 * vale = msg
	 */
	protected String MSG = "msg";

	/**
	 * vale = err_msg
	 */
	private String ERR_MSG = "err_msg";

	/**
	 * viewName : jsonView
	 */
	protected String JSON = "jsonView";

	/**
	 * viewName : excelView
	 */
	protected String EXCEL = "excelView";

	/**
	 * viewName : excelMapView
	 */
	protected String EXCEL_MAP = "excelMapView";

	/**
	 * viewName : downloadView
	 */
	protected String DOWNLOAD = "downloadView";

	/**
	 * viewName : mapExcelView
	 */
	protected String MAP_EXCEL_VIEW = "mapExcelView";

	/**
	 * viewName : alertView
	 */
	protected String ALERT = "alertView";

	/**
	 * @param view
	 * @return view.addObject("result", "success")
	 */
	protected ModelAndView SUCCESS(ModelAndView view){
		return view.addObject(RESULT, SUCCESS);
	}

	/**
	 * @param view
	 * @return view.addObject("result", "fail")
	 */
	protected ModelAndView FAIL(ModelAndView view){
		return view.addObject(RESULT, FAIL);
	}

	/**
	 * @param view
	 * @param result
	 * @return view.addObject("result", "success") or view.addObject("result", "fail")
	 */
	protected ModelAndView RESULT(ModelAndView view, boolean result){
		return view.addObject(RESULT, result ? SUCCESS : FAIL);
	}

	/**
	 * 소드 데이터가 VO 데이터. excelView
	 * @return
	 */
	protected ModelAndView excelView(){
		return new ModelAndView(EXCEL);
	}

	/**
	 * 소스 데이터가 MAP 데이터. excelMapView
	 * @return
	 */
	protected ModelAndView excelMapView(){
		return new ModelAndView(EXCEL_MAP);
	}

	/**
	 * xls 파일을 로드하여 템플릿으로 이용하는 view 
	 * @param view
	 * @param file_name
	 * @param clazz
	 * @return
	 */
	protected ModelAndView excelTemplate(ModelAndView view, String file_name, String clazz){
		view.setViewName("excelTemplateView");
		view.addObject("file_name", file_name);
		view.addObject("class", clazz);
		return view;
	}

	protected EgovIdGnrService getIdgen(EgovIdGnrService idgen, String table_nm) {
		EgovTableIdGnrServiceImpl idgnr = ((EgovTableIdGnrServiceImpl)idgen);
		idgnr.setTableName(table_nm);
		return idgnr;
	}

	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	private Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuthentication().getAuthorities();
	}

	protected ApplicationContext getApplicationContext() {
		return ApplicationContextUtils.getApplicationContext();
	}

	protected Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	private HttpServletRequest getdRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	private HttpSession getSession() {
		return getdRequest().getSession();
	}

	/**
	 * 컨텍스트 경로를 반환한다.
	 * @return
	 */
	protected String getContextPath() {
		return getdRequest().getContextPath();
	}

	/**
	 * 세션에 저장된 로그인 아이디를 반환한다.
	 * @return
	 */
	protected String getUser_id() {
		return getAuthentication().getName();
	}

	/**
	 * 세션에 객채를 저장한다.
	 * @param key
	 * @param data
	 */
	protected void setSession(String key, Object data) {
		getSession().setAttribute(key, data);
	}

	/**
	 * 세션에 저장된 로그인 정보를 반환한다.
	 * @return
	 */
	protected UserVo getUser_info() {
		return (UserVo) getSession().getAttribute("user_info");
	}

	/**
	 * 세션에 저장된 존 아이디를 반환한다.
	 * @return
	 */
	protected String getSite_id() {
		return (String)getSession().getAttribute("site_id");
	}

	/**
	 * 세션에서 goPage 데이터를 가져온다.
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getGoPage() {
		return (Map<String, Object>)getSession().getAttribute("goPage");
	}

	/**
	 * 세션에서 goPage 데이터를 삭제한다.(새로고침으로 goPage 페이지로 이동되는것을 방지하기 위함)
	 */
	protected void clearGoPage() {
		getSession().removeAttribute("goPage");
	}

	/**
	 * 현재날짜 yyyymmdd
	 * @return
	 */
	protected String getDt() {
		return Common.getCurrentDateAsString();
	}


	/**
	 * 현재날짜와 시간 yyyymmddhhmiss
	 * @return
	 */
	protected String getDtm() {
		return Common.getCurrentDateTimeAsString();
	}

	/**
	 * 환경설정 파일에서 현재 시스템 운영체제에 맞는 속성 값을 가져온다.
	 * @param key
	 * @return
	 */
	protected String getProperty(String key) {
		return getProperty(key, null);
	}

	/**
	 * 환경설정 파일에서 현재 시스템 운영체제에 맞는 속성 값을 가져온다.
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected String getProperty(String key, String defaultValue) {
		if(OS.isWindows())
		{
			if(sysProps.containsKey(key+".windows"))
				return sysProps.getProperty(key+".windows");
		}
		else if(OS.isLinux())
		{
			if(sysProps.containsKey(key+".linux"))
				return sysProps.getProperty(key+".linux");
		}
		else if(OS.isMac())
		{
			if(sysProps.containsKey(key+".mac"))
				return sysProps.getProperty(key+".mac");
		}
		return sysProps.getProperty(key, defaultValue);
	}

	/**
	 * 환경설정 파일에서 업로드 경로를 가져온다.
	 * @return
	 */
	protected String getUpload_path() {
		return getProperty("file.upload.path");
	}

	/**
	 * 세션에 저장된 사용자에 할당된 메뉴 목록
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<MenuVo> getMenus(HttpServletRequest request) {
		return (List<MenuVo>) getSession().getAttribute("user_menu");
	}

	protected String userTopGranted() {

		Collection<? extends GrantedAuthority> auth = getAuthorities();

		if (auth.size() > 0)
			return auth.iterator().next().getAuthority();
		return null;
	}

	/**
	 * 엑셀 다운로드용 MyBatis ResultHandler 를 초기화한다.
	 * @param excel
	 * @return
	 */
	protected BaseResultHandler<Object> excelMapHandler(ExcelVo excel) {

		return new MapResultHandler<Object>(excel.getKey(), sysProps.getProperty("excel.invoke.vo_package"));
	}

	/**
	 * 로직 처리시 발생한 모든 예외를 처리한다.
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ModelAndView handleException(Exception e, HttpServletResponse response)
	{
		ModelAndView view = new ModelAndView("forward:"+sysProps.getProperty("error.500.forward.url"));

		System.out.println(e);
		logger.error(e.getMessage(), e.getCause());

		if(e instanceof FileNotFoundException)
			view.addObject(ERR_MSG, message.getMessage("msg.alert.not_processed"));
		else
			if(EgovStringUtil.isEmpty(e.getMessage()))
//				view.addObject(ERR_MSG, e.toString());
				view.addObject(ERR_MSG, message.getMessage("msg.alert.500_error"));
			else
//				view.addObject(ERR_MSG, e.getMessage());
				view.addObject(ERR_MSG, message.getMessage("msg.alert.500_error"));

		return view;
	}

	/**
	 * 업로드된 파일을 서버에 저장하고 DB 에 저장 될 vo 를 셋팅한다.
	 * @param request
	 * @param file_attach_id 첨부파일 키(기존 파일키가 있으면 기존 값을 넘긴다.)
	 * @param idgen
	 * @return
	 * @throws Exception 
	 */
	protected List<FileVo> saveFiles(HttpServletRequest request, String file_attach_id, EgovIdGnrService idgen) throws Exception {
		return saveFiles(request, file_attach_id, idgen, null, "1");
	}

	/**
	 * 업로드된 파일을 서버에 저장하고 DB 에 저장 될 vo 를 셋팅한다.<br>
	 * @param request<br>
	 * @param file_attach_id 첨부파일 키(기존 파일키가 있으면 기존 값을 넘긴다.)<br>
	 * @param idgen<br>
	 * @param field_nm	&lt;input name='<b>xxx</b>'&gt; xxx 의 이름을 지정 할 수 있다.<br>
	 * @return
	 * @throws Exception 
	 */
	protected List<FileVo> saveFiles(HttpServletRequest request, String file_attach_id, EgovIdGnrService idgen, String field_nm) throws Exception {
		return saveFiles(request, file_attach_id, idgen, field_nm, "1");
	}


	/**
	 * 업로드된 파일을 서버에 저장하고 DB 에 저장 될 vo 를 셋팅한다.<br>
	 * @param request<br>
	 * @param file_attach_id 첨부파일 키(기존 파일키가 있으면 기존 값을 넘긴다.)<br>
	 * @param idgen<br>
	 * @param field_nm	&lt;input name='<b>xxx</b>'&gt; xxx 의 이름을 지정 할 수 있다.<br>
	 * @param file_upload_view_div<br>
	 * @return
	 * @throws Exception 
	 */
	protected List<FileVo> saveFiles(HttpServletRequest request, String file_attach_id, EgovIdGnrService idgen, String field_nm, String file_upload_view_div) throws Exception {

		try {
			File dir;
			String real_file_nm;
			String save_file_nm;
			String name;
			FileVo filevo = null;
			List<MultipartFile> files;
			List<FileVo> fList = new ArrayList<FileVo>();

			MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)request;

			Iterator<String> i = multipart.getFileNames();

			String save_path = getUpload_path() + File.separator + Common.getCurrentYearMonthAsString();

			while (i.hasNext()) {
				name = (String) i.next();

				if(EgovStringUtil.isNotEmpty(field_nm) && !name.equals(field_nm))
				{
					continue;
				}

				files = multipart.getFiles(name);

				for (MultipartFile file : files) {

					if("".equals(file.getOriginalFilename()) || file.getSize() == 0)
						continue;
					real_file_nm = file.getOriginalFilename();

					save_file_nm = Common.getCurrentDateTimeAsString() + "_" + file.getSize() + "_" + RandomUtils.nextInt() + "_mesh";

					dir = new File(save_path);
					if(!dir.exists()) dir.mkdirs();

					file.transferTo(new File(save_path + File.separator + save_file_nm));

					if(filevo == null)
					{
						filevo = new FileVo();

						if(EgovStringUtil.isEmpty(file_attach_id))
							filevo.setFile_attach_id(getIdgen(idgen, "TB_FILE_ATTACH").getNextStringId());
						else
							filevo.setFile_attach_id(file_attach_id);
					}
					else
					{
						filevo = new FileVo();
						filevo.setFile_attach_id(fList.get(0).getFile_attach_id());
					}

					filevo.setSave_path(save_path);
					filevo.setSave_file_nm(save_file_nm);
					filevo.setReal_file_nm(real_file_nm);
					filevo.setFile_size(file.getSize());
					filevo.setFile_upload_view_div(file_upload_view_div);
					filevo.setCreate_user_id(getUser_id());
					filevo.setCreate_dtm(getDtm());

					fList.add(filevo);
				}
			}

			return fList;

		}catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 삭제 대상 파일 정보를 처리하는 부분.
	 * @param request
	 * @return
	 */
	protected FileVo fileDeleteCheck(HttpServletRequest request) {

		FileVo vo = new FileVo();

		String[] delete_files = request.getParameterValues("delete_files");

		FileVo file = null;

		if(delete_files != null)
		{
			for (String value : delete_files) {
				file = new FileVo();
				file.setFile_key(value);
				file.setUse_yn("N");

				vo.getDel_files().add(file);
			}
		}

		return vo;
	}

	/**
	 * 파일 삭제를 처리하는 부분 (삭제하지 않도록 주석처리됨)
	 * 
	 * @param file
	 */
	protected void fileDelete(FileVo file) {
		/*try {
			for (FileVo fileVo : file.getDel_files_after()) {

				File del_file = new File(fileVo.getSave_path() + File.separator + fileVo.getSave_file_nm());
				if(del_file.exists())
				{
					del_file.delete();
				}
			}
		} catch (Exception e) {
		}*/
	}

	/**
	 * Valid 처리에서 오류가 발생된 결과를 view 에 넣어준다.
	 * @param view
	 * @param bindingResult
	 */
	protected void setBindingResult(ModelAndView view, Errors bindingResult) {
		view.addObject(sysProps.getProperty("error.bindingresult.result"), FAIL);
		view.addObject(sysProps.getProperty("error.bindingresult.field"), bindingResult.getFieldError().getField());
		view.addObject(sysProps.getProperty("error.bindingresult.message"), bindingResult.getFieldError().getDefaultMessage());
		view.addObject(sysProps.getProperty("error.bindingresult.allErrors"), bindingResult.getAllErrors());
	}

	/**
	 * 스프링 프레임워크에 이벤트를 발생시킨다.
	 * @param obj 이벤트에 넣어 처리 할 정보를 담은 객체
	 * @param type 이벤트 종류
	 */
	protected void name(Object obj, CloudmeshEvent.Type type) {
		try{
			getApplicationContext().publishEvent(new CloudmeshEvent(obj, type));
		}catch(Exception e){}
	}

	/**
	 * Valid 처리를 수행한다.
	 * @param view
	 * @param bindingResult
	 * @param vo
	 * @param classes
	 * @return
	 */
	protected boolean isValid(ModelAndView view, Errors bindingResult, Object vo, Class<?> ... classes) {
		if(classes != null && classes.length > 0)
		{
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Object>> violations = validator.validate(vo, classes);
			for (ConstraintViolation<Object> v : violations) {
				Path path = v.getPropertyPath();
				String propertyName = "";
				if (path != null) {
					for (Node n : path) {
						propertyName += n.getName() + ".";
					}
					propertyName = propertyName.substring(0, propertyName.length() - 1);
				}
				String constraintName = v.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
				if ("".equals(propertyName)) {
					bindingResult.reject(constraintName, message.getMessage(v.getMessage(), v.getMessage()));
				} else {
					bindingResult.rejectValue(propertyName, constraintName, message.getMessage(v.getMessage(), v.getMessage()));
				}
			}
		}

		if(bindingResult.getErrorCount() == 0)
			return true;

		setBindingResult(view, bindingResult);

		if(!JSON.equals(view.getViewName()))
			view.setViewName("forward:"+sysProps.getProperty("error.validation.forward.url"));

		return false;
	}

	/**
	 * 드라이버 커넥션 생성
	 * @return
	 */
	protected Connection driver_conn(Integer region_id) {

		return driver_conn(region_id, 0, "");
	}

	/**
	 * 드라이버 커넥션 생성
	 * @return
	 */
	protected Connection driver_conn(Integer region_id, String tenant_id) {

		return driver_conn(region_id, 0, tenant_id);
	}

	/**
	 * 드라이버 커넥션 생성 (포트 지정)
	 * @return
	 */
	protected Connection driver_conn(Integer region_id, Integer port) {

		CoRegionVo param = new CoRegionVo();
		param.setRegion_id(region_id);

		param = coRegionService.select(param);

		if(param != null)
		{
			String endpoint_url = param.getEndpoint_url();

			if(port > 0)
				endpoint_url = param.getEndpoint_url().replaceAll(":([0-9]{3,5})", ":"+port);

			return AbstractConnection.getConneciton(
					"com.mysocloud.openstack.cloud.connection.OpenStackConnection",
					param.getAccess_key(), param.getSecret_key(), endpoint_url);
		}
		else
		{
			return AbstractConnection.getConneciton(
					"com.mysocloud.openstack.cloud.connection.OpenStackConnection",
					"admin:admin", "insoft00", "http://127.0.0.1:5000/v2.0/");
		}
	}

	/**
	 * 드라이버 커넥션 생성 (포트 지정)
	 * @return
	 */
	protected Connection driver_conn(Integer region_id, Integer port, String tenant_id) {

		CoRegionVo param = new CoRegionVo();
		param.setRegion_id(region_id);

		param = coRegionService.select(param);

		String tenant_name = "admin";

		if(EgovStringUtil.isNotEmpty(tenant_id))
		{
			CoTenantVo tenant = new CoTenantVo();
			tenant.setRegion_id(region_id);
			tenant.setTenant_id(tenant_id);
			tenant_name = ((CoTenantVo)coTenantService.select(tenant)).getTenant_name();
		}

		if(param != null)
		{
			String endpoint_url = param.getEndpoint_url();

			if(port > 0)
				endpoint_url = param.getEndpoint_url().replaceAll(":([0-9]{3,5})", ":"+port);

			return AbstractConnection.getConneciton(
					"com.mysocloud.openstack.cloud.connection.OpenStackConnection",
					tenant_name + param.getAccess_key().substring(param.getAccess_key().indexOf(':')), param.getSecret_key(), endpoint_url);
		}
		else
		{
			return AbstractConnection.getConneciton(
					"com.mysocloud.openstack.cloud.connection.OpenStackConnection",
					"admin:" + tenant_name, "insoft00", "http://127.0.0.1:5000/v2.0/");
		}
	}

	/**
	 * 오픈스택의 오브젝트 아이디로 Region_id 값을 조회한다.
	 */
	protected Integer region_id(Integer object_id) {

		if(object_id > 0)
		{
			ConfigVo region = configService.region_info(String.valueOf(object_id));

			if(region != null && EgovStringUtil.isNotEmpty(region.getObject_id()))
				return Integer.parseInt(region.getObject_id());
		}

		return 0;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		/*binder.registerCustomEditor(String.class, "object_id", new StringTrimmerEditor(false) {
			public void setValue(Object obj) {
				super.setValue(obj == null || "".equals(obj) ? "0" : obj);
			}
		});
		binder.registerCustomEditor(Integer.TYPE, new CustomNumberEditor(Integer.class, true) {
			public void setValue(Object obj) {
				super.setValue(obj == null || "".equals(obj) ? 0 : obj);
			}
		});
		binder.registerCustomEditor(Float.TYPE, new CustomNumberEditor(Float.class, true) {
			public void setValue(Object obj) {
				super.setValue(obj == null || "".equals(obj) ? 0 : obj);
			}
		});
		binder.registerCustomEditor(Double.TYPE, new CustomNumberEditor(Double.class, true) {
			public void setValue(Object obj) {
				super.setValue(obj == null || "".equals(obj) ? 0 : obj);
			}
		});
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false) {
			public void setValue(Object obj) {
				super.setValue(obj == null ? "" : obj);
			}
		});*/
	}
}
