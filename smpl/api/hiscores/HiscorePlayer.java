package smpl.api.hiscores;

import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author Vilius
 *
 */
public final class HiscorePlayer {
	private ArrayList<HiscoreSkill> skillsList = new ArrayList<HiscoreSkill>();
	private String currName;

	public HiscorePlayer(String currName) throws IOException {
		this.currName = currName;
		HiscoreParser parser = new HiscoreParser();
		skillsList = parser.parseSkills(currName);
	}

	public String getCurrentName() {
		return currName;
	}

	public int getSkillLevel(Skill skill) {
		return skillsList.get(skill.getValue()).getLevel();
	}
	public int getSkillXp(Skill skill){
		return skillsList.get(skill.getValue()).getXp();
	}
}
