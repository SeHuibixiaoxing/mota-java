package event;

import data.CommonData;
import data.ImageData;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import rpgSwitch.RpgSwitch;
import javafx.scene.image.Image;
import model.ModelPlayerData;
import scene.RpgSceneMain;
import java.net.URL;
import java.util.*;

public class BigGoldEvent extends Event {
	public BigGoldEvent(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch) {
		super(new Image(ImageData.BigGold), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
	}
	
	URL url;
	Media media;
	MediaPlayer mediaPlayer;
	
	@Override
	protected void work() {
		ModelPlayerData.gold.set(ModelPlayerData.gold.intValue() + 1000);
		ModelPlayerData.experience.set(ModelPlayerData.experience.intValue() + 1000);
		
		url = this.getClass().getClassLoader().getResource("music/Get.mp3");
		media = new Media(url.toExternalForm());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(1);
		mediaPlayer.play();
		
		super.privateSwitch.setSwitch(false);
		super.canWalk = 1;
		super.spirit.stop();
		super.spirit.clearFrame();
	}
}
