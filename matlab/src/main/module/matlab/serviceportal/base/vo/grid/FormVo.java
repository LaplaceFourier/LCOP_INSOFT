package matlab.serviceportal.base.vo.grid;

//apache에서 제공하는 클래스들. 디버깅을 편하게 할 수 있다. ToStringBuilder를 사용하여 인스턴스의 값을 
//쉽게 알아 볼 수 있다.
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import matlab.serviceportal.base.vo.BaseVo;

//json 객체와 관련된 부분을 전환할 때 쓰이는 라이브러리
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Cloud Mesh : jqGrid용 페이징 및 정렬관련 VO
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
public class FormVo extends BaseVo {
	private String sord = "";
	private String searchOper;
	private String searchString;
	private String page = "1";
	private String nd;
	private String searchField;
	private String sidx = "";
	private String filters;
	private String jqFilterQuery;
	private int rows = 0;
	private int records = 0;
	private boolean grid_search;

	private String jtSorting;
	private String jtPageSize;
	private String jtStartIndex;

	private String startdt;
	private String enddt;

	private String sort_order;

	public String getJtSorting() {
		return jtSorting;
	}

	public void setJtSorting(String jtSorting) {
		this.jtSorting = jtSorting;
	}

	public String getJtPageSize() {
		return jtPageSize;
	}

	public void setJtPageSize(String jtPageSize) {
		this.jtPageSize = jtPageSize;
	}

	public String getJtStartIndex() {
		return jtStartIndex;
	}

	public void setJtStartIndex(String jtStartIndex) {
		this.jtStartIndex = jtStartIndex;
	}

	public String getSord() {
		sord = sord.replaceAll("'", "");
		sord = sord.replaceAll("union", "");
		sord = sord.replaceAll("\"", "");
		sord = sord.replaceAll("select", "");
		sord = sord.replaceAll("--", "");
		sord = sord.replaceAll("insert", "");
		sord = sord.replaceAll("drop", "");
		sord = sord.replaceAll("update", "");
		sord = sord.replaceAll("and", "");
		sord = sord.replaceAll(">", "");
		sord = sord.replaceAll("<", "");
		sord = sord.replaceAll("if", "");
		sord = sord.replaceAll("join", "");
		sord = sord.replaceAll("\\*/", "");
		sord = sord.replaceAll("substring", "");
		sord = sord.replaceAll("/", "");
		sord = sord.replaceAll("from", "");
		sord = sord.replaceAll("\\+", "");
		sord = sord.replaceAll("where", "");
		sord = sord.replaceAll("user_tables", "");
		sord = sord.replaceAll("declare", "");
		sord = sord.replaceAll("user_table_colmns", "");
		sord = sord.replaceAll("substr", "");
		sord = sord.replaceAll("table_name", "");
		sord = sord.replaceAll("openrowset", "");
		sord = sord.replaceAll("column name", "");
		sord = sord.replaceAll("xp_", "");
		sord = sord.replaceAll("sysolums", "");
		sord = sord.replaceAll("sysobjects", "");
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSidx() {
		sidx = sidx.replaceAll("'", "");
		sidx = sidx.replaceAll("union", "");
		sidx = sidx.replaceAll("\"", "");
		sidx = sidx.replaceAll("select", "");
		sidx = sidx.replaceAll("--", "");
		sidx = sidx.replaceAll("insert", "");
		sidx = sidx.replaceAll("drop", "");
		sidx = sidx.replaceAll("update", "");
		sidx = sidx.replaceAll("and", "");
		sidx = sidx.replaceAll(">", "");
		sidx = sidx.replaceAll("<", "");
		sidx = sidx.replaceAll("if", "");
		sidx = sidx.replaceAll("join", "");
		sidx = sidx.replaceAll("\\*/", "");
		sidx = sidx.replaceAll("substring", "");
		sidx = sidx.replaceAll("/", "");
		sidx = sidx.replaceAll("from", "");
		sidx = sidx.replaceAll("\\+", "");
		sidx = sidx.replaceAll("where", "");
		sidx = sidx.replaceAll("user_tables", "");
		sidx = sidx.replaceAll("declare", "");
		sidx = sidx.replaceAll("user_table_colmns", "");
		sidx = sidx.replaceAll("substr", "");
		sidx = sidx.replaceAll("table_name", "");
		sidx = sidx.replaceAll("openrowset", "");
		sidx = sidx.replaceAll("column name", "");
		sidx = sidx.replaceAll("xp_", "");
		sidx = sidx.replaceAll("sysolums", "");
		sidx = sidx.replaceAll("sysobjects", "");
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getFilters() {
		if(grid_search && filters != null && !"".equals(filters))
		{
			JSONObject jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(filters));

			FilterGroupsVo vv = (FilterGroupsVo)JSONObject.toBean(jsonObject, FilterGroupsVo.class);
			return vv.toString();
		}
		return null;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getJqFilterQuery() {
		return jqFilterQuery;
	}

	public void setJqFilterQuery(String jqFilterQuery) {
		this.jqFilterQuery = jqFilterQuery;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public double getPage_count() {
		if(rows == 0)
			return 1;
		double temp = Math.ceil((double)records/rows);
		return temp > 0 ? temp : 1;
	}

	public boolean isGrid_search() {
		return grid_search;
	}

	public void setGrid_search(boolean grid_search) {
		this.grid_search = grid_search;
	}

	public int getOffset() {
		return (Integer.parseInt(page) - 1) * rows;
	}

	public String getStartdt() {
		return date_trim(startdt);
	}

	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}

	public String getEnddt() {
		return date_trim(enddt);
	}

	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}

	public String getSort_order() {
		return sort_order;
	}

	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	
	//org.apache.commons.lang.builder.ToStringBuilder를 이용하여 String값을 쉽게 알아 볼 수 있도록 한다.
	public String toString() {
		return ToStringBuilder.reflectionToString(
			this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
