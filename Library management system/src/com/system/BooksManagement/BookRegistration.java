package com.system.BooksManagement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class BookRegistration {
	private static String id;
	private String bookName;
	private String authorName;
	private double price;
	private String press;
	private Date date;
	private String type;
	SimpleDateFormat sdf;
	public BookRegistration(String bookName,String authorName, double price, String press,String type) {
		id=initcode();
		this.bookName=bookName;
		this.authorName = authorName;
		this.price = price;
		this.press = press;
		this.type = type;
		Calendar calendar=Calendar.getInstance();
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		date=calendar.getTime();
		
	}
	public BookRegistration() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((press == null) ? 0 : press.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BookRegistration other = (BookRegistration) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (press == null) {
			if (other.press != null)
				return false;
		} else if (!press.equals(other.press))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

	public static String getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public double getPrice() {
		return price;
	}

	public String getPress() {
		return press;
	}

	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	@Override
	public String toString() {
		if (type.equals("1")) {
			type="java";
		}
		if (type.equals("2")) {
			type=".net";
		}
		if (type.equals("3")) {
			type="android";
		}
		if (type.equals("1")) {
			type="ios";
		}
		return "BookRegistration [id=" + id + ", bookName=" + bookName+ ",authorName=" + authorName + ", price=" + price + ", press=" + press + ", date=" + sdf.format(date)
				+ ", type=" + type + "]";
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
