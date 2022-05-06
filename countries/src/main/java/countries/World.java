package countries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class World {

	List<JSONObject> countries = new ArrayList<JSONObject>();
	
	public World(String strJson) throws Exception {
		
		if ("".equals(strJson)) throw new Exception("Invalid json format. JSON must starts with [ and finish with ]");
		
		JSONArray arrayCountries = new JSONArray(strJson);
		countries = new ArrayList<JSONObject>();
		
		for (int i = 0; i < arrayCountries.length(); i++) {
			JSONObject jsonObj = arrayCountries.getJSONObject(i);
			this.countries.add(jsonObj);
		}
	}
	
	public List<JSONObject> getCountries() {
		return countries;
	}

	public void setCountries(List<JSONObject> countries) {
		this.countries = countries;
	}

	public int countCountries() {
		return this.countries.size();
	}
	
	public String findCountryWithHighestNumberLanguages() {
		
		List<JSONObject> list =  this.countries.stream()
			.map(elemJsonObj -> {
					JSONObject newObj = new JSONObject();
					newObj.put("country", elemJsonObj.get("country"));
					newObj.put("countlanguages", elemJsonObj.getJSONArray("languages").length());
					return newObj;
			})
			.sorted(Comparator.comparing(elem -> ((JSONObject) elem).getInt("countlanguages")).reversed())
			.collect(Collectors.toList());
		
		return list.isEmpty() ? null : list.get(0).getString("country");
	}
	
	public String findCountryWithMostOfficialLanguagesIncludingGerman() {
		
		List<JSONObject> list =  this.countries.stream()
				.filter(elem -> elem.getJSONArray("languages").toList().contains("de"))
				.map(elemJsonObj -> {
						JSONObject newObj = new JSONObject();
						newObj.put("country", elemJsonObj.get("country"));
						newObj.put("countlanguages", elemJsonObj.getJSONArray("languages").length());
						return newObj;
				})
				.sorted(Comparator.comparing(elem -> ((JSONObject) elem).getInt("countlanguages")).reversed())
				.collect(Collectors.toList());
		
		return list.isEmpty() ? null : list.get(0).getString("country");
	}
	
	public int countAllListedLanguages() {
		
		Set<String> languages = new HashSet<String>();
		
		this.countries.stream()
				.map(elemJsonObj -> elemJsonObj.getJSONArray("languages"))
				.forEach(elem -> {
					for (Object string : elem.toList()) {
						languages.add((String) string);
					}
				});
		
		
		return languages.size();
	}
	
	public String findMostCommonLanguage() {
		
		Map<String, Integer> mapLanguagesOccurence = new HashMap<String, Integer>();
		
		this.countries.stream()
				.map(elemJsonObj -> elemJsonObj.getJSONArray("languages"))
				.forEach(elem -> {
					for (Object string : elem.toList()) {
						String language = (String) string;
						if (mapLanguagesOccurence.containsKey(language)) {
							mapLanguagesOccurence.put(language, mapLanguagesOccurence.get(language) + 1);
						}else {
							mapLanguagesOccurence.put(language, 1);
						}
					}
				});
		
		return mapLanguagesOccurence.isEmpty() ? null : mapLanguagesOccurence.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.iterator().next().getKey();
	}
}
