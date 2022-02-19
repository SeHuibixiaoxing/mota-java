package event;

import java.net.URL;

import data.ImageData;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import rpgSwitch.RpgSwitch;
import javafx.scene.image.Image;
import model.ModelPlayerData;
import scene.RpgSceneMain;

public class HpRedEvent extends Event {
	public HpRedEvent(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch) {
		super(new Image(ImageData.hpRed), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
	}
	
	@Override
	protected void work() {
		ModelPlayerData.hp.set(ModelPlayerData.hp.intValue() + 200);
		URL url = this.getClass().getClassLoader().getResource("music/Get.mp3");
		Media media = new Media(url.toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(1);
		mediaPlayer.play();
		super.privateSwitch.setSwitch(false);
		super.canWalk = 1;
		super.spirit.stop();
		super.spirit.clearFrame();
	}
}
