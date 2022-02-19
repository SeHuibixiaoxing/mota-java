package battle;

import javafx.scene.layout.StackPane;

import java.net.URL;

import data.CharacterData;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import terms.Terms;
import model.ModelPlayerData;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class BattleUI {
	private StackPane rpgSceneGame;
	private BattleData battleData;
	private CharacterData player;
	private CharacterData enemy;
	
	Image playerImg;
	Image enemyImg;
	
	ImageView playerImgView;	
	ImageView enemyImgView;

	Font font;
	
	Text playerName;
	Text enemyName;
	
	Text textPlayerHp;
	Text textPlayerAttack;
	Text textPlayerDefence;
	
	Text numPlayerHp;
	Text numPlayerAttack;
	Text numPlayerDefence;
	
	Text textEnemyHp;
	Text textEnemyAttack;
	Text textEnemyDefence;
	
	Text numEnemyHp;
	Text numEnemyAttack;
	Text numEnemyDefence;

	SimpleIntegerProperty enemyHp;
	SimpleIntegerProperty playerHp;
	
	HBox playerHpPane;
	HBox playerAttackPane;
	HBox playerDefencePane;
	HBox enemyHpPane;
	HBox enemyAttackPane;
	HBox enemyDefencePane;
	
	VBox playerData;
	VBox enemyData;
	VBox playerFace;
	VBox enemyFace;
	
	HBox enemyPane;
	HBox playerPane;
	
	VBox battlePane;	
	
	public BattleUI(StackPane rpgSceneGame, CharacterData player, CharacterData enemy) {
		
		this.enemy = new CharacterData(enemy.getName(), enemy.getFacePath(), enemy.getHp(), enemy.getAttack(), enemy.getDefence());
		this.player = new CharacterData(player.getName(), player.getFacePath(), player.getHp(), player.getAttack(), player.getDefence());
		this.rpgSceneGame = rpgSceneGame;
		battleData = new BattleData(this.player, this.enemy);
		
		playerImg = new Image(this.player.getFacePath(), 200, 200, true, true);
		enemyImg = new Image(this.enemy.getFacePath(), 200, 200, true, true);
		
		playerImgView = new ImageView(playerImg);
		enemyImgView = new ImageView(enemyImg);

		font = Font.font("Î¢ÈíÑÅºÚ", FontWeight.BOLD, 30);
		
		playerName = new Text(this.player.getName());
		playerName.setFont(font);
		playerName.setFill(Color.WHEAT);
		enemyName = new Text(this.enemy.getName());
		enemyName.setFont(font);
		enemyName.setFill(Color.WHEAT);
		
		textPlayerHp = new Text(Terms.hp);
		textPlayerHp.setFont(font);
		textPlayerHp.setFill(Color.WHEAT);
		textPlayerAttack = new Text(Terms.attack);
		textPlayerAttack.setFont(font);
		textPlayerAttack.setFill(Color.WHEAT);
		textPlayerDefence = new Text(Terms.defence);
		textPlayerDefence.setFont(font);
		textPlayerDefence.setFill(Color.WHEAT);
		
		numPlayerHp = new Text(String.valueOf(this.player.getHp()));
		numPlayerHp.setFont(font);
		numPlayerHp.setFill(Color.WHEAT);
		numPlayerAttack = new Text(String.valueOf(this.player.getAttack()));
		numPlayerAttack.setFont(font);
		numPlayerAttack.setFill(Color.WHEAT);
		numPlayerDefence = new Text(String.valueOf(this.player.getAttack()));
		numPlayerDefence.setFont(font);
		numPlayerDefence.setFill(Color.WHEAT);
		
		textEnemyHp = new Text(Terms.hp);
		textEnemyHp.setFont(font);
		textEnemyHp.setFill(Color.WHEAT);
		textEnemyAttack = new Text(Terms.attack);
		textEnemyAttack.setFont(font);
		textEnemyAttack.setFill(Color.WHEAT);
		textEnemyDefence = new Text(Terms.defence);
		textEnemyDefence.setFont(font);
		textEnemyDefence.setFill(Color.WHEAT);
		
		numEnemyHp = new Text(String.valueOf(this.enemy.getHp()));
		numEnemyHp.setFont(font);
		numEnemyHp.setFill(Color.WHEAT);
		numEnemyAttack = new Text(String.valueOf(this.enemy.getAttack()));
		numEnemyAttack.setFont(font);
		numEnemyAttack.setFill(Color.WHEAT);
		numEnemyDefence = new Text(String.valueOf(this.enemy.getDefence()));
		numEnemyDefence.setFont(font);
		numEnemyDefence.setFill(Color.WHEAT);

		playerHp = new SimpleIntegerProperty(player.getHp());
		playerHp.addListener(e -> {
			this.numPlayerHp.setText(String.valueOf(playerHp.intValue()));
			
		});
		enemyHp = new SimpleIntegerProperty(enemy.getHp());
		enemyHp.addListener(e -> {
			this.numEnemyHp.setText(String.valueOf(enemyHp.intValue()));
		});
		
		playerHpPane = new HBox(10);
		playerHpPane.getChildren().addAll(this.textPlayerHp, this.numPlayerHp);
		playerAttackPane = new HBox(10);
		playerAttackPane.getChildren().addAll(this.textPlayerAttack, this.numPlayerAttack);
		playerDefencePane = new HBox(10);
		playerDefencePane.getChildren().addAll(this.textPlayerDefence, this.numPlayerDefence);
		enemyHpPane = new HBox(10);
		enemyHpPane.getChildren().addAll(this.textEnemyHp, this.numEnemyHp);
		enemyAttackPane = new HBox(10);
		enemyAttackPane.getChildren().addAll(this.textEnemyAttack, this.numEnemyAttack);
		enemyDefencePane = new HBox(10);
		enemyDefencePane.getChildren().addAll(this.textEnemyDefence, this.numEnemyDefence);
		
		playerData = new VBox(10);
		playerData.getChildren().addAll(playerHpPane, playerAttackPane, playerDefencePane);
		enemyData = new VBox(10);
		enemyData.getChildren().addAll(enemyHpPane, enemyAttackPane, enemyDefencePane);
		
		playerFace = new VBox(20);
		playerFace.getChildren().addAll(this.playerImgView, this.playerName);
		playerFace.setAlignment(Pos.CENTER);
		enemyFace = new VBox(20);
		enemyFace.getChildren().addAll(this.enemyImgView, this.enemyName);
		enemyFace.setAlignment(Pos.CENTER);

		playerPane = new HBox(50);
		playerPane.getChildren().addAll(playerFace, playerData);
		enemyPane = new HBox(50);
		enemyPane.getChildren().addAll(enemyFace, enemyData);
		
		battlePane = new VBox(20);
		battlePane.getChildren().addAll(playerPane, enemyPane);		
		battlePane.setStyle("-fx-background-color:black");
	}

	private boolean tmp = true;
	URL url;
	Media media;
	MediaPlayer mediaPlayer;
	
	public boolean draw() {
		
		if(battleData.canBattle()) {
			this.rpgSceneGame.getChildren().add(battlePane);
			Timeline timeLine = new Timeline(
					new KeyFrame(
							new Duration(550), e -> {
								url = this.getClass().getClassLoader().getResource("music/Attack.mp3");
								media = new Media(url.toExternalForm());
								mediaPlayer = new MediaPlayer(media);
								
								if(tmp && !battleData.nextRound()) {
									this.playerHp.setValue(this.player.getHp());
									this.enemyHp.setValue(this.enemy.getHp());
									mediaPlayer.play();
								}
								else if(tmp){
									this.playerHp.setValue(this.player.getHp());
									this.enemyHp.setValue(this.enemy.getHp());
									ModelPlayerData.hp.setValue(this.player.getHp());
									this.rpgSceneGame.getChildren().removeAll(battlePane);	
									tmp = false;
								}
							}));
			timeLine.setCycleCount(Timeline.INDEFINITE);
			timeLine.play();
			return true;
		}
		return false;
	}
}
