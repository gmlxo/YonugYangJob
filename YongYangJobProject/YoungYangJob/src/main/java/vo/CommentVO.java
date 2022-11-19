package vo;

public class CommentVO {
	private String com_idx;
	private String ity_idx;
	private String user_id;
	private String com_day;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCom_day() {
		return com_day;
	}

	public void setCom_day(String com_day) {
		this.com_day = com_day;
	}

	public String getCom_contents() {
		return com_contents;
	}

	public void setCom_contents(String com_contents) {
		this.com_contents = com_contents;
	}
}
