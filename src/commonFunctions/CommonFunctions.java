package commonFunctions;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import data.MapData;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class CommonFunctions {
	
	
	/*将imageSets中的第k个绘制到GraphicsContext的x,y坐标上
	 * 图像，序号*/
	public static boolean cutImage(GraphicsContext graphicsContext, Image imgSets, int k, int x, int y) {
		int rowNum = (int)imgSets.getHeight() / MapData.tileFileHeight;
		int lineNum = (int)imgSets.getWidth() / MapData.tileFileWidth;
		if(k > rowNum * lineNum) return false;
		graphicsContext.drawImage(imgSets, k % lineNum * MapData.tileFileWidth, k / lineNum * MapData.tileFileHeight, MapData.tileFileWidth, MapData.tileFileHeight, y, x, MapData.tileViewWidth, MapData.tileViewHeight);
		return true;
	}
	public static boolean cutImage(GraphicsContext graphicsContext, Image imgSets, int k, int x, int y, int tileFileWidth, int tileFileHeight, int tileViewWidth, int tileViewHeight) {
		int rowNum = (int)imgSets.getHeight() / tileFileHeight;
		int lineNum = (int)imgSets.getWidth() / tileFileWidth;
		if(k > rowNum * lineNum) return false;
		graphicsContext.drawImage(imgSets, k % lineNum * tileFileWidth, k / lineNum * tileFileHeight, tileFileWidth, tileFileHeight, y, x, tileViewWidth, tileViewHeight);
		return true;
	}
	
	public static ImageView cutImage(Image imgSets, int k, int x, int y) {
		int rowNum = (int)imgSets.getHeight() / MapData.tileFileHeight;
		int lineNum = (int)imgSets.getWidth() / MapData.tileFileWidth;
		ImageView re = null;
		if(k > rowNum + lineNum) return re;
		re = new ImageView(imgSets);
		re.setViewport(new Rectangle2D(k % lineNum * MapData.tileFileWidth, k / lineNum * MapData.tileFileHeight, MapData.tileFileWidth, MapData.tileFileHeight));
		re.setX(y);
		re.setY(x);
		return re;
	}
	
}
