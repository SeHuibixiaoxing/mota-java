package battle;

import java.util.*;
import data.EnemyCharacterData;
import data.CharacterData;

public class BattleData {
	private CharacterData enemy;
	private CharacterData player;
	
	//ע�⣺����Ϊǳ����
	public BattleData(CharacterData player, CharacterData enemy) {
		this.player = player;
		this.enemy = enemy;
	}

	//����һ�غ�ս��,�÷���������ж��ܹ�ս����ʹ��.����ս���Ƿ����
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
	
	//����ս����ʧѪ����������С�ڵ��ڵз�������ս������-1
	public int battleHP() {
		if(player.getAttack() <= enemy.getDefence()) {
			return -1;
		}
		int cycle = enemy.getHp()/(player.getAttack() - enemy.getDefence());
		if(cycle * (player.getAttack() - enemy.getDefence()) != enemy.getHp()) ++ cycle;
		return cycle * (enemy.getAttack() - player.getDefence());
	}
	
	//�ж��Ƿ��ܹ�ս��
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
