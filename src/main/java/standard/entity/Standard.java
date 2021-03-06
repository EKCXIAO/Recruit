package standard.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Standard {
	@Id
	@GeneratedValue
	private int  id;
	private String std_num;
	private String zhname;
	private String version;
	private String keys;
	private Date release_date;
	private Date impl_date;
	private String package_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_num() {
		return std_num;
	}
	public void setStd_num(String std_num) {
		this.std_num = std_num;
	}
	public String getZhname() {
		return zhname;
	}
	public void setZhname(String zhname) {
		this.zhname = zhname;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public Date getImpl_date() {
		return impl_date;
	}
	public void setImpl_date(Date impl_date) {
		this.impl_date = impl_date;
	}
	public String getPackage_path() {
		return package_path;
	}
	public void setPackage_path(String package_path) {
		this.package_path = package_path;
	}
	
	public String getRelease_dates() {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日" );		
		return sdf.format(release_date);
	}
	public String getImpl_dates() {
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日" );
		return sdf.format(impl_date);		
	}
	
}
 