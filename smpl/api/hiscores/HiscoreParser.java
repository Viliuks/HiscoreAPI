package smpl.api.hiscores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONObject;
/**
 * 
 * @author Vilius
 *
 */
public final class HiscoreParser {
	private String url = "https://www.tip.it/runescape/json/hiscore_user?rsn=";
	private String[] skillArray = new String[] { "Overall", "Attack", "Defence", "Strength", "Constitution", "Range",
			"Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing",
			"Mining", "Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecrafting", "Hunter",
			"Construction" };
	private ArrayList<HiscoreSkill> tmp = new ArrayList<HiscoreSkill>();

	public HiscoreParser() {

	}	

	private String cleanUsername(String username) {
		return username.replaceAll("\\u00a0", " ");
	}

	private String getEncodedUrl(String username) {
		return url + cleanUsername(username).replaceAll(" ", "%20") + "&old_stats=1";
	}

	private String getRawSkills(String username) throws IOException {
		URL u = new URL(getEncodedUrl(username));
		URLConnection conn = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine);
		in.close();
		return buffer.toString();
	}

	public ArrayList<HiscoreSkill> parseSkills(String username) throws IOException {
		JSONObject obj = new JSONObject(getRawSkills(username)).getJSONObject("stats");
		for (int i = 0; i < skillArray.length; i++) {
			JSONObject o = obj.getJSONObject(skillArray[i].toLowerCase());
			tmp.add(new HiscoreSkill(o.toString(), o.getInt("level"), o.getInt("exp")));
		}
		return tmp;
	}

}
