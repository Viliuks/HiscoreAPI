package smpl.api.hiscores;
/**
 * 
 * @author Vilius
 *
 */
public class HiscoreSkill {
	private int level, xp;
	private Skill skill;

	public HiscoreSkill(Skill skill, int level, int xp) {
		this.level = level;
		this.xp = xp;
		this.skill = skill;
	}

	public int getLevel() {
		return level;
	}

	public int getXp() {
		return xp;
	}
	public Skill getSkill(){
		return skill;
	}
}
