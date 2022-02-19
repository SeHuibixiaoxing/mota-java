package battle;

import java.util.*;
import data.EnemyCharacterData;
import data.CharacterData;

public class BattleData {
	private CharacterData enemy;
	private CharacterData player;
	
	//注意：这里为浅拷贝
	public BattleData(CharacterData player, CharacterData enemy) {
		this.player = player;
		this.enemy = enemy;
	}

	//进行一回合战斗,该方法务必在判断能够战斗后使用.返回战斗是否结束
	public boolean nextRound() {
		int playerHurt = enemy.getAttack() - player.getDefence();
		if(playerHurt < 0) playerHurt = 0;
		player.setHp(player.getHp() - playerHurt);
		
		int enemyHurt = player.getAttack() - enemy.getDefence();
		if(enemyHurt >= enemy.getHp()) {
			enemy.setHp(0);
			return true;
		}
		enemy.setHp(enemy.getHp() - enemyHurt);
		
		return false;
	}
	
	//返回战斗损失血量，攻击力小于等于敌方防御力战斗返回-1
	public int battleHP() {
		if(player.getAttack() <= enemy.getDefence()) {
			return -1;
		}
		int cycle = enemy.getHp()/(player.getAttack() - enemy.getDefence());
		if(cycle * (player.getAttack() - enemy.getDefence()) != enemy.getHp()) ++ cycle;
		return cycle * (enemy.getAttack() - player.getDefence());
	}
	
	//判断是否能够战斗
	public boolean canBattle() {
		int tmp = battleHP();
		if(tmp == -1 || tmp >= player.getHp())	return false;
		return true;
	}
	
	public CharacterData getEnemy() {
		return enemy;
	}

	public CharacterData getPlayer() {
		return player;
	}	
}
