package matlab.serviceportal.base.vo.grid;

/**
 * Cloud Mesh : jqGrid 검색조건 파싱용
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
public class FilterRolesVo {

	private String field;
	private String op;
	private String data;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOp() {

		if("ne".equals(op)) return " != ";
		if("lt".equals(op)) return " < ";
		if("le".equals(op)) return " <= ";
		if("gt".equals(op)) return " > ";
		if("ge".equals(op)) return " >= ";
		if("in".equals(op)) return " in ";
		if("ni".equals(op)) return " not in ";
		if("bw".equals(op) || "ew".equals(op) || "cn".equals(op)) return " like ";
		if("bn".equals(op) || "en".equals(op) || "nc".equals(op)) return " not like ";

		return " = ";
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getData() {
		if("bw".equals(op) || "bn".equals(op)) return data + "%";
		if("ew".equals(op) || "en".equals(op)) return "%" + data;
		if("cn".equals(op) || "nc".equals(op)) return "%" + data + "%";

		if("".equals(op) || "".equals(op)) return data + "%";
		if("".equals(op) || "".equals(op)) return data + "%";
			
//		if(opC === 'bw' || opC === 'bn') { val = val+"%"; }
//		if(opC === 'ew' || opC === 'en') { val = "%"+val; }
//		if(opC === 'cn' || opC === 'nc') { val = "%"+val+"%"; }
//		//if(opC === 'in' || opC === 'ni') { val = " ("+val+")"; }
//
//		ret = rule.field + " " + opUF + " (\"" + val + "\")";
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

//	if($.inArray(cm.searchtype, numtypes) !== -1 || opC === 'nn' || opC === 'nu') {
//		if(opC === 'bw' || opC === 'bn') { val = val+"%"; }
//		if(opC === 'ew' || opC === 'en') { val = "%"+val; }
//		if(opC === 'cn' || opC === 'nc') { val = "%"+val+"%"; }
//		if(opC === 'in' || opC === 'ni') { val = " ("+val+")"; }
//
//		ret = rule.field + " " + opUF + " " + val;
//	}
//	else
//	{
//		if(opC === 'bw' || opC === 'bn') { val = val+"%"; }
//		if(opC === 'ew' || opC === 'en') { val = "%"+val; }
//		if(opC === 'cn' || opC === 'nc') { val = "%"+val+"%"; }
//		//if(opC === 'in' || opC === 'ni') { val = " ("+val+")"; }
//
//		ret = rule.field + " " + opUF + " (\"" + val + "\")";
	public String toString() {
		return field + " " + getOp() + " '" + getData() + "'";
	}
}
