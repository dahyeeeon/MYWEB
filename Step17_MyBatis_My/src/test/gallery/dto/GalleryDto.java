package test.gallery.dto;

public class GalleryDto {
	private int num; //번호. primary key
	private String writer; //작성자
	private String caption; //이미지 설명
	private String imagePath; //이미지 경로(/upload/kim1.png)
	private String regdate; //등록일
	
	//기본 생성자
	public GalleryDto() {}

	public GalleryDto(int num, String writer, String caption, String imagePath, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.caption = caption;
		this.imagePath = imagePath;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
