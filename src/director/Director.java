package director;

import javafx.stage.Stage;
import scene.RpgSceneMain;
import javafx.application.Application;
import javafx.scene.Scene;
import model.ModelPlayerData;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.*;


public class Director extends Application {
	URL urlBGM;
	Media mediaBGM;
	MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		urlBGM = this.getClass().getClassLoader().getResource("music/BGM.mp3");
		mediaBGM = new Media(urlBGM.toExternalForm());
		mediaPlayer = new MediaPlayer(mediaBGM);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		
		ModelPlayerData.init();
		RpgSceneMain rpgSceneMain = new RpgSceneMain(0);
		Scene scene = new Scene(rpgSceneMain, 921, 560);
		primaryStage.setTitle("Ä§Ëþ");
		primaryStage.setScene(scene);
		rpgSceneMain.play();
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
