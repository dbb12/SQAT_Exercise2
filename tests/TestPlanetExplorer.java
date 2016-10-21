import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExplorer_constructor_2_obstacles() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		int NumberOfExplorer = explorer.obstacle.size();
		assertEquals(2,NumberOfExplorer);
	}
	
	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExplorer_constructor_5_5_explorer_true() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(5,5)");
		assertTrue(check);
	}
	
	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExporer_constructor_7_8_explorer_true() {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
}
