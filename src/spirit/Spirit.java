package spirit;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleDoubleProperty;
import commonFunctions.CommonFunctions;
import data.CommonData;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import java.util.*;

public class Spirit extends Canvas {
	
	protected KeyFrame keyFrame;										//帧
	protected Image imgSets;											//图片集合
	protected Timeline timeline = new Timeline();						//动画
	protected DoubleProperty rate = new SimpleDoubleProperty();			//速率
	protected GraphicsContext graphicsContext;							//绘图缓冲区
	protected ArrayList<Integer> frame;									//帧图片编号
	protected int tileFileWidth;										//图块文件宽度
	protected int tileFileHeight;										//图块文件高度
	protected int tileViewWidth;										//图块显示宽度
	protected int tileViewHeight;										//图块显示高度
	
	protected int nowFrame;												//当前播放帧编号
	
	
	//宽度，高度，图片，循环次数
	public Spirit(int width, int height, Image imgSets, int cycleCount, int tileFileWidth, int tileFileHeight, int tileViewWidth, int tileViewHeight) {
		this.tileFileHeight = tileFileHeight;
		this.tileFileWidth = tileFileWidth;
		this.tileViewHeight = tileViewHeight;
		this.tileViewWidth = tileViewWidth;
		
		frame = new ArrayList<Integer>();
		rate.set(1.0);
		timeline.rateProperty().bind(rate);
		this.setWidth(width);
		this.setHeight(height);
		this.imgSets = imgSets;
		setCycleCount(cycleCount);
		graphicsContext = this.getGraphicsContext2D();
		nowFrame = -1;
	}
	
	//重置帧
	public void clearFrame() {
		frame.clear();
		this.graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
		nowFrame = -1;
	}
	
	//开始绘制
	public void draw() {
		timeline.play();
	}
	
	//结束绘制
	public void stop() {
		timeline.stop();
	}
	
	/*
	 * 内置设置方法
	 * */
	
	//插入帧   k为图片在img中的序号
	protected void insertFrame(int k) {
		frame.add(k);
	}
	
	//动画模式：基础（静逐帧依照循环次数）
	protected void loadBaseAnimation(Duration duration, int x, int y) {		
		keyFrame = new KeyFrame(duration, r-> {
			if(frame.size() != 0) {
				++ this.nowFrame;
				this.nowFrame = nowFrame % frame.size();
				this.graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
				CommonFunctions.cutImage(this.graphicsContext, imgSets, frame.get(nowFrame), x, y, this.tileFileWidth, this.tileFileHeight, this.tileViewWidth, this.tileViewHeight);
			}
		});
		timeline.stop();
		timeline.getKeyFrames().clear();
		timeline.getKeyFrames().add(keyFrame);
	}
	
	/*
	 * 基本动画：自由帧数
	 * */  
	public void setFrameAnimation(Duration duration, int x, int y, int... k) {
		clearFrame();
		for(int i = 0;i < k.length;++ i) {
			this.insertFrame(k[i]);
		}
		this.loadBaseAnimation(duration, x, y);
	}
	
	public void setFrameAnimation(int millis, int x, int y, int... k) {
		clearFrame();
		for(int i = 0;i < k.length;++ i) {
			this.insertFrame(k[i]);
		}
		this.loadBaseAnimation(new Duration(millis), x, y);
	}
	
	/*
	 * 基本动画：单帧
	 * */
	public void setOneFrameBaseAnimation(int x, int y, int k) {
		this.setFrameAnimation(CommonData.indefiniteDurationMillis, x, y, k);
	}
	
	public void setOneFrameBaseAnimation(int k) {
		setOneFrameBaseAnimation(0, 0, k);
	}
	
	
	/*
	 * 属性修改/获取方法
	 * */
	
	//是否播放完毕
	public boolean isStop() {
		return timeline.getStatus() == Status.STOPPED;
	}
	public int getFrame(int k) {
		if(k >= frame.size()) return 0;
		return frame.get(k);
	}
	
	public int getFrameSize() {
		return frame.size();
	}
	
	public boolean isEmpty() {
		return frame.size() == 0;
	}
	
	public GraphicsContext getGraphicsContext() {
		return graphicsContext;
	}
	
	public int getCycleCount() {
		return timeline.getCycleCount();
	}
	
	public void setCycleCount(int value) {
		timeline.setCycleCount(value);
	}
	
	public double getRate() {
		return this.rate.doubleValue();
	}

	public void setRate(double rate) {
		this.rate.set(rate);
	}

	public int getNowFrame() {
		return nowFrame;
	}

}
