package scene;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ModelPlayerData;
import javafx.scene.control.Button;

public class RpgStorePane extends Parent {
	private Font fontTitle;
	private Font fontText;
	
	private Text textGoldTitle;
	private Text textExeTitle;
	
	private Text textGoldHp;
	private Text textGoldAttack;
	private Text textGoldDefence;

	private Text textExeLevel;
	private Text textExeAttack;
	private Text textExeDefence;
	
	private Button btGoldHp;
	private Button btGoldAttack;
	private Button btGoldDefence;

	private Button btExeLevel;
	private Button btExeAttack;
	private Button btExeDefence;
	
	private HBox goldHp;
	private HBox goldAttack;
	private HBox goldDefence;

	private HBox exeLevel;
	private HBox exeAttack;
	private HBox exeDefence;
	
	private VBox goldStore;
	private VBox exeStore;
	
	private VBox store;
	
	public RpgStorePane() {
		fontTitle = Font.font("΢���ź�", FontWeight.EXTRA_BOLD, 30);
		fontText = Font.font("΢���ź�", FontWeight.MEDIUM, 20);
		
		textGoldTitle = new Text("����̵�");
		textGoldTitle.setFont(fontTitle);
		textGoldTitle.setFill(Color.WHITE);
		textExeTitle = new Text("�����̵�");
		textExeTitle.setFont(fontTitle);
		textExeTitle.setFill(Color.WHITE);
		
		textGoldHp = new Text("25��� ����800������");
		textGoldHp.setFont(fontText);
		textGoldHp.setFill(Color.WHITE);
		textGoldAttack = new Text("25��� ����4�㹥��");
		textGoldAttack.setFont(fontText);
		textGoldAttack.setFill(Color.WHITE);
		textGoldDefence = new Text("25��� ����4�����");
		textGoldDefence.setFont(fontText);
		textGoldDefence.setFill(Color.WHITE);
		
		textExeAttack = new Text("30���� 5����");
		textExeAttack.setFont(fontText);
		textExeAttack.setFill(Color.WHITE);
		textExeDefence = new Text("30���� 5����");
		textExeDefence.setFont(fontText);
		textExeDefence.setFill(Color.WHITE);
		textExeLevel = new Text("100���� �����ȼ�");
		textExeLevel.setFont(fontText);
		textExeLevel.setFill(Color.WHITE);
		
		 btGoldHp = new Button("����");
		 btGoldHp.setOnAction(e -> {
			 if(ModelPlayerData.gold.intValue() < 25) return;
			 ModelPlayerData.gold.set(ModelPlayerData.gold.intValue() - 25);
			 ModelPlayerData.hp.set(ModelPlayerData.hp.intValue() + 800);
			 
		 });
		 btGoldAttack = new Button("����");
		 btGoldAttack.setOnAction(e -> {
			 if(ModelPlayerData.gold.intValue() < 25) return;
			 ModelPlayerData.gold.set(ModelPlayerData.gold.intValue() - 25);
			 ModelPlayerData.attack.set(ModelPlayerData.attack.intValue() + 4);
		 });
		 btGoldDefence = new Button("����");
		 btGoldDefence.setOnAction(e -> {
			 if(ModelPlayerData.gold.intValue() < 25) return;
			 ModelPlayerData.gold.set(ModelPlayerData.gold.intValue() - 25);
			 ModelPlayerData.defence.set(ModelPlayerData.defence.intValue() + 4);
		 });

		 btExeLevel = new Button("����");
		 btExeLevel.setOnAction(e -> {
			 if(ModelPlayerData.experience.intValue() < 100) return;
			 ModelPlayerData.experience.set(ModelPlayerData.experience.intValue() - 100);
			 ModelPlayerData.level.set(ModelPlayerData.level.intValue() + 1);
			 ModelPlayerData.hp.set(ModelPlayerData.hp.intValue() + 500);
			 ModelPlayerData.attack.set(ModelPlayerData.attack.intValue() + 7);
			 ModelPlayerData.defence.set(ModelPlayerData.defence.intValue() + 7);
		 });
		 btExeAttack = new Button("����");
		 btExeAttack.setOnAction(e -> {
			 if(ModelPlayerData.experience.intValue() < 30) return;
			 ModelPlayerData.experience.set(ModelPlayerData.experience.intValue() - 30);
			 ModelPlayerData.attack.set(ModelPlayerData.attack.intValue() + 5);
		 });
		 btExeDefence = new Button("����");
		 btExeDefence.setOnAction(e -> {
			 if(ModelPlayerData.experience.intValue() < 30) return;
			 ModelPlayerData.experience.set(ModelPlayerData.experience.intValue() - 30);
			 ModelPlayerData.defence.set(ModelPlayerData.defence.intValue() + 5);
		 });
		
		 goldHp = new HBox(10);
		 goldHp.getChildren().addAll(this.btGoldHp, this.textGoldHp);
		 
		 goldAttack = new HBox(10);
		 goldAttack.getChildren().addAll(this.btGoldAttack, this.textGoldAttack);
		 
		 goldDefence = new HBox(10);
		 goldDefence.getChildren().addAll(this.btGoldDefence, this.textGoldDefence);

		 
		 exeLevel = new HBox(10);
		 exeLevel.getChildren().addAll(this.btExeLevel, this.textExeLevel);
		 
		 exeAttack = new HBox(10);
		 exeAttack.getChildren().addAll(this.btExeAttack, this.textExeAttack);
		 
		 exeDefence = new HBox(10);
		 exeDefence.getChildren().addAll(this.btExeDefence, this.textExeDefence);
		
		 goldStore = new VBox(20);
		 goldStore.getChildren().addAll(this.textGoldTitle, this.goldHp, this.goldAttack, this.goldDefence);
		 exeStore = new VBox(20);
		 exeStore.getChildren().addAll(this.textExeTitle, this.exeLevel, this.exeAttack, this.exeDefence);
		
		 store = new VBox(100);
		 store.getChildren().addAll(goldStore, exeStore);
		 
		 this.getChildren().add(store);
		 this.setStyle("-fx-background-color:black");
	}
	
	
}
