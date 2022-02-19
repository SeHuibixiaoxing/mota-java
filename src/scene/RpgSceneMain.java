package scene;

import java.util.ArrayList;
import javafx.geometry.Pos;
import data.MapData;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import model.ModelPlayerData;
import spirit.SpiritTile;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.ModelSwitch;



public class RpgSceneMain extends Parent{
	int sceneNum;															//��ǰ�������
	
	private ArrayList<ArrayList<SpiritTile>> spiritTile;					//����ͼ������
	private ArrayList<ArrayList<Integer>> canWalk;							//ͨ��״̬����
	
	private int rowSize;													//����
	private int lineSize;													//����
	
	private SimpleIntegerProperty row;										//����������
	private SimpleIntegerProperty line;										//����������
	
	private RpgSceneEventMain rpgSceneEventMain;							//�¼�����
	private RpgScenePane rpgScenePane;										//������峡��
	private RpgSceneTile rpgSceneTile;										//ͼ�鳡��
	private RpgSceneWalk rpgSceneWalk;										//�������߳���
	private StackPane rpgSceneGame;											//��ͼ�鳡�������߳������¼���������һ�����Ϸ����
	private RpgStorePane rpgStorePane;										//�̵����
	private HBox hBox;														//��������峡�����ѵ���塢�̵�������һ��
	
	private int startRow, startLine;										//������ʼ����
	private int startDir;													//������ʼ����
	
	
	//��ʱֻ֧�ִ�Ԥ�����ͼ������
	public RpgSceneMain(int num) {
		sceneNum = num;		
		rpgScenePane = new RpgScenePane();
		rpgStorePane = new RpgStorePane();
		loadScene(num, Integer.parseInt(MapData.startPos[num][0]), Integer.parseInt(MapData.startPos[num][1]), Integer.parseInt(MapData.startPos[num][2]));
	}
	
	void loadScene(int num, int startRow, int startLine, int startDir) {
		this.getChildren().clear();
		
		
		spiritTile = new ArrayList<ArrayList<SpiritTile>>();
		canWalk = new ArrayList<ArrayList<Integer>>();
		row = new SimpleIntegerProperty();
		line = new SimpleIntegerProperty();
		
		this.startRow = startRow;
		this.startLine = startLine;
		this.startDir = startDir;
		
		row.bindBidirectional(ModelPlayerData.row);
		line.bindBidirectional(ModelPlayerData.line);
		
		rowSize = Integer.parseInt(MapData.mapSize[num][0]);
		lineSize = Integer.parseInt(MapData.mapSize[num][1]);
		
		for(int i = 0;i < rowSize;++ i) {
			spiritTile.add(new ArrayList<SpiritTile>());
			canWalk.add(new ArrayList<Integer>());
			for(int j = 0;j < lineSize;++ j) {
				int numMapTile = MapData.mapTileSets[num][i].charAt(j) - '0';
				spiritTile.get(i).add(MapData.getSpiritTile(numMapTile));
				canWalk.get(i).add(MapData.canWalk[numMapTile].charAt(0) - '0');
			}
		}
	}
	
