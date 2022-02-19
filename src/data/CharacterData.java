package data;


public class CharacterData {
	private String name;						//名称
	private String facePath;					//脸图路径
	private int hp;								//生命值
	private int attack;							//攻击力
	private int defence;						//防御力

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
