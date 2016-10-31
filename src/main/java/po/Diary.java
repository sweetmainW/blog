package po;

import java.util.Date;

public class Diary {
	private Integer lid;
	private String title;
	private String text;
	private Date lcreateTime;
	private Integer uid;
	
	public Diary() {
		super();
	}
	public Diary(Integer lid, String title, String text, Date lcreateTime, Integer uid) {
		super();
		this.lid = lid;
		this.title = title;
		this.text = text;
		this.lcreateTime = lcreateTime;
		this.uid = uid;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getLcreateTime() {
		return lcreateTime;
	}
	public void setLcreateTime(Date lcreateTime) {
		this.lcreateTime = lcreateTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Diary [lid=" + lid + ", title=" + title + ", text=" + text + ", lcreateTime=" + lcreateTime + ", uid="
				+ uid + "]";
	}
	
}
