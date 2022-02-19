package window;

import spirit.Spirit;
import data.CommonData;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class WindowText extends Parent {
	
	protected int windowX, windowY;									//������Parent�е�����
	protected int windowWidth, windowHeight;						//���ڸ߶ȡ����
	protected Spirit windowSpirit;									//���ھ���
	protected String windowImgPath;									//������ɫ��ʽ·��
	protected Image windowImg;										//������ɫ��ʽ
	
	
	protected int textSize;											//���ִ�С
	protected String textType;										//����
	protected String textContent;									//��������
	FontWeight fontWeight;											//��ϸ
	Label textLabel;												//��ʾ���ֵ�Label
	protected int textX, textY;										//����Label��X��Y����
	
	public WindowText(int windowX, int windowY, int windowWidth, int windowHeight, String windowImgPath) {
		this.windowX = windowX;
		this.windowY = windowY;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.windowImgPath = windowImgPath;
		windowImg = new Image(this.windowImgPath);
		
		windowSpirit = new Spirit(this.windowWidth, this.windowHeight, this.windowImg, Timeline.INDEFINITE, (int)windowImg.getWidth(), (int)windowImg.getHeight(), this.windowWidth, this.windowHeight);		
		windowSpirit.setFrameAnimation(new Duration(CommonData.indefiniteDurationMillis), 0, 0, 0);
		
		fontWeight = null;
		textLabel = null;
	}
	
	public void setText(String textContent, int textSize, String textType, FontWeight fontWeight, int gasWidth, int gasHeight) {
		this.fontWeight = FontWeight.findByWeight(fontWeight.getWeight());
		this.textContent = textContent;
		this.textSize = textSize;
		this.textType = textType;
		this.textX = this.windowX + gasHeight;
		this.textY = this.windowY + gasHeight;
		
		textLabel = new Label(textContent);
		textLabel.setFont(Font.font(textType, fontWeight, textSize));
		textLabel.setWrapText(true);	
		/*���ﻹ�ж���Ҫд*/
	}
	
	public void draw() {
		windowSpirit.draw();
		if(textLabel != null) {
			this.getChildren().addAll(this.windowSpirit, this.textLabel);
			this.windowSpirit.setLayoutX(this.windowY);
			this.windowSpirit.setLayoutY(this.windowX);
			this.textLabel.setLayoutX(this.textY);
			this.textLabel.setLayoutY(this.textX);
		}
		else {
			this.getChildren().addAll(windowSpirit);
			this.windowSpirit.setLayoutX(this.windowY);
			this.windowSpirit.setLayoutY(this.windowX);
		}
	}
	
	public void stop() {
		windowSpirit.stop();
		this.getChildren().clear();
	}
	
}
