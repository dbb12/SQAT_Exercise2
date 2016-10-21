import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	// Tests For PlanetExplorer Constructor
	
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
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_throw_withoutright_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8");
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_ContainOtherCharacter_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,.5)(7,8)");
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_XisLessThan1_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(0,100,"(5,5)(7,8)");
	}
	
	@Test( expected = PlanetExplorerException.class )
	public void test_PlanetExplorer_constructor_YisLessThan1_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,0,"(5,5)(7,8)");
	}
	
	@Test
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)")
	public void test_PlanetExplorer_constructor_4_obstacles() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		int NumberOfExplorer = explorer.obstacle.size();
		assertEquals(4,NumberOfExplorer);
	}
	
	@Test( expected = PlanetExplorerException.class )
	// PlanetExplorer explorer = new PlanetExplorer(100,100,"(120,5)(7,8)(20,4)(44,98)")
	public void test_PlanetExplorer_constructor_XisGreaterThan100_throw_PlanetExplorerException() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(120,5)(7,8)(20,4)(44,98)");
	}
	
	
	// Tests For executeCommand(String command)
	@Test
	public void test_executeCommand_command_initial_face_N() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		String result = explorer.executeCommand("");
		assertEquals("(0,0,N)",result);
	}
	
	@Test
	public void test_executeCommand_command_l_face_W() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		String result = explorer.executeCommand("l");
		assertEquals("(0,0,W)",result);
	}
	
	@Test
	public void test_executeCommand_command_r_face_W() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		String result = explorer.executeCommand("r");
		assertEquals("(0,0,E)",result);
	}
	
	@Test
	public void test_executeCommand_command_rrrr_face_W() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		String result = explorer.executeCommand("rrrr");
		assertEquals("(0,0,N)",result);
	}
	
	@Test
	public void test_executeCommand_command_rllr_face_W() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)(20,4)(44,98)");
		String result = explorer.executeCommand("rllr");
		assertEquals("(0,0,N)",result);
	}
	
	@Test
	public void test_executeCommand_command_ffrf_face_E() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"(0,2)");
		String result = explorer.executeCommand("ffrf");
		assertEquals("(1,1,E)(0,2)",result);
	}
	
	public void test_executeCommand_command_ffrflbblf_face_E() throws PlanetExplorerException {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"(0,2)");
		String result = explorer.executeCommand("ffrflbblf");
		assertEquals("(1,2,E)(0,2)",result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
