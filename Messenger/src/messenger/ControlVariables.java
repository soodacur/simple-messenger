package messenger;

public class ControlVariables {
	
	private boolean toStopOtherConnWaiter;
	private boolean toStopUserRequestWaiter;
	public synchronized boolean isToStopOtherConnWaiter() {
		return toStopOtherConnWaiter;
	}
	public synchronized void setToStopOtherConnWaiter(boolean toStopOtherConnWaiter) {
		this.toStopOtherConnWaiter = toStopOtherConnWaiter;
	}
	public synchronized boolean isToStopUserRequestWaiter() {
		return toStopUserRequestWaiter;
	}
	public synchronized void setToStopUserRequestWaiter(boolean toStopUserRequestWaiter) {
		this.toStopUserRequestWaiter = toStopUserRequestWaiter;
	}
	
}
