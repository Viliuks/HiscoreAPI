package smpl.api.hiscores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * 
 * @author Vilius
 *
 */
public final class HiscoreParser {
	private final String url = "https://www.tip.it/runescape/json/hiscore_user?rsn=";

	private List<HiscoreSkill> tmp = new ArrayList<HiscoreSkill>();

	private String cleanUsername(String username) {
		return username.replaceAll("\\u00a0", " ");
	}

	private String getEncodedUrl(String username) {
		return url + cleanUsername(username).replaceAll(" ", "%20") + "&old_stats=1";
	}

	private String getRawSkills(String username) throws IOException {
		URL u = new URL(getEncodedUrl(username));
		URLConnection conn = u.openConnection();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			StringBuffer buffer = new StringBuffer();
			String inputLine;
			while ((inputLine = reader.readLine()) != null)
				buffer.append(inputLine);
			return buffer.toString();
		}
	}

	public List<HiscoreSkill> parseSkills(String username) throws IOException {
		JSONObject obj = new JSONObject(getRawSkills(username)).getJSONObject("stats");
		for (Skill skill : Skill.values()) {
			JSONObject o = obj.getJSONObject(skill.name().toLowerCase());
			tmp.add(new HiscoreSkill(skill, o.getInt("level"), o.getInt("exp")));
		}
		return tmp;
	}

}
