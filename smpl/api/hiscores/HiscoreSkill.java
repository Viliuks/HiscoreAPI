package smpl.api.hiscores;
/**
 * 
 * @author Vilius
 *
 */
public class HiscoreSkill {
	private int level, xp;
	private String name;

	public HiscoreSkill(String name, int level, int xp) {
		this.level = level;
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public int getXp() {
		return xp;
	}
	public String getName(){
		return name;
	}
}
