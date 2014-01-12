package event;

import androlegs.mvcs.event.FlashyEvent;


public class DeleteEvent extends FlashyEvent {

	public static final String DELETE_SINGLE_ELEMENT = "deletesingleelement";
	public static final String DELETE_ALL_ELEMENTS = "deleteAllElements";
	
	private int mElementId;
	
	public DeleteEvent (String type) {
		super(type);
		this.mElementId = -1;	
	}

	public DeleteEvent (String type, int elementId) {
		super(type);
		this.mElementId = elementId;	
	}

	public int getmElementId() {
		return mElementId;
	}

	public void setmElementId(int mElementId) {
		this.mElementId = mElementId;
	}
}
