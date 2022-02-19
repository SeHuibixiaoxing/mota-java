package spirit;

import javafx.scene.image.Image;
import data.CommonData;
import data.MapData;
import javafx.animation.Timeline;


public class SpiritTile extends Spirit{
	
	public SpiritTile(Image imgSets) {
		super(MapData.tileViewWidth, MapData.tileViewHeight, imgSets, Timeline.INDEFINITE, MapData.tileFileWidth, MapData.tileFileHeight, MapData.tileViewWidth, MapData.tileViewHeight);
	}
	
	/*
	 * »ù´¡¶¯»­£ºËÄÖ¡
	 * */
	public void setFourFrameBaseAnimation(int k0, int k1, int k2, int k3) {
		this.setFrameAnimation(CommonData.fourFrameDurationMillis, 0, 0, k0, k1, k2, k3);
	}
	
	public void setFourFrameBaseAnimation() {
		setFourFrameBaseAnimation(0, 1, 2, 3);
	}	
	
}
