package event;

import androlegs.mvcs.event.FlashyEvent;


public class AddEvent extends FlashyEvent {

	public static final String ADD_TEXT_ELEMENT = "addTextElement";
	
	private String mText;
	
	public AddEvent (String type, String text) {
		super(type);
		mText = text;
	}

	public String getText() {
		return mText;
	}

	public void setText(String mText) {
		this.mText = mText;
	}
}
