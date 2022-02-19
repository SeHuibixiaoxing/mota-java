package scene;

import javafx.scene.Parent;
import model.ModelPlayerData;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import data.ImageData;
import data.MapData;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import terms.Terms;

class NumPane extends HBox {
	private SimpleIntegerProperty num;
	private String name;
	private Font font;
	private Text nameText;
	private Text numText;
	
	NumPane(String name, SimpleIntegerProperty num) {
		super(9);
		this.num = new SimpleIntegerProperty();
		this.num.bindBidirectional(num);
		this.name = name;
		
		/*this.setScaleX(10);
		this.setScaleY(10);*/
		
		font = Font.font("΢���ź�", FontWeight.BOLD, 19);
		
		nameText = new Text(name);
		numText = new Text(String.valueOf(this.num.intValue()));
		
		nameText.setFont(font);
		numText.setFont(font);
		
		nameText.setFill(Color.WHITE);
		numText.setFill(Color.WHITE);
		
		this.getChildren().addAll(nameText, numText);
		this.setStyle("-fx-background-color:black");
		this.num.addListener(e -> {
			numText.setText(String.valueOf(num.intValue()));
		});
	}
}

class KeyPane extends HBox {
	private SimpleIntegerProperty num;
	private String text;
	private Image img;
	private ImageView imgView;
	private Font font;
	private Text textText;
	private Text numText;
	
	KeyPane(String text, SimpleIntegerProperty num, String url) {
		super(9);
		this.num = new SimpleIntegerProperty();
		this.num.bindBidirectional(num);
		this.text = text;
		font = Font.font("΢���ź�", FontWeight.BOLD, 19);
		
		textText = new Text(text);
		numText = new Text(String.valueOf(this.num.intValue()));
		
		textText.setFont(font);
		numText.setFont(font);
		
		textText.setFill(Color.WHITE);
		numText.setFill(Color.WHITE);
		
		img = new Image(url);
		imgView = new ImageView(img);
		
		this.getChildren().addAll(imgView, numText, textText);
		
		this.setStyle("-fx-background-color:black");
		this.num.addListener(e -> {
			numText.setText(String.valueOf(num.intValue()));
		});
	}
}

class FloorPane extends HBox {
	private SimpleIntegerProperty num;
	private Text text;
	private Font font;
	
	FloorPane(SimpleIntegerProperty num) {
		this.num = new SimpleIntegerProperty(0);
		this.num.bind(num);
		
		font = Font.font("΢���ź�", FontWeight.BOLD, 19);
		
		text = new Text(" ��  " + String.valueOf(num.intValue()) + "  ��");
		text.setFill(Color.WHITE);
		text.setFont(font);
		
		this.getChildren().add(text);
		
		this.num.addListener(e -> {
			text.setText(" ��  " + String.valueOf(num.intValue()) + "  ��");
		});
	}
}

class TextPane extends HBox {
	private Text text;
	private Font font;
	
	TextPane(String text) {
		font = Font.font("΢���ź�", FontWeight.BOLD, 19);
		
		this.text = new Text(text);
		this.text.setFill(Color.WHITE);
		this.text.setFont(font);
		
		this.getChildren().add(this.text);
	}
}

public class RpgScenePane extends VBox {
	private int width = 4 * MapData.tileViewWidth;					//
	private int height = MapData.row * MapData.tileViewHeight;
	private FloorPane floorPane;									//��ʾ��ǰ����
	private ImageView characterLevelPane;							//��ʾ������ͼ
	private NumPane levelPane;										//��ʾ�ȼ����
	private NumPane hpPane;											//��ʾ����ֵ���
	private NumPane attackPane;										//��ʾ����
	private NumPane defencePane;									//��ʾ����
	private NumPane goldPane;										//��ʾ��Ǯ���
	private NumPane experiencePane;									//��ʾ�������
	private KeyPane redKeyPane;										//��ɫԿ�����
	private KeyPane blueKeyPane;									//��ɫԿ�����
	private KeyPane yellowKeyPane;									//��ɫԿ�����
	private TextPane shiftPane;										//shift��ݼ�
	private TextPane wPane;											//w��ݼ�
	private TextPane rPane;											//r��ݼ�
	
	RpgScenePane() {
		super(9);
		floorPane = new FloorPane(ModelPlayerData.floor);
		characterLevelPane = new ImageView(MapData.playerFace[MapData.numPlayerWalkCommon]);
		levelPane = new NumPane(Terms.level, ModelPlayerData.level);
		hpPane = new NumPane(Terms.hp, ModelPlayerData.hp);
		attackPane = new NumPane(Terms.attack, ModelPlayerData.attack);
		defencePane = new NumPane(Terms.defence, ModelPlayerData.defence);
		goldPane = new NumPane(Terms.gold, ModelPlayerData.gold);
		experiencePane = new NumPane(Terms.experience, ModelPlayerData.experience);
		redKeyPane = new KeyPane("��", ModelPlayerData.keyRed, ImageData.keyRed);
		blueKeyPane = new KeyPane("��", ModelPlayerData.keyBlue, ImageData.keyBlue);
		yellowKeyPane = new KeyPane("��", ModelPlayerData.keyYellow, ImageData.keyYellow);
		shiftPane = new TextPane("shift:�ٶ�");
		wPane = new TextPane("w:�浵");
		rPane = new TextPane("r:����");
		
		
		this.getChildren().addAll(floorPane, characterLevelPane, levelPane, hpPane, attackPane, defencePane, goldPane, experiencePane, redKeyPane, blueKeyPane, yellowKeyPane, shiftPane, rPane, wPane);
		
		this.setWidth(this.width);
		this.setHeight(this.height);
		this.setStyle("-fx-background-color:black");
	}
}
  