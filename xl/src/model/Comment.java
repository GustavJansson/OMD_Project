package model;

public class Comment implements Slot{
	private String comment;

	@Override
	public Slot getSlotData() {
		// TODO Auto-generated method stub
		return comment;
	}

	@Override
	public void setSlotData(String s) {
		
		comment = s;
		
	}

}
