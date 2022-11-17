package vo;

public class EnterpriseVO {
	private String ent_name;
	private String sectors;
	private String establishment_date;
	private String representative;
	private String address;
	private String url;
	
	public EnterpriseVO() {
		super();
	}

	public String getEnt_name() {
		return ent_name;
	}

	public void setEnt_name(String ent_name) {
		this.ent_name = ent_name;
	}

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
	}

	public String getEstablishment_date() {
		return establishment_date;
	}

	public void setEstablishment_date(String establishment_date) {
		this.establishment_date = establishment_date;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}