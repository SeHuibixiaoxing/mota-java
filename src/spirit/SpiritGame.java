package spirit;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.net.URL;

import commonFunctions.CommonFunctions;
import data.CommonData;
import data.MapData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


public class SpiritGame extends Spirit {
	protected int nowX, nowY;													//��ǰX���꣬Y����
	protected SimpleIntegerProperty speed = new SimpleIntegerProperty();		//�ٶ�  ����ÿ֡������
	
	protected int dir;															//��ǰ����
	protected int state;														//��ǰ״̬
	
	protected SimpleIntegerProperty row = new SimpleIntegerProperty();			//������
	protected SimpleIntegerProperty line = new SimpleIntegerProperty();			//������
	protected int walkDir;														//��ǰ���߷���
	
	protected int tmpFrame;														//��ʱ����֡,012��ʾ�ߣ�3��ʾͣ��-1��ʾ��ʼ״̬
	
	protected Media media;														//�Ų�����Ч
	protected MediaPlayer mediaPlayer;											//�Ų���Ч����
	
	
	public SpiritGame(SimpleIntegerProperty row, SimpleIntegerProperty line, int width, int height, Image imgSets, SimpleIntegerProperty speed, int dir) {
		super(width, height, imgSets, Timeline.INDEFINITE, MapData.tileFileWidth, MapData.tileFileHeight, MapData.tileViewWidth, MapData.tileViewHeight);
		this.nowX = row.intValue() * MapData.tileViewHeight;
		this.nowY = line.intValue() * MapData.tileViewWidth;
		this.speed.bindBidirectional(speed);
		this.row.bindBidirectional(row);
		this.line.bindBidirectional(line);
		setWalkAnimation();
		this.dir = dir;
		if(this.speed.intValue() == CommonData.speedWalk) {
			URL url = this.getClass().getClassLoader().getResource("music/Walk0.mp3");
			media = new Media(url.toExternalForm());
		}
		else if(this.speed.intValue() == CommonData.speedRun){
			URL url = this.getClass().getClassLoader().getResource("music/Run0.mp3");
			media = new Media(url.toExternalForm());
		}
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}
	public SpiritGame(SimpleIntegerProperty row, SimpleIntegerProperty line, int width, int height, Image imgSets, int speed, int dir) {
		super(width, height, imgSets, Timeline.INDEFINITE, MapData.tileFileWidth, MapData.tileFileHeight, MapData.tileViewWidth, MapData.tileViewHeight);
		this.nowX = row.intValue() * MapData.tileViewHeight;
		this.nowY = line.intValue() * MapData.tileViewWidth;
		this.speed.set(speed);
		this.row.bindBidirectional(row);
		this.line.bindBidirectional(line);
		setWalkAnimation();
		if(this.speed.intValue() == CommonData.speedWalk) {
			URL url = this.getClass().getClassLoader().getResource("music/Walk0.mp3");
			media = new Media(url.toExternalForm());
		}
		else if(this.speed.intValue() == CommonData.speedRun){
			URL url = this.getClass().getClassLoader().getResource("music/Run0.mp3");
			media = new Media(url.toExternalForm());
		}
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}
	
