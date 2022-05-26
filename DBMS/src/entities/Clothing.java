package entities;

public class Clothing {
	private String size;
	private String color;
	private String type;
	private String condition;
	private String photo;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Clothing(String size, String color, String type, String condition, String photo) {
		super();
		this.size = size;
		this.color = color;
		this.type = type;
		this.condition = condition;
		this.photo = photo;
	}
	public Clothing() {
		super();
	}
	
	
	

}
