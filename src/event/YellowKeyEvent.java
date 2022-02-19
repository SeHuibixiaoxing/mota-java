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


public class YellowKeyEvent extends Event{
	public YellowKeyEvent(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch) {
		super(new Image(ImageData.keyYellow), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
	}
	
	URL url;
	Media media;
	MediaPlayer mediaPlayer;
	
	@Override
	protected void work() {
		ModelPlayerData.keyYellow.set(ModelPlayerData.keyYellow.intValue() + 1);
		url = this.getClass().getClassLoader().getResource("music/Get02.mp3");
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
