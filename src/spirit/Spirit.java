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
	
	protected KeyFrame keyFrame;										//֡
	protected Image imgSets;											//ͼƬ����
	protected Timeline timeline = new Timeline();						//����
	protected DoubleProperty rate = new SimpleDoubleProperty();			//����
	protected GraphicsContext graphicsContext;							//��ͼ������
	protected ArrayList<Integer> frame;									//֡ͼƬ���
	protected int tileFileWidth;										//ͼ���ļ����
	protected int tileFileHeight;										//ͼ���ļ��߶�
	protected int tileViewWidth;										//ͼ����ʾ���
	protected int tileViewHeight;										//ͼ����ʾ�߶�
	
	protected int nowFrame;												//��ǰ����֡���
	
	
	//��ȣ��߶ȣ�ͼƬ��ѭ������
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
	
	//����֡
	public void clearFrame() {
		frame.clear();
		this.graphicsContext.clearRect(0, 0, this.getWidth(), this.getHeight());
		nowFrame = -1;
	}
	
	//��ʼ����
	public void draw() {
		timeline.play();
	}
	
	//��������
	public void stop() {
		timeline.stop();
	}
	
	/*
	 * �������÷���
	 * */
	
	//����֡   kΪͼƬ��img�е����
	protected void insertFrame(int k) {
		frame.add(k);
	}
	
	//����ģʽ������������֡����ѭ��������
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
	 * ��������������֡��
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
	 * ������������֡
	 * */
	public void setOneFrameBaseAnimation(int x, int y, int k) {
		this.setFrameAnimation(CommonData.indefiniteDurationMillis, x, y, k);
	}
	
	public void setOneFrameBaseAnimation(int k) {
		setOneFrameBaseAnimation(0, 0, k);
	}
	
	
	/*
	 * �����޸�/��ȡ����
	 * */
	
	//�Ƿ񲥷����
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