	//��ʼ�������������
	public void play() {
		row.set(startRow);
		line.set(startLine);
		
		rpgSceneTile = new RpgSceneTile(rowSize, lineSize, spiritTile, canWalk);
		rpgSceneWalk = new RpgSceneWalk(row, line, rowSize, lineSize, new Image(ModelPlayerData.playerWalk), ModelPlayerData.speed, startDir, canWalk);
		rpgSceneGame = new StackPane();
		rpgSceneGame.setAlignment(Pos.TOP_LEFT);
		rpgSceneEventMain = new RpgSceneEventMain(this.sceneNum, this, rpgSceneGame, rowSize, lineSize);
		rpgSceneGame.getChildren().addAll(rpgSceneTile, rpgSceneEventMain, rpgSceneWalk);
		
		hBox = new HBox(0);
		hBox.getChildren().addAll(rpgScenePane, rpgSceneGame, rpgStorePane);
		hBox.setStyle("-fx-background-color:black");
		
		this.getChildren().add(hBox);
		
		this.setOnKeyPressed((e) -> {
			if(!model.ModelSwitch.canWork.getSwitch()) return;
			if(e.getCode() == KeyCode.UP) {
				if(!rpgSceneWalk.isWalk() && ModelPlayerData.row.intValue() - 1 >= 0 && rpgSceneWalk.getCanWalk(ModelPlayerData.row.intValue() - 1, ModelPlayerData.line.intValue()) == 1) {
					int nowRow = ModelPlayerData.row.intValue() - 1, nowLine = ModelPlayerData.line.intValue();
					if(rpgSceneEventMain.getEvent(nowRow, nowLine) != null) {
						if(rpgSceneEventMain.getCanWalk(nowRow, nowLine) == 1) {
							rpgSceneWalk.walkUp();
						}
						else {
							rpgSceneWalk.dirUp();
						}
						rpgSceneEventMain.getEvent(nowRow, nowLine).run();
					}
					else {
						rpgSceneWalk.walkUp();
					}
					this.requestFocus();
				}
			}
			else if(e.getCode() == KeyCode.DOWN) {
				if(!rpgSceneWalk.isWalk() && ModelPlayerData.row.intValue() + 1 < rowSize && rpgSceneWalk.getCanWalk(ModelPlayerData.row.intValue() + 1, ModelPlayerData.line.intValue()) == 1) {
					int nowRow = ModelPlayerData.row.intValue() + 1, nowLine = ModelPlayerData.line.intValue();
					if(rpgSceneEventMain.getEvent(nowRow, nowLine) != null) {
						if(rpgSceneEventMain.getCanWalk(nowRow, nowLine) == 1) {
							rpgSceneWalk.walkDown();
						}
						else {
							rpgSceneWalk.dirDown();
						}
						rpgSceneEventMain.getEvent(nowRow, nowLine).run();
					}
					else {
						rpgSceneWalk.walkDown();
					}
					this.requestFocus();
				}
			}
			else if(e.getCode() == KeyCode.LEFT) {
				if(!rpgSceneWalk.isWalk() && ModelPlayerData.line.intValue() - 1 >= 0 && rpgSceneWalk.getCanWalk(ModelPlayerData.row.intValue(), ModelPlayerData.line.intValue() - 1) == 1) {
					int nowRow = ModelPlayerData.row.intValue(), nowLine = ModelPlayerData.line.intValue() - 1;
					if(rpgSceneEventMain.getEvent(nowRow, nowLine) != null) {
						if(rpgSceneEventMain.getCanWalk(nowRow, nowLine) == 1) {
							rpgSceneWalk.walkLeft();
						}
						else {
							rpgSceneWalk.dirLeft();
						}
						rpgSceneEventMain.getEvent(nowRow, nowLine).run();
					}
					else {
						rpgSceneWalk.walkLeft();
					}
					this.requestFocus();
				}
			}
			else if(e.getCode() == KeyCode.RIGHT) {
				if(!rpgSceneWalk.isWalk() && ModelPlayerData.line.intValue() + 1 < lineSize && rpgSceneWalk.getCanWalk(ModelPlayerData.row.intValue(), ModelPlayerData.line.intValue() + 1) == 1) {
					int nowRow = ModelPlayerData.row.intValue(), nowLine = ModelPlayerData.line.intValue() + 1;
					if(rpgSceneEventMain.getEvent(nowRow, nowLine) != null) {
						if(rpgSceneEventMain.getCanWalk(nowRow, nowLine) == 1) {
							rpgSceneWalk.walkRight();
						}
						else {
							rpgSceneWalk.dirRight();
						}
						rpgSceneEventMain.getEvent(nowRow, nowLine).run();
					}
					else {
						rpgSceneWalk.walkRight();
					}
					this.requestFocus();
				}				
			}
			else if(!rpgSceneWalk.isWalk() && (e.getCode() == KeyCode.SHIFT || e.getCode() == KeyCode.SHIFT)) {
				rpgSceneWalk.changeSpeed();
			}
		});
		
		this.requestFocus();
		
		rpgSceneTile.draw();
		rpgSceneWalk.draw();
		
	}
	
	public void stop() {
		rpgSceneTile.endDraw();
		rpgSceneWalk.stop();
		
		this.getChildren().clear();
	}
	
	//�ı䳡��
	public void changeScene(int num, int startRow, int startLine, int startDir) {
		if(sceneNum == num) return;
		sceneNum = num;
		this.loadScene(sceneNum, startRow, startLine, startDir);
		this.play();
	}
}
