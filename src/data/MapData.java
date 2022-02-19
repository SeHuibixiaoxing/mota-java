package data;


import spirit.SpiritTile;
import javafx.scene.image.Image;

public class MapData {
	
	/*
	 * ��С����
	 * */
	public static final int tileFileWidth = 32;							//�ļ�ͼ����
	public static final int tileFileHeight = 32;						//�ļ�ͼ��߶�
	public static final int tileViewWidth = 52;							//��ʾͼ����
	public static final int tileViewHeight = 52;						//��ʾͼ��߶�
	
	public static final int faceWidth = 96;								//��ͼ���
	public static final int faceHeight = 96;							//��ͼ�߶�

	/*
	 * ����ͼ
	*/	
	/*����ͼ*/public static final String[] playerWalk = {/*00*/"file:RTP/Graphics/Characters/Walk0.png"};
	
	/*��Ӧ��ͼ*/public static final String[] playerFace = {/*00*/"file:RTP/Graphics/Faces/Face0.png"};
	
	
	//����ͼ���
	public static final int numPlayerWalkCommon = 00;
	
	/*
	 * ��ͼ��С
	 * */
	public static final int row = 11;
	public static final int line = 11;
	public static final int gameWidth = line * tileViewWidth;
	public static final int gameGeight = row * tileViewHeight;
	
	
	/*
	 * �������߷�λ
	 * �������Ҷ�Ӧ����ͼ�е���
	 * */
	public static final int walkUp = 3;
	public static final int walkLeft = 1;
	public static final int walkRight = 2;
	public static final int walkDown = 0;
	
	/*
	 * ͼ�鳣��
	 */
	public static final String[] tileSets = {/*00*/"file:RTP/Graphics/Tilesets/TileFloor00.png",
											 /*01*/"file:RTP/Graphics/Tilesets/TileWall00.png",
											 /*02*/"file:RTP/Graphics/Tilesets/TileFloor01.png",
											 /*03*/"file:RTP/Graphics/Tilesets/TileFloor02.png",
											 /*04*/"file:RTP/Graphics/Tilesets/TileFloor03.png"};
	public static final String[] canWalk = {/*00*/"1",
											/*01*/"0",
											/*02*/"0",
											/*03*/"0",
											/*04*/"0"};
	public static final String[] tileType = {/*00*/"0",
											 /*01*/"0",
											 /*02*/"1",
											 /*03*/"1",
											 /*04*/"1"};//0����ֹģʽ��1������֡����ģʽ
	
	//ͼ����
	public static final int numTileFloor00 = 00;
	public static final int numTileFloor01 = 02;
	public static final int numTileFloor02 = 03;
	public static final int numTileFloor03 = 04;
	
	public static final int numTileWall00 = 01;
	
	//��ȡ���Ϊk��ͼ���Ӧ��ͼ�龫��
	public static SpiritTile getSpiritTile(int k) {
		SpiritTile re= new SpiritTile(new Image(tileSets[k]));
		if(Integer.parseInt(tileType[k]) == 0) {
			re.setOneFrameBaseAnimation(0);
		}
		else if(Integer.parseInt(tileType[k]) == 1) {
			re.setFourFrameBaseAnimation();
		}
		return re;
	}
	
	/*
	 * ������ͼͼ��
	 * */						//			        01234567890
	public static final String mapTileSets[][] = {{//��ͼ00:��0��
												   "13333033331",//0
												   "13333033331",//1
												   "13333033331",//2
												   "13333033331",//3
												   "13333033331",//4
												   "11333033311",//5
												   "11111011111",//6
												   "11111011111",//7
												   "41410001414",//8
												   "44444044444",//9
												   "44444044444",},//0
												 //��ͼ01:��1��
												 // 01234567890
												  {"00000000000",//0
												   "00000000000",//1
												   "00000011100",//2
												   "00000010100",//3
												   "00000010100",//4
												   "00000010100",//5
												   "00000010100",//6
												   "00000000000",//7
												   "00000000000",//8
												   "00000000000",//9
												   "00000000000",}//0
										 	};
	public static final String mapSize[][] = {{"11", "11"},/*00*/
											  {"11", "11"}
											     };
	public static final String startPos[][] = {{"10", "5", String.valueOf(walkUp)},
												{"9", "5", String.valueOf(walkUp)}
	};

}

