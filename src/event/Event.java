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
 * 每编写一个新事件，都继承Event接口，并实现run接口
 * */

public abstract class Event extends Parent {
	protected Spirit spirit;										//事件精灵
	protected StackPane rpgSceneGame;								//游戏界面引用
	protected RpgSceneMain rpgSceneMain;							//游戏主界面，用于场景切换的操控
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
	 * 各类事件方法
	 * */
	
	//场景调转事件，调用后应该立即结束事件
	protected void changeScene(int num, int startRow, int startLine, int startDir) {
		this.rpgSceneMain.changeScene(num, startRow, startLine, startDir);
		ModelPlayerData.row.setValue(startRow);
		ModelPlayerData.line.setValue(startLine);
		ModelPlayerData.floor.setValue(num);
	}
	
	//战斗事件
	protected boolean battle(CharacterData enemy) {
		BattleUI battleUI = new BattleUI(this.rpgSceneGame, new CharacterData("勇士", ModelPlayerData.playerFace, ModelPlayerData.hp.intValue(), ModelPlayerData.attack.intValue(), ModelPlayerData.defence.intValue()), enemy);		
		return battleUI.draw();
	}
	
	/*
	 * 属性修改获取
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
