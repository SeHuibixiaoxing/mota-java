package model;

import rpgSwitch.RpgSwitch;
import java.lang.*;

public class ModelSwitch {
	private ModelSwitch(){}
	
	private static RpgSwitch[] publicSwitch = new RpgSwitch[10000];
	private static RpgSwitch[] privateSwitch = new RpgSwitch[1000];
	public static RpgSwitch canWork = new RpgSwitch(true);
	
	//��ȡ��������k�����Ϊ�ո�ֵΪx
	public static RpgSwitch getPublicSwitch(int k, boolean x) {
		if(publicSwitch[k] == null) publicSwitch[k] = new RpgSwitch(x);
		return publicSwitch[k];
	}
	
	//��ȡ��������k�����Ϊ�ո�ֵΪfalse
	public static RpgSwitch getPublicSwitch(int k) {
		if(publicSwitch[k] == null) publicSwitch[k] = new RpgSwitch(false);
		return publicSwitch[k];
	}
	
	//��ȡ�¼�˽�п���k�����Ϊ�ո�ֵΪx
	public static RpgSwitch getPrivateSwitch(int k, boolean x) {
		if(privateSwitch[k] == null) privateSwitch[k] = new RpgSwitch(x);
		return privateSwitch[k];
	}
	
	//��ȡ�¼�˽�п���k�����Ϊ�ո�ֵΪfalse
	public static RpgSwitch getPrivateSwitch(int k) {
		if(privateSwitch[k] == null) privateSwitch[k] = new RpgSwitch(false);
		return privateSwitch[k];
	}	
}


/*��������ʹ�������
 * 0000:�����UpStairs�¼�
 * 0001:��һ��DownStairs�¼�
 * 0002:��һ���Կ��1
 * 0003:��һ���Կ��2
 * 0004:��һ����Կ��1
 * 0005:��һ����Կ��2
 * 0006:��һ���Կ��1
 * 0007:��һ���Կ��2
 * 0008:��һ���ҩˮ1
 * 0009:��һ���ҩˮ2
 * 0010:��һ����ҩˮ1
 * 0011:��һ����ҩˮ2
 * 0012:��һ���ɫ��1
 * 0013:��һ����ɫ��1
 * 0014:��һ���ɫ��1
 * 0015:��һ�����1
 * 0016:��һ�㻬����1
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
 * ��������ʹ�����
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
