package model;

public class Comment implements Slot{
	private String comment;
	
	public Comment(String s) {
		comment = s;
	}

	@Override
	public String getSlotData() {
		// TODO Auto-generated method stub
		return comment;
	}

	@Override
	public void setSlotData(String s) {
		
		comment = s;
		
	}

}