	/*
	 * ����ģʽ��ƽ�ƶ���
	 * 0, 1, 1, 2    2, 3, 3, 0
	 * */
	protected void setWalkAnimation() {		
		for(int i = 0;i < 16;++ i) {
			this.insertFrame(i);
		}
		state = 0;
		walkDir = -1;
		tmpFrame = -1;
		
		keyFrame = new KeyFrame(new Duration(speed.intValue()), r-> {
			graphicsContext.clearRect(this.nowY, this.nowX, MapData.tileViewWidth, MapData.tileViewHeight);

			if(walkDir != -1) {
				//��������/��Ҫ������walkDir��������
				if(walkDir == MapData.walkDown) nowX += MapData.tileViewHeight / 4;
				if(walkDir == MapData.walkUp) nowX -= MapData.tileViewHeight / 4;
				if(walkDir == MapData.walkLeft) nowY -= MapData.tileViewWidth / 4;
				if(walkDir == MapData.walkRight) nowY += MapData.tileViewWidth / 4;
				
				if(tmpFrame == -1) {
					if(mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
						mediaPlayer.play();
					}
					++ tmpFrame;
					dir = walkDir;
					state = (state + 1) % 4;
					nowFrame = dir * 4 + state;
				}
				else if(tmpFrame == 2) {
					state = (state + 1) % 4;
					nowFrame = dir * 4 + state;
					tmpFrame = -1;
					walkDir = -1;
				}
				else {
					tmpFrame += 1;
				}
			}
			else {
				//����ԭ�ؾ�ֹ
				mediaPlayer.pause();
				if(state != 0 && state != 2) {
					state = 0;
				}
				nowFrame = dir * 4 + state;
			}	
			CommonFunctions.cutImage(this.graphicsContext, imgSets, getFrame(nowFrame), this.nowX, this.nowY);
		});
		timeline.stop();
		timeline.getKeyFrames().clear();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	
	/*
	 * ���߶���  
	 * */
	
	//��������
	public void dirUp() {
		dir = MapData.walkUp;
	}
	
	//��������
	public void dirDown() {
		dir = MapData.walkDown;
	}
	
	//��������
	public void dirLeft() {
		dir = MapData.walkLeft;
	}	
	
	//��������
	public void dirRight() {
		dir = MapData.walkRight;
	}		
	
	//������һ��
	public void walkUp() {
		if(this.row.intValue() == 0) {
			return;
		}
		if(isWalk()) {
			return;
		}
		walkDir = MapData.walkUp;
		this.row.set(row.intValue() - 1);
	}
	
	//������һ��
	public void walkDown() {
		if(this.row.intValue() == ((int)this.getWidth() / MapData.tileViewWidth) - 1) {
			return;
		}
		if(isWalk()) {
			return;
		}
		walkDir = MapData.walkDown;
		this.row.set(row.intValue() + 1);
	}
	
	//������һ��
	public void walkLeft() {
		if(this.line.intValue() == 0) {
			return;
		}
		if(isWalk()) {
			return;
		}
		walkDir = MapData.walkLeft;
		this.line.set(line.intValue() - 1);
	}
	
	//������һ��
	public void walkRight() {
		if(this.line.intValue() == ((int)this.getHeight() / MapData.tileViewHeight) - 1) {
			return;
		}
		if(isWalk()) {
			return;
		}
		walkDir = MapData.walkRight;
		this.line.set(line.intValue() + 1);
	}
	
	/*
	 * �������û�ȡ����
	 * */
	public void changeSpeed() {
		if(walkDir != -1) return;
		if(speed.intValue() == CommonData.speedWalk) {
			speed.set(CommonData.speedRun);

			URL url = this.getClass().getClassLoader().getResource("music/Run0.mp3");
			media = new Media(url.toExternalForm());
		}
		else {
			speed.set(CommonData.speedWalk);
			
			URL url = this.getClass().getClassLoader().getResource("music/Walk0.mp3");
			media = new Media(url.toExternalForm());
		}
		if(mediaPlayer != null) mediaPlayer.stop();
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		setWalkAnimation();
	}
	public boolean isWalk() {
		return walkDir != -1;
	}
	public void setWalkSpeed() {
		this.speed.set(CommonData.speedWalk);
	}
	public void setRunSpeed() {
		this.speed.set(CommonData.speedRun );
	}
	public SimpleIntegerProperty rowProperty() {
		return row;
	}
	public int getRow() {
		return this.row.intValue();
	}
	public void setRow(int row) {
		this.row.setValue(row);
	}
	public SimpleIntegerProperty lineProperty() {
		return line;
	}
	public int getLine() {
		return this.line.intValue();
	}
	public void setLine(int line) {
		this.line.setValue(line);
	}	
	public int getNowX() {
		return nowX;
	}
	public void setNowX(int nowX) {
		this.nowX = nowX;
	}
	public int getNowY() {
		return nowY;
	}
	public void setNowY(int nowY) {
		this.nowY = nowY;
	}
	public int getSpeed() {
		return speed.intValue();
	}
	public void setSpeed(int speed) {
		this.speed.set(speed);
	}
	public IntegerProperty speedProperty() {
		return speed;
	}
}