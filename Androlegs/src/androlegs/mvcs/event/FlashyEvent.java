package androlegs.mvcs.event;

public class FlashyEvent {

	private String mType;

	public FlashyEvent(String type) {
		this.mType = type;
	}
	
	public String getType() {
		return mType;
	}

	public void setType(String type) {
		this.mType = type;
	}
}
