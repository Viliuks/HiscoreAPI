package smpl.api.hiscores;
/**
 * 
 * @author Vilius
 *
 */
public enum Skill {
	OVERALL(0),
	ATTACK(1), 
	DEFENCE(2), 
	STRENGTH(3), 
	CONSTITUTION(4), 
	RANGE(5), 
	PRAYER(6), 
	MAGIC(7), 
	COOKING(8), 
	WOODCUTTING(9), 
	FLETCHING(10),
	FISHING(11), 
	FIREMAKING(12), 
	CRAFTING(13), 
	SMITHING(14), 
	MINING(15), 
	HERBLORE(16), 
	AGILITY(17), 
	THIEVING(18), 
	SLAYER(19), 
	FARMING(20), 
	RUNECRAFTING(21), 
	HUNTER(22), 
	CONSTRUCTION(23);

	int number;

	Skill(int i) {
		this.number = i;
	}

	public int getValue() {
		return number;
	}
}
