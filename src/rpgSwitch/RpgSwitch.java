package rpgSwitch;

import javafx.beans.property.SimpleBooleanProperty;

public class RpgSwitch {
	private SimpleBooleanProperty rpgSwitch;
	
	public RpgSwitch(boolean startSwitch) {
		this.rpgSwitch = new SimpleBooleanProperty(startSwitch);
	}
	
	public boolean getSwitch() {
		return this.rpgSwitch.getValue();
	}
	public void setSwitch(boolean x) {
		this.rpgSwitch.setValue(x);
	}
	public SimpleBooleanProperty switchProperty() {
		return rpgSwitch;
	}
}
