package data;


public class CharacterData {
	private String name;						//����
	private String facePath;					//��ͼ·��
	private int hp;								//����ֵ
	private int attack;							//������
	private int defence;						//������

	public CharacterData(String name, String facePath, int hp, int attack, int defence) {
		this.name = name;
		this.facePath = facePath;
		this.hp = hp;
		this.attack = attack;
		this.defence = defence;
	}
	
	public String getFacePath() {
		return facePath;
	}

	public void setFacePath(String facePath) {
		this.facePath = facePath;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	
}
