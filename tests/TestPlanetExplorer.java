import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExplorer_constructor_2_obstacles() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		int NumberOfExplorer = explorer.obstacle.size();
		assertEquals(2,NumberOfExplorer);
	}
	
	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExplorer_constructor_5_5_explorer_true() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(5,5)");
		assertTrue(check);
	}
	
	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")
	public void test_PlanetExplorer_constructor_7_8_explorer_true() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_withoutleft_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_throw_withoutright_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_ContainOtherCharacter_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,.5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_XisLessThan1_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(0,100,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_YisLessThan1_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,0,"(5,5)(7,8)");
		boolean check = explorer.obstacle.containsKey("(7,8)");
		assertTrue(check);
	}
}
