package model;

import rpgSwitch.RpgSwitch;
import java.lang.*;

public class ModelSwitch {
	private ModelSwitch(){}
	
	private static RpgSwitch[] publicSwitch = new RpgSwitch[10000];
	private static RpgSwitch[] privateSwitch = new RpgSwitch[1000];
	public static RpgSwitch canWork = new RpgSwitch(true);
	
	//获取公共开关k，如果为空赋值为x
	public static RpgSwitch getPublicSwitch(int k, boolean x) {
		if(publicSwitch[k] == null) publicSwitch[k] = new RpgSwitch(x);
		return publicSwitch[k];
	}
	
	//获取公共开关k，如果为空赋值为false
	public static RpgSwitch getPublicSwitch(int k) {
		if(publicSwitch[k] == null) publicSwitch[k] = new RpgSwitch(false);
		return publicSwitch[k];
	}
	
	//获取事件私有开关k，如果为空赋值为x
	public static RpgSwitch getPrivateSwitch(int k, boolean x) {
		if(privateSwitch[k] == null) privateSwitch[k] = new RpgSwitch(x);
		return privateSwitch[k];
	}
	
	//获取事件私有开关k，如果为空赋值为false
	public static RpgSwitch getPrivateSwitch(int k) {
		if(privateSwitch[k] == null) privateSwitch[k] = new RpgSwitch(false);
		return privateSwitch[k];
	}	
}


/*独立开关使用情况：
 * 0000:第零层UpStairs事件
 * 0001:第一层DownStairs事件
 * 0002:第一层黄钥匙1
 * 0003:第一层黄钥匙2
 * 0004:第一层蓝钥匙1
 * 0005:第一层蓝钥匙2
 * 0006:第一层红钥匙1
 * 0007:第一层红钥匙2
 * 0008:第一层红药水1
 * 0009:第一层红药水2
 * 0010:第一层蓝药水1
 * 0011:第一层蓝药水2
 * 0012:第一层黄色门1
 * 0013:第一层蓝色门1
 * 0014:第一层红色门1
 * 0015:第一层大金币1
 * 0016:第一层滑稽怪1
 * 0017:
 * 0018:
 * 0019:
 * 0020:
 * 0021:
 * 0022:
 * 0023:
 * 0024:
 * 0025:
 * 0026:
 */


/*
 * 公共开关使用情况
 * 0000:
 * 0001:
 * 0002:
 * 0003:
 * 0004:
 * 0005:
 * 0006:
 * 0007:
 * 0008:
 * 0009:
 * 0010:
 * 0011:
 * 0012:
 * 0013:
 * 0014:
 * 0015:
 */
