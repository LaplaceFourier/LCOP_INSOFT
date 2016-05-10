package matlab.serviceportal.web.vo.system;

import matlab.serviceportal.base.vo.grid.FormVo;

import java.io.Serializable;
import java.lang.reflect.Field;

//Apache Commons regexp 오픈 소스를 사용하여 String 관련 기능을 제공 
import egovframework.rte.fdl.string.EgovStringUtil;

public class UserVo extends FormVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String role_id = "";
	private String role_cd = "";
	private String role_nm = "";
	private String role_nm_locale = "";
	private String user_nm;
	private String user_pwd;
	private String email;
	private String dept_id;
	private String dept_nm;
	private String phone;
	private String user_div_cd;
	private String user_div_nm;
	private String not_user_div_cd;
	private String use_yn = "Y";
	private String find_type;
	private String tel;
	private String approve_yn;
	private String personal_info_use = "N";
	private String company;
	private String position_div_nm;
	private String position_div_cd;
	private String ex_user_id;
	private String grp_yn;
	private String approve_join_yn = "Y";
	private String except_menu_nm = "";

	public String getExcept_menu_nm() {
		return except_menu_nm;
	}

	public void setExcept_menu_nm(String except_menu_nm) {
		this.except_menu_nm = except_menu_nm;
	}

	public String[] getExcept_menu_nm_arr() {
		return EgovStringUtil.isEmpty(except_menu_nm) ? null : except_menu_nm.split(",");
	}
	
	public String getApprove_join_yn() {
		return approve_join_yn;
	}

	public void setApprove_join_yn(String approve_join_yn) {
		this.approve_join_yn = approve_join_yn;
	}

	public String getEx_user_id() {
		return ex_user_id;
	}

	public void setEx_user_id(String ex_user_id) {
		this.ex_user_id = ex_user_id;
	}

	public String getGrp_yn() {
		return grp_yn;
	}

	public void setGrp_yn(String grp_yn) {
		this.grp_yn = grp_yn;
	}

	public String getApprove_yn() {
		return approve_yn;
	}

	public void setApprove_yn(String approve_yn) {
		this.approve_yn = approve_yn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFind_type() {
		return find_type;
	}

	public void setFind_type(String find_type) {
		this.find_type = find_type;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_cd() {
		return role_cd;
	}

	public void setRole_cd(String role_cd) {
		this.role_cd = role_cd;
	}

	public String getRole_nm_locale() {
		return role_nm_locale;
	}

	public void setRole_nm_locale(String role_nm_locale) {
		this.role_nm_locale = role_nm_locale;
	}

	public String getRole_nm() {
		return role_nm;
	}

	public void setRole_nm(String role_nm) {
		this.role_nm = role_nm;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser_div_cd() {
		return user_div_cd;
	}

	public void setUser_div_cd(String user_div_cd) {
		this.user_div_cd = user_div_cd;
	}

	public String[] getUser_div_cds() {
		return user_div_cd == null || "".equals(user_div_cd) ? null
				: user_div_cd.split(",");
	}

	public String getNot_user_div_cd() {
		return not_user_div_cd;
	}

	public void setNot_user_div_cd(String not_user_div_cd) {
		this.not_user_div_cd = not_user_div_cd;
	}

	public String[] getNot_user_div_cds() {
		return not_user_div_cd == null || "".equals(not_user_div_cd) ? null
				: not_user_div_cd.split(",");
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getPersonal_info_use() {
		return personal_info_use;
	}

	public void setPersonal_info_use(String personal_info_use) {
		this.personal_info_use = personal_info_use;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUser_div_nm() {
		return user_div_nm;
	}

	public void setUser_div_nm(String user_div_nm) {
		this.user_div_nm = user_div_nm;
	}

	public String getPosition_div_nm() {
		return position_div_nm;
	}

	public void setPosition_div_nm(String position_div_nm) {
		this.position_div_nm = position_div_nm;
	}

	public String getPosition_div_cd() {
		return position_div_cd;
	}

	public void setPosition_div_cd(String position_div_cd) {
		this.position_div_cd = position_div_cd;
	}

	public Object getField_value(Field field, Object o) {
		try {
			return field.getName() + ":\"" + field.get(o) + "\"";
		} catch (Exception e) {
			return "";
		}
	}

	public String toString() {
		Field[] fields = getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
		}
		return new StringBuilder().append("{").append("user_id").append(":\"")
				.append(getUser_id()).append("\",").append("user_nm")
				.append(":\"").append(getRole_id()).append("\",")
				.append("role_id").append(":\"").append(getUser_nm())
				.append("\",").append("user_pwd").append(":\"")
				.append(getUser_pwd()).append("\",").append("email")
				.append(":\"").append(getEmail()).append("\",")
				.append("create_dtm").append(":\"").append(getCreate_dtm())
				.append("\",").append("create_user_id").append(":\"")
				.append(getCreate_user_id()).append("\",").append("dept_id")
				.append(":\"").append(getDept_id()).append("\",")
				.append("dept_nm").append(":\"").append(getDept_nm())
				.append("\",").append("phone").append(":\"").append(getPhone())
				.append("\",").append("user_div_cd")
				.append(":\"").append(getUser_div_cd()).append("\",")
				.append("use_yn").append(":\"").append(getUse_yn())
				.append("\",").append("find_type").append(":\"")
				.append(getFind_type()).append("\",").append("update_user_id")
				.append(":\"").append(getUpdate_user_id()).append("\",")
				.append("update_dtm").append(":\"").append(getUpdate_dtm())
				.append("\",").append("tel").append(":\"").append(getTel())
				.append("\",").append("approve_yn").append(":\"")
				.append(getCompany()).append("\",").append("company")
				.append(":\"").append(getApprove_yn()).append("\",")
				.append("personal_info_use").append(":\"")
				.append(getPersonal_info_use()).append("\"}").toString();
	}
}
