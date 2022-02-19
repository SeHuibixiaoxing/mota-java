package scene;

import javafx.scene.Parent;
import data.MapData;
import event.*;
import javafx.scene.layout.StackPane;
import rpgSwitch.RpgSwitch;
import model.ModelSwitch;

/*
 * ����������¼���ʵ������ÿ���������¼��������¼����������
 * */

public class RpgSceneEventMain extends Parent {
	
	protected int nowNum;												//��ǰ����
	
	protected int rowSize, lineSize;
	
	protected RpgSceneMain rpgSceneMain;								//����������
	protected StackPane rpgSceneGame;									//��Ϸ��������
	protected RpgSceneEvent rpgSceneEvent;								//��ǰ��ʾ���¼�����
	
	
	public RpgSceneEventMain(int num, RpgSceneMain rpgSceneMain, StackPane rpgSceneGame, int rowSize, int lineSize) {
		nowNum = -1;
		this.rpgSceneGame = rpgSceneGame;
		this.rpgSceneMain = rpgSceneMain;
		rpgSceneEvent = null;
		this.rowSize = rowSize;
		this.lineSize = lineSize;
		
		loadRpgSceneEvent(num);
	}
	
	public void loadRpgSceneEvent(int num) {
		if(nowNum == num) return;
		if(rpgSceneEvent != null) {
			this.getChildren().removeAll(rpgSceneEvent);
			rpgSceneEvent = null;
		}
		rpgSceneEvent = new RpgSceneEvent(rowSize, lineSize);
		
		nowNum = num;
		this.getChildren().clear();
		if(num == 0) {
			/*
			 * ��0���¼�
			 * */
			
			//����¥��
			UpStairsEvent floor00UpStairs = new UpStairsEvent(rpgSceneGame, rpgSceneMain, 0, 5, ModelSwitch.getPrivateSwitch(0, true), 9, 5, MapData.walkUp);
			rpgSceneEvent.insertEvent(floor00UpStairs, 0, 5);
			
			
			
		}
		else if(num == 1){
			/*
			 * ��1���¼�
			 * */
			
			//����¥��
			DownStairsEvent floor01DownStairs = new DownStairsEvent(rpgSceneGame, rpgSceneMain, 10, 5, ModelSwitch.getPrivateSwitch(1, true), 1, 5, MapData.walkDown);
			rpgSceneEvent.insertEvent(floor01DownStairs, 10, 5);
			
			//��Կ��1�¼�
			YellowKeyEvent floor01KeyYellow1 = new YellowKeyEvent(rpgSceneGame, rpgSceneMain, 8, 2, ModelSwitch.getPrivateSwitch(2, true));
			rpgSceneEvent.insertEvent(floor01KeyYellow1, 8, 2);
			
			//��Կ��2�¼�
			YellowKeyEvent floor01KeyYellow2 = new YellowKeyEvent(rpgSceneGame, rpgSceneMain, 8, 4, ModelSwitch.getPrivateSwitch(3, true));
			rpgSceneEvent.insertEvent(floor01KeyYellow2, 8, 4);
			
			//��Կ��1�¼�
			BlueKeyEvent floor01KeyBlue1 = new BlueKeyEvent(rpgSceneGame, rpgSceneMain, 7, 2, ModelSwitch.getPrivateSwitch(4, true));
			rpgSceneEvent.insertEvent(floor01KeyBlue1, 7, 2);
			
			//��Կ��2�¼�
			BlueKeyEvent floor01KeyBlue2 = new BlueKeyEvent(rpgSceneGame, rpgSceneMain, 7, 4, ModelSwitch.getPrivateSwitch(5, true));
			rpgSceneEvent.insertEvent(floor01KeyBlue2, 7, 4);
			
			//��Կ��1�¼�
			RedKeyEvent floor01KeyRed1 = new RedKeyEvent(rpgSceneGame, rpgSceneMain, 6, 2, ModelSwitch.getPrivateSwitch(6, true));
			rpgSceneEvent.insertEvent(floor01KeyRed1, 6, 2);
			
			//��Կ��2�¼�
			RedKeyEvent floor01KeyRed2 = new RedKeyEvent(rpgSceneGame, rpgSceneMain, 6, 4, ModelSwitch.getPrivateSwitch(7, true));
			rpgSceneEvent.insertEvent(floor01KeyRed2, 6, 4);	
			
			//��ҩˮ1�¼�
			HpRedEvent floor01HpRed1 = new HpRedEvent(rpgSceneGame, rpgSceneMain, 5, 2, ModelSwitch.getPrivateSwitch(8, true));
			rpgSceneEvent.insertEvent(floor01HpRed1, 5, 2);
			
			//��ҩˮ2�¼�
			HpRedEvent floor01HpRed2 = new HpRedEvent(rpgSceneGame, rpgSceneMain, 5, 4, ModelSwitch.getPrivateSwitch(9, true));
			rpgSceneEvent.insertEvent(floor01HpRed2, 5, 4);
			
			//��ҩˮ1�¼�
			HpBlueEvent floor01HpBlue1 = new HpBlueEvent(rpgSceneGame, rpgSceneMain, 4, 2, ModelSwitch.getPrivateSwitch(10, true));
			rpgSceneEvent.insertEvent(floor01HpBlue1, 4, 2);
			
			//��ҩˮ2�¼�
			HpBlueEvent floor01HpBlue2 = new HpBlueEvent(rpgSceneGame, rpgSceneMain, 4, 4, ModelSwitch.getPrivateSwitch(11, true));
			rpgSceneEvent.insertEvent(floor01HpBlue2, 4, 4);
			
			//��ɫ��1�¼�
			YellowDoorEvent floor01YellowDoor1 = new YellowDoorEvent(rpgSceneGame, rpgSceneMain, 4, 7, ModelSwitch.getPrivateSwitch(12, true));
			rpgSceneEvent.insertEvent(floor01YellowDoor1, 4, 7);
			
			//��ɫ��1�¼�
			BlueDoorEvent floor01BlueDoor1 = new BlueDoorEvent(rpgSceneGame, rpgSceneMain, 5, 7, ModelSwitch.getPrivateSwitch(13, true));
			rpgSceneEvent.insertEvent(floor01BlueDoor1, 5, 7);
			
			//��ɫ��1�¼�
			RedDoorEvent floor01RedDoor1 = new RedDoorEvent(rpgSceneGame, rpgSceneMain, 6, 7, ModelSwitch.getPrivateSwitch(14, true));
			rpgSceneEvent.insertEvent(floor01RedDoor1, 6, 7);
			
			//����1�¼�
			BigGoldEvent floor01BigGold1 = new BigGoldEvent(rpgSceneGame, rpgSceneMain, 3, 7, ModelSwitch.getPrivateSwitch(15, true));
			rpgSceneEvent.insertEvent(floor01BigGold1, 3, 7);
			
			//ս��������1�¼�
			BattleEvent01 floor01Battle1 = new BattleEvent01(rpgSceneGame, rpgSceneMain, 8, 7, ModelSwitch.getPrivateSwitch(16, true));
			rpgSceneEvent.insertEvent(floor01Battle1, 8, 7);
			
			//ս��BOSS�¼�
			BattleEvent02 floor01Battle2 = new BattleEvent02(rpgSceneGame, rpgSceneMain, 10, 7, ModelSwitch.getPrivateSwitch(17, true));
			rpgSceneEvent.insertEvent(floor01Battle2, 10, 7);
			
		}
		
		this.getChildren().add(rpgSceneEvent);
	}
	
	public Event getEvent(int row, int line) {
		if(rpgSceneEvent == null) return null;
		return rpgSceneEvent.getEvent(row, line);
	}
	
	public int getCanWalk(int row, int line) {
		if(rpgSceneEvent == null) return 1;
		return rpgSceneEvent.getCanWalk(row, line);
	}
	
}
