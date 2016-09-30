package hiberproj;

public class UserEntity {
	private int uid;
	private String uname;
	private String upass;
	public int getuid() {
		return uid;
	}
	public void setuid(int uid) {
		this.uid = uid;
	}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getupass() {
		return upass;
	}
	public void setupass(String upass) {
		this.upass = upass;
	}
	public int getstatus() {
		return status;
	}
	public void setstatus(int status) {
		this.status = status;
	}
	private int status;
}
