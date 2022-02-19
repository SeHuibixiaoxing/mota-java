package text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import music.*;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import commonFunctions.CommonFunctions;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.net.*;

class Hahaha extends Parent {
	int a;
	void aaa(Node a) {
		this.getChildren().add(a);
	}
}

public class Text extends Application{
	public void start(Stage primaryStage) throws Exception {
		Button bt1 = new Button("awefhaejfhgekhgfkewagfjkhewahfjkaewgfjkgewah");
		
		URL url = this.getClass().getClassLoader().getResource("music/Walk0.mp3");
		
		Media media = new Media(url.toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		bt1.setOnAction(e -> {
			mediaPlayer.play();
		});
		
		Hahaha haha = new Hahaha();
		haha.aaa(bt1);
		Scene scene = new Scene(haha, 500, 600);
		primaryStage.setTitle("text");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
