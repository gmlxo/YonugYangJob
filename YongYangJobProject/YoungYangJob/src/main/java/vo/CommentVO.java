package vo;

public class CommentVO {
	private String com_idx;
	private String ity_idx;
	private String userid;
	private String com_contents;
	
	public CommentVO() {
		super();
	}

	public String getCom_idx() {
		return com_idx;
	}

	public void setCom_idx(String com_idx) {
		this.com_idx = com_idx;
	}

	public String getIty_idx() {
		return ity_idx;
	}

	public void setIty_idx(String ity_idx) {
		this.ity_idx = ity_idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCom_contents() {
		return com_contents;
	}

	public void setCom_contents(String com_contents) {
		this.com_contents = com_contents;
	}
}
