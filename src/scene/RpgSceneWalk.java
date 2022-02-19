package scene;

import javafx.scene.Parent;
import java.util.ArrayList;

import data.MapData;
import spirit.SpiritGame;
import javafx.scene.image.Image;
import javafx.beans.property.SimpleIntegerProperty;

public class RpgSceneWalk extends Parent {
	
	private ArrayList<ArrayList<Integer>> canWalk = new ArrayList<ArrayList<Integer>>();				//ͨ��״̬����
	private SpiritGame spiritGame;																		//��Ϸ������
	private int rowSize, lineSize;																		//��С
	
	RpgSceneWalk(SimpleIntegerProperty row, SimpleIntegerProperty line, int rowSize, int lineSize, Image img, SimpleIntegerProperty speed, int dir, ArrayList<ArrayList<Integer>> canWalk) {
		this.canWalk = canWalk;
		this.rowSize = rowSize;
		this.lineSize = lineSize;
		spiritGame =  new SpiritGame(row, line, this.rowSize * MapData.tileViewHeight, this.lineSize * MapData.tileViewWidth, img, speed, dir);
		this.getChildren().add(this.spiritGame);
	}
	
	public boolean isWalk() {
		return this.spiritGame.isWalk();
	}
	
	public void changeSpeed() {
		this.spiritGame.changeSpeed();
	}
	
	public void dirUp() {
		this.spiritGame.dirUp();
	}
	
	public void dirDown() {
		this.spiritGame.dirDown();
	}
	
	public void dirLeft() {
		this.spiritGame.dirLeft();
	}
	
	public void dirRight() {
		this.spiritGame.dirRight();
	}
	
	public void walkUp() {
		this.spiritGame.walkUp();
	}
	
	public void walkDown() {
		this.spiritGame.walkDown();
	}
	
	public void walkLeft() {
		this.spiritGame.walkLeft();
	}
	
	public void walkRight() {
		this.spiritGame.walkRight();
	}
	
	public int getCanWalk(int row, int line) {
		return canWalk.get(row).get(line);
	}
	
	public void draw() {
		spiritGame.draw();
	}
	public void stop() {
		spiritGame.stop();
	}
}
