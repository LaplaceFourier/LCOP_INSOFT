package matlab.serviceportal.base.vo;

import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Cloud Mesh : 공통  VO
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

public class BaseVo {

	@Autowired protected Properties sysProps;
	
	public static final Logger logger = LoggerFactory.getLogger(BaseVo.class);
	
	public interface View {};

	public interface Create {};

	public interface Modify {};

	public interface Delete {};

	private String site_id = "1";
	private String site_nm = "";
	private String user_id;
	private String user_nm;

	private String dept_id;
	private String dept_nm;

	private String create_dt = "";
	private String create_dtm = "";
	private String create_user_id = "";
	private String create_user_nm = "";

	private String update_dt = "";
	private String update_dtm = "";
	private String update_user_id = "";
	private String update_user_nm = "";

	private String from_dt = "";
	private String to_dt = "";

	private Object proc_result = null;
	
	public String date_trim(String value) {
		return value == null ? "" : value.replaceAll("[-/. :]", "");
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getSite_nm() {
		return site_nm;
	}

	public void setSite_nm(String site_nm) {
		this.site_nm = site_nm;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
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

	public Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}

	public String getCreate_dt() {
		return date_trim(create_dt);
	}

	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}

	public String getCreate_dtm() {
		return date_trim(create_dtm);
	}

	public void setCreate_dtm(String create_dtm) {
		this.create_dtm = create_dtm;
	}

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	public String getCreate_user_nm() {
		return create_user_nm;
	}

	public void setCreate_user_nm(String create_user_nm) {
		this.create_user_nm = create_user_nm;
	}

	public String getUpdate_dt() {
		return date_trim(update_dt);
	}

	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}

	public String getUpdate_dtm() {
		return date_trim(update_dtm);
	}

	public void setUpdate_dtm(String update_dtm) {
		this.update_dtm = update_dtm;
	}

	public String getUpdate_user_id() {
		return update_user_id;
	}

	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}

	public String getUpdate_user_nm() {
		return update_user_nm;
	}

	public void setUpdate_user_nm(String update_user_nm) {
		this.update_user_nm = update_user_nm;
	}

	public String getFrom_dt() {
		return date_trim(from_dt);
	}

	public void setFrom_dt(String from_dt) {
		this.from_dt = from_dt;
	}

	public String getTo_dt() {
		return date_trim(to_dt);
	}

	public void setTo_dt(String to_dt) {
		this.to_dt = to_dt;
	}

	public Locale get_locale() {
		return LocaleContextHolder.getLocale();
	}

	public Object getProc_result() {
		return proc_result;
	}

	public void setProc_result(Object proc_result) {
		this.proc_result = proc_result;
	}

}