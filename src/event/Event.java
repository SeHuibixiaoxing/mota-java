package event;

import data.CommonData;
import data.MapData;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import spirit.Spirit;
import javafx.scene.layout.StackPane;
import model.ModelPlayerData;
import rpgSwitch.RpgSwitch;
import javafx.scene.image.Image;
import scene.RpgSceneMain;
import battle.BattleData;
import battle.BattleUI;
import data.CharacterData;

/*
 * ÿ��дһ�����¼������̳�Event�ӿڣ���ʵ��run�ӿ�
 * */

public abstract class Event extends Parent {
	protected Spirit spirit;										//�¼�����
	protected StackPane rpgSceneGame;								//��Ϸ��������
	protected RpgSceneMain rpgSceneMain;							//��Ϸ�����棬���ڳ����л��Ĳٿ�
	protected int row;
	protected int line;
	protected RpgSwitch privateSwitch;
	protected int canWalk;
	
	protected abstract void work();
	public void run() {
		if(privateSwitch.getSwitch()) {
			this.requestFocus();
			model.ModelSwitch.canWork.setSwitch(false);
			work();
			model.ModelSwitch.canWork.setSwitch(true);
		}
	}
	
	public Event(Image imgSets, StackPane rpgSceneGame, RpgSceneMain rpgSceneMain, int row, int line, RpgSwitch privateSwitch, int canWalk) {
		spirit = new Spirit(MapData.tileViewWidth, MapData.tileViewHeight, imgSets, Timeline.INDEFINITE, MapData.tileFileWidth, MapData.tileFileHeight, MapData.tileViewWidth, MapData.tileViewHeight);
		this.rpgSceneGame = rpgSceneGame;
		this.rpgSceneMain = rpgSceneMain;
		this.row = row;
		this.line = line;
		this.privateSwitch = privateSwitch;
		this.canWalk = canWalk;
		if(!this.privateSwitch.getSwitch()) {
			this.canWalk = 1;
		}
		
		spirit.setFrameAnimation(CommonData.indefiniteDurationMillis, 0, 0, 0);
		
		this.getChildren().add(spirit);
	}
	

	public void draw() {
		if(this.privateSwitch.getSwitch())
			spirit.draw();
	}
	
	public void stop() {
		spirit.stop();
	}
	
	
	/*
	 * �����¼�����
	 * */
	
	//������ת�¼������ú�Ӧ�����������¼�
	protected void changeScene(int num, int startRow, int startLine, int startDir) {
		this.rpgSceneMain.changeScene(num, startRow, startLine, startDir);
		ModelPlayerData.row.setValue(startRow);
		ModelPlayerData.line.setValue(startLine);
		ModelPlayerData.floor.setValue(num);
	}
	
	//ս���¼�
	protected boolean battle(CharacterData enemy) {
		BattleUI battleUI = new BattleUI(this.rpgSceneGame, new CharacterData("��ʿ", ModelPlayerData.playerFace, ModelPlayerData.hp.intValue(), ModelPlayerData.attack.intValue(), ModelPlayerData.defence.intValue()), enemy);		
		return battleUI.draw();
	}
	
	/*
	 * �����޸Ļ�ȡ
	 * */
	public Spirit getSpirit() {
		return spirit;
	}
	
	public int getCanWalk() {
		return canWalk;
	}

	public void setCanWalk(int canWalk) {
		this.canWalk = canWalk;
	}
	
}
