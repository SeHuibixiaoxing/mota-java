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

public class YellowDoorEvent extends Event {
	public YellowDoorEvent(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch) {
		super(new Image(ImageData.doorYellow), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
	}
	
	URL url;
	Media media;
	MediaPlayer mediaPlayer;
	
	@Override
	protected void work() {
		if(ModelPlayerData.keyYellow.intValue() < 1) return;
		ModelPlayerData.keyYellow.set(ModelPlayerData.keyYellow.intValue() - 1);
		
		url = this.getClass().getClassLoader().getResource("music/OpenDoor.mp3");
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
