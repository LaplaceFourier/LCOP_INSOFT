package matlab.serviceportal.web.vo.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import matlab.serviceportal.base.vo.grid.FormVo;

public class MenuVo extends FormVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String role_id = "";
	private Integer menu_id = 0;
	private Integer parent_menu_id = 0;

	@Length(min = 1, max = 40)
	private String menu_nm = null;

	private String menu_nm_locale = null;

	@Length(min = 1, max = 20)
	private String page_nm = null;
	private String menu_link_url = null;
	private String menu_img = null;
	private String menu_view_div = null;
	private Integer menu_order = 0;
	private String functions = ""; // 권한 및 사용자에게 할당된 기능
	private String menu_functions = ""; // 메뉴에 할당된 기능
	private String menu_desc = null;
	private String use_yn = "Y";
	private List<MenuVo> sub = new ArrayList<MenuVo>();   //menu객체가 있고, 그 안에 List객체가 있음

	private String old_function_id = "";
	private String function_id = "";
	private String function_nm = "";
	private String function_nm_locale = null;
	private String string_menu = null;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public Integer getParent_menu_id() {
		return parent_menu_id;
	}

	public void setParent_menu_id(Integer parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getMenu_nm_locale() {
		return menu_nm_locale;
	}

	public void setMenu_nm_locale(String menu_nm_locale) {
		this.menu_nm_locale = menu_nm_locale;
	}

	public String getPage_nm() {
		return page_nm;
	}

	public void setPage_nm(String page_nm) {
		this.page_nm = page_nm;
	}

	public String getMenu_link_url() {
		return menu_link_url;
	}

	public void setMenu_link_url(String menu_link_url) {
		this.menu_link_url = menu_link_url;
	}

	public String getMenu_img() {
		return menu_img;
	}

	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}

	public String getMenu_view_div() {
		return menu_view_div;
	}

	public void setMenu_view_div(String menu_view_div) {
		this.menu_view_div = menu_view_div;
	}

	public Integer getMenu_order() {
		return menu_order;
	}

	public void setMenu_order(Integer menu_order) {
		this.menu_order = menu_order;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public String getMenu_functions() {
		return menu_functions;
	}

	public void setMenu_functions(String menu_functions) {
		this.menu_functions = menu_functions;
	}

	public String getMenu_desc() {
		return menu_desc;
	}

	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public List<MenuVo> getSub() {
		return sub;
	}

	public void setSub(List<MenuVo> sub) {
		this.sub = sub;
	}

	public String getOld_function_id() {
		return old_function_id;
	}

	public void setOld_function_id(String old_function_id) {
		this.old_function_id = old_function_id;
	}

	public String getFunction_id() {
		return function_id;
	}

	public void setFunction_id(String function_id) {
		this.function_id = function_id;
	}

	public String getFunction_nm() {
		return function_nm;
	}

	public void setFunction_nm(String function_nm) {
		this.function_nm = function_nm;
	}

	public String getFunction_nm_locale() {
		return function_nm_locale;
	}

	public void setFunction_nm_locale(String function_nm_locale) {
		this.function_nm_locale = function_nm_locale;
	}

	public String getFunction_id_brfore() {
		return "," + function_id;
	}

	public String getFunction_id_brfore_like() {
		return "%," + function_id;
	}

	public String getFunction_id_after() {
		return function_id + ",";
	}

	public String getFunction_id_after_like() {
		return function_id + ",%";
	}

	public String getFunction_id_brfore_after() {
		return "," + function_id + ",";
	}

	public String getFunction_id_brfore_after_like() {
		return "%," + function_id + ",%";
	}

	public String getString_menu() {
		return string_menu;
	}

	public void setString_menu(String string_menu) {
		this.string_menu = string_menu;
	}
}
