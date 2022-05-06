package countries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	
	World world;
	
	@Before
	public void init() throws Exception {
		String strJson = "[{"
				+ "country: \"US\","
				+ "languages: [ \"en\", \"es\", \"fy\", \"fr\", \"br\" ]"
				+ "},"
				+ "{"
				+ "country: \"BE\","
				+ "languages: [ \"nl\", \"fr\", \"de\" ]"
				+ "},"
				+ "{"
				+ "country: \"NL\","
				+ "languages: [ \"nl\", \"fy\", \"es\" ]"
				+ "},"
				+ "{"
				+ "country: \"DE\","
				+ "languages: [ \"de\" ]"
				+ "},"
				+ "{"
				+ "country: \"ES\","
				+ "languages: [ \"es\" ]"
				+ "},"
				+ "{"
				+ "country: \"JP\","
				+ "languages: [ \"jp\" ]"
				+ "}"
				+ "]";
		
		this.world = new World(strJson);
	}
	
	@Test(expected = Exception.class)
	public void testConstructorExceptionStringEmpty() throws Exception {
		
		new World("");
	}
	
	@Test(expected = Exception.class)
	public void testConstructorExceptionStringNull() throws Exception {
		
		new World(null);
	}
	
	@Test
	public void testCountCountries() {
		
		int expectedValue = 6;
		
		assertEquals(expectedValue, this.world.countCountries());
	}
	
	@Test
	public void testCountCountriesEmpty() throws Exception {
		
		World world = new World("[]");
		
		int expectedValue = 0;
		
		assertEquals(expectedValue, world.countCountries());
	}
	
	@Test
	public void testFindCountryWithHighestNumberLanguages() {
		
		String expectedValue = "US";
		
		assertEquals(expectedValue, this.world.findCountryWithHighestNumberLanguages());
	}
	
	@Test
	public void testFindCountryWithHighestNumberLanguagesEmpty() throws Exception {
		
		World world = new World("[]");
		
		assertNull(world.findCountryWithHighestNumberLanguages());
	}
	
	@Test
	public void testFindCountryWithMostOfficialLanguagesIncludingGerman() {
		
		String expectedValue = "BE";
		
		assertEquals(expectedValue, this.world.findCountryWithMostOfficialLanguagesIncludingGerman());
	}
	
	@Test
	public void testFindCountryWithMostOfficialLanguagesIncludingGermanEmpty() throws Exception {
		
		World world = new World("[]");
		
		assertNull(world.findCountryWithMostOfficialLanguagesIncludingGerman());
	}
	
	@Test
	public void testCountAllListedLanguages() {
		
		int expectedValue = 8;
		
		assertEquals(expectedValue, this.world.countAllListedLanguages());
	}
	
	@Test
	public void testCountAllListedLanguagesEmpty() throws Exception {
		
		World world = new World("[]");
		
		int expectedValue = 0;
		
		assertEquals(expectedValue, world.countAllListedLanguages());
	}
	
	@Test
	public void testCountAllListedLanguagesBetweenCountriesWithSameLanguages() throws Exception {
		
		String strJson = "[{"
				+ "country: \"US\","
				+ "languages: [ \"en\" ]"
				+ "},"
				+ "{"
				+ "country: \"BE\","
				+ "languages: [ \"en\" ]"
				+ "},"
				+ "{"
				+ "country: \"BR\","
				+ "languages: [ \"en\" ]"
				+ "}"
				+ "]";
		
		World world = new World(strJson);
		
		int expectedValue = 1;
		
		assertEquals(expectedValue, world.countAllListedLanguages());
	}
	
	@Test
	public void testFindMostCommonLanguage() {
		
		String expectedValue = "es";
		
		assertEquals(expectedValue, this.world.findMostCommonLanguage());
	}
	
	@Test
	public void testFindMostCommonLanguageEmpty() throws Exception {
		
		World world = new World("[]");
		
		assertNull(world.findMostCommonLanguage());
	}

}
