package model;

import data.CommonData;
import data.MapData;
import javafx.beans.property.SimpleIntegerProperty;

public class ModelPlayerData {	
	private ModelPlayerData(){}
	public static String name;															//名称
	public static SimpleIntegerProperty level = new SimpleIntegerProperty();			//等级
	public static SimpleIntegerProperty hp = new SimpleIntegerProperty();				//生命值
	public static SimpleIntegerProperty attack = new SimpleIntegerProperty();			//攻击力
	public static SimpleIntegerProperty defence = new SimpleIntegerProperty();			//防御力
	public static SimpleIntegerProperty row = new SimpleIntegerProperty();				//人物x坐标
	public static SimpleIntegerProperty line = new SimpleIntegerProperty();				//人物y坐标
	public static SimpleIntegerProperty speed = new SimpleIntegerProperty();			//行走速度,每帧X轴移动坐标，Y轴按比例移动
	public static String playerWalk;													//玩家行走图
	public static String playerFace;													//玩家脸图
	public static SimpleIntegerProperty keyYellow = new SimpleIntegerProperty();		//黄色钥匙数
	public static SimpleIntegerProperty keyBlue = new SimpleIntegerProperty();			//蓝色钥匙数
	public static SimpleIntegerProperty keyRed = new SimpleIntegerProperty();			//红色钥匙数
	public static SimpleIntegerProperty experience = new SimpleIntegerProperty();		//经验值
	public static SimpleIntegerProperty gold = new SimpleIntegerProperty();				//金币数
	public static SimpleIntegerProperty floor = new SimpleIntegerProperty();			//楼层数
	
	public static void init() {
		
		level.set(1000);
		level.intValue();
		
		level.set(level.intValue() + 1);
		
		playerWalk = MapData.playerWalk[MapData.numPlayerWalkCommon];
		playerFace = MapData.playerFace[MapData.numPlayerWalkCommon];
		speed.set(CommonData.speedWalk);
		name = "java";
		level.setValue(1);
		hp.setValue(1000);
		attack.setValue(10);
		defence.setValue(10);
		keyYellow.setValue(0);
		keyBlue.setValue(0);
		keyRed.setValue(0);
		experience.setValue(0);
		gold.setValue(0);
		floor.setValue(0);
	}
}
