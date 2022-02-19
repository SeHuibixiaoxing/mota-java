package event;

import java.net.URL;

import data.CommonData;
import data.ImageData;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.ModelPlayerData;
import rpgSwitch.RpgSwitch;
import scene.RpgSceneMain;

public class UpStairsEvent extends Event {
	
	private int startDir, startRow, startLine;
	
	public UpStairsEvent(StackPane rpgScene, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch, int startRow, int startLine, int startDir) {
		super(new Image(ImageData.upStairs), rpgScene, rpgSceneMain, row, line, privateSwitch, 0);
		this.startDir = startDir;
		this.startRow = startRow;
		this.startLine = startLine;
	}
	
	URL url;
	Media media;
	MediaPlayer mediaPlayer;
	
	@Override
	protected void work() {
		if(ModelPlayerData.floor.intValue() + 1 > CommonData.floorNum) return;
		url = this.getClass().getClassLoader().getResource("music/ChangeFloor.mp3");
		media = new Media(url.toExternalForm());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(1);
		mediaPlayer.play();
		super.changeScene(ModelPlayerData.floor.intValue() + 1, startRow, startLine, startDir);
	}
}
