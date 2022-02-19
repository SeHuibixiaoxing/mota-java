package data;

public class CommonData {
	
	/*
	 * 步行速度原理
	 * 每个步行状态停留两帧，一个不行动画循环4帧，0静止，1左，2静止，3右
	 * 0,1,1,2   2,3,3,0   如是为行走
	 * 四帧移动32像素，每帧移动8像素。
	 * 步行  500ms一步  即125ms一帧
	 * 跑步  300ms一步  即75ms一帧
	 * */
	
	private CommonData(){}
	
	/*
	 * 特定平移动画速度
	 * */
	public static final int speedWalk = 75;						   
	public static final int speedRun = 40;
	
	/* *
	 * 动画单位时间
	 * */
	public static final int fourFrameDurationMillis = 250;
	public static final int indefiniteDurationMillis = 250;
	
	/*
	 * 游戏相关
	 * */
	public static final int floorNum = 1;				//已设计层数

}
