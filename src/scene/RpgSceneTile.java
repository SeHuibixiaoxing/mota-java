package scene;

import javafx.scene.layout.GridPane;
import spirit.SpiritTile;
import java.util.*;


public class RpgSceneTile extends GridPane {
	private ArrayList<ArrayList<SpiritTile>> spiritTile = new ArrayList<ArrayList<SpiritTile>>();		//����ͼ������
	private ArrayList<ArrayList<Integer>> canWalk = new ArrayList<ArrayList<Integer>>();				//ͨ��״̬����
	
	int rowSize;						//����
	int lineSize;						//����
	boolean isDraw;						//�Ƿ�����ͼ
	
	public RpgSceneTile(int rowSize, int lineSize, ArrayList<ArrayList<SpiritTile>> spiritTile, ArrayList<ArrayList<Integer>> canWalk) {
		 isDraw = false;
		 this.spiritTile = spiritTile;
		 this.canWalk = canWalk;
		 this.rowSize = rowSize;
		 this.lineSize = lineSize;
	}
	
	public void clearScene() {
		this.getChildren().clear();
		spiritTile.clear();
		canWalk.clear();
	}
	
	//��ͼ�����뵽GridPane��
	public void draw() {
		if(isDraw) {
			this.getChildren().clear();
		}
		else {
			isDraw = true;
		}		
		for(int i = 0;i < rowSize;++ i) {
			for(int j = 0;j < lineSize;++ j) {
				this.add(this.getSpiritTile(i, j), j, i);
				this.getSpiritTile(i, j).draw();
			}
		}
	}
	
	//ֹͣ��ͼ
	public void endDraw() {
		isDraw = false;
		for(int i = 0;i < rowSize;++ i) {
			for(int j = 0;j < lineSize;++ j) {
				this.getSpiritTile(i, j).stop();
			}
		}
	}
	
	public ArrayList<Integer> getCanWalk(int i) {
		return this.canWalk.get(i);
	}
	
	public int getCanWalk(int i, int j) {
		return getCanWalk(i).get(j);
	}
	
	public ArrayList<SpiritTile> getSpiritTile(int i) {
		return this.spiritTile.get(i);
	}
	
	public SpiritTile getSpiritTile(int i, int j) {
		return this.getSpiritTile(i).get(j);
	}
	
	public void setSpiritTile(int x, int y, SpiritTile spiritTile) {
		if(isDraw) {
			this.getChildren().removeAll(this.getSpiritTile(x, y));
			this.add(spiritTile, x, y);
			spiritTile.draw();
		}
		getSpiritTile(x).set(y, spiritTile);
	}
	
	public void setCanWalk(int x, int y, int k) {
		getCanWalk(x).set(y, k);
	}
	
	public void set(int x, int y, SpiritTile spiritTile, int k) {
		setSpiritTile(x, y, spiritTile);
		setCanWalk(x, y, k);
	}
}
