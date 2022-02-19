package event;

import data.CommonData;
import data.ImageData;
import data.EnemyCharacterData;
import javafx.scene.layout.StackPane;
import rpgSwitch.RpgSwitch;
import javafx.scene.image.Image;
import model.ModelPlayerData;
import scene.RpgSceneMain;
import java.util.*;

public class BattleEvent01 extends Event {
	public BattleEvent01(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch) {
		super(new Image(ImageData.enemy01), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
		super.spirit.setFrameAnimation(CommonData.fourFrameDurationMillis, 0, 0, 0, 1, 2, 3);
	}
	
	@Override
	protected void work() {
		if(this.battle(EnemyCharacterData.enemy01)) {
			ModelPlayerData.gold.setValue(ModelPlayerData.gold.intValue() + 10000);
			ModelPlayerData.experience.setValue(ModelPlayerData.experience.intValue() + 40000);
			super.privateSwitch.setSwitch(false);
			super.canWalk = 1;
			super.spirit.stop();
			super.spirit.clearFrame();
		}
	}
}
