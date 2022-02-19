package model;

import data.CommonData;
import data.MapData;
import javafx.beans.property.SimpleIntegerProperty;

public class ModelPlayerData {	
	private ModelPlayerData(){}
	public static String name;															//����
	public static SimpleIntegerProperty level = new SimpleIntegerProperty();			//�ȼ�
	public static SimpleIntegerProperty hp = new SimpleIntegerProperty();				//����ֵ
	public static SimpleIntegerProperty attack = new SimpleIntegerProperty();			//������
	public static SimpleIntegerProperty defence = new SimpleIntegerProperty();			//������
	public static SimpleIntegerProperty row = new SimpleIntegerProperty();				//����x����
	public static SimpleIntegerProperty line = new SimpleIntegerProperty();				//����y����
	public static SimpleIntegerProperty speed = new SimpleIntegerProperty();			//�����ٶ�,ÿ֡X���ƶ����꣬Y�ᰴ�����ƶ�
	public static String playerWalk;													//�������ͼ
	public static String playerFace;													//�����ͼ
	public static SimpleIntegerProperty keyYellow = new SimpleIntegerProperty();		//��ɫԿ����
	public static SimpleIntegerProperty keyBlue = new SimpleIntegerProperty();			//��ɫԿ����
	public static SimpleIntegerProperty keyRed = new SimpleIntegerProperty();			//��ɫԿ����
	public static SimpleIntegerProperty experience = new SimpleIntegerProperty();		//����ֵ
	public static SimpleIntegerProperty gold = new SimpleIntegerProperty();				//�����
	public static SimpleIntegerProperty floor = new SimpleIntegerProperty();			//¥����
	
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
