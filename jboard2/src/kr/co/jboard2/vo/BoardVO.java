package kr.co.jboard2.vo;

public class BoardVO {

	private int seq;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	private String nick;
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getSeq() {
		return seq;
	}
	public int getParent() {
		return parent;
	}
	public int getComment() {
		return comment;
	}
	public String getCate() {
		return cate;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getFile() {
		return file;
	}
	public int getHit() {
		return hit;
	}
	public String getUid() {
		return uid;
	}
	public String getRegip() {
		return regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
}
