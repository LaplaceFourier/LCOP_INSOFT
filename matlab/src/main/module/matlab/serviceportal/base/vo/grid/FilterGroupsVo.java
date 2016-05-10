package matlab.serviceportal.base.vo.grid;

import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;

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
public class FilterGroupsVo {

	private String groupOp;
	private JSONArray rules;
	private JSONArray groups;

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public JSONArray getRules() {
		return rules;
	}

	public void setRules(JSONArray rules) {
		this.rules = rules;
	}

	public JSONArray getGroups() {
		return groups;
	}

	public void setGroups(JSONArray groups) {
		this.groups = groups;
	}

	@SuppressWarnings("rawtypes")
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if(groups != null && groups.size() > 0)
		{
			StringBuilder gp = new StringBuilder();
			for (int i=0;i<groups.size();i++) {
				FilterGroupsVo v2v = new FilterGroupsVo();
				try {
					BeanUtils.populate(v2v, (Map)groups.get(i));
				} catch (Exception e) {
					System.out.println(e);
				}
				if(!"".equals(v2v.toString()))
				{
					gp.append(gp.length() == 0 ? "" : (" " +groupOp + " "));
					gp.append(v2v);
				}
			}

			sb.append(gp.length() == 0 ? "" : (""+gp.toString()+""));
		}

		if(rules != null && rules.size() > 0)
		{
			StringBuilder gp = new StringBuilder();
			for (int i=0;i<rules.size();i++) {
				FilterRolesVo v2v = new FilterRolesVo();
				try {
					BeanUtils.populate(v2v, (Map)rules.get(i));
				} catch (Exception e) {
					System.out.println(e);
				}
				if(i > 0)
				{
					gp.append(gp.length() == 0 ? "" : (" " +groupOp + " "));
				}
				gp.append(v2v);
			}
			if(sb.length() == 0)
			{
				sb.append(gp.toString());
			}
			else
			{
				sb.append(gp.length() == 0 ? "" : (" " + groupOp + " ("+gp.toString()+")"));
			}
			return sb.length() == 0 ? "" : ("("+sb.toString()+")");
		}
		else
		{
			return sb.toString();
		}
	}
}
