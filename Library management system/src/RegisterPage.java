import java.util.Arrays;
import java.util.Random;
/**
 * 用户注册的构造函数
 * ID 由数字 随机组成的6位数字
 * type默认为1（正常）
 * @author xubo
 *
 */
public class RegisterPage {
	private static String id=null;
	private String logonName;
	private String pwd;
	private boolean gender;
	private String name;
	private Integer age;
	private String address;
	private String tell;
	private  static String type="1";
	public RegisterPage(String logonName, String pwd, boolean gender, String name, Integer age, String address,
			String tell) {
		id=initcode();
		this.logonName = logonName;
		this.pwd = pwd;
		this.gender = gender;
		this.name = name;
		this.age = age;
		this.address = address;
		this.tell = tell;
	}
	public RegisterPage(){
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + ((logonName == null) ? 0 : logonName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((tell == null) ? 0 : tell.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterPage other = (RegisterPage) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (gender != other.gender)
			return false;
		if (logonName == null) {
			if (other.logonName != null)
				return false;
		} else if (!logonName.equals(other.logonName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (tell == null) {
			if (other.tell != null)
				return false;
		} else if (!tell.equals(other.tell))
			return false;
		return true;
	}
	@Override
	public String toString() {
		if (type.equals("1")) {
			type="正常";
		}
		return "RegisterPage [id=" + id + ",logonName=" + logonName + ", pwd=" + pwd + ", gender=" + ((gender)?"��":"Ů") + ", name=" + name
				+ ", age=" + age + ", address=" + address + ", tell=" + tell + ", type=" + type + "]";
	}
	public static String getId() {
		return id;
	}
	public static String initcode() {
		Random random = new Random();
		int count = 0;
		char[] s;
		String d = "";
		String str = "1234567890";
		while (true) {

			char a = str.charAt(random.nextInt(10));
			if (d.indexOf(a, 0) == -1) {
				d += a;
				count++;
			}
			if (count == 6) {
				break;
			}
		}
		char[] c1 = d.toCharArray();
		Arrays.sort(c1);
		return d;

	}
	


}
