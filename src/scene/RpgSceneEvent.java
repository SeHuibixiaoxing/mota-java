package scene;

import javafx.scene.layout.GridPane;
import java.util.*;
import javafx.scene.layout.ColumnConstraints;
import data.MapData;
import event.Event;
import javafx.scene.layout.RowConstraints;

public class RpgSceneEvent extends GridPane{
	protected ArrayList<ArrayList<Event>> event;						//事件数组
	protected int rowSize;
	protected int lineSize;
	
	RpgSceneEvent(int rowSize, int lineSize) {
		this.rowSize = rowSize;
		this.lineSize = lineSize;
		event = new ArrayList<ArrayList<Event>>();
		for(int i = 0;i < rowSize;++ i) {
			event.add(new ArrayList<Event>());
			for(int j = 0;j < lineSize;++ j) {
				event.get(i).add(null);
			}
		}
		
		for(int i = 0;i < rowSize;++ i) {
			this.getColumnConstraints().add(new ColumnConstraints(MapData.tileViewWidth));
		}
		
		for(int i = 0;i < lineSize;++ i) {
			this.getRowConstraints().add(new RowConstraints(MapData.tileViewHeight));
		}
		
	}
	
	public Event getEvent(int row, int line) {
		return event.get(row).get(line);
	}
	
	public void insertEvent(Event e, int row, int line) {
		if(event.get(row).get(line) != null) {
			this.getChildren().removeAll(event.get(row).get(line));
		}
		event.get(row).set(line, e);
		this.add(e, line, row);
		event.get(row).get(line).draw();
	}
	
	public int getCanWalk(int row, int line) {
		if(this.getEvent(row, line) == null) return 1;
		else return this.getEvent(row, line).getCanWalk();
	}
}
