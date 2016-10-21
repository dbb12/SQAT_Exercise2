import java.util.HashMap;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:164
// Finish time:


public class PlanetExplorer {
	
	public HashMap<String,Boolean> obstacle = new HashMap<String,Boolean>();
	public int x, y;
	
	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		this.x = x;
		this.y = y;
		int LeftPosition = 0,   // LeftPosition:   record the index of '(' in the String - obstacles
			RightPosition = 0;  // RightPosition:  record the index of ')' in the String - obstacles		         
		if( !obstacles.startsWith("(") || !obstacles.endsWith(")") || x<1 || y<1 )
			throw new PlanetExplorerException();
		// put all the obstacles into the HashMap<String,Boolean> obstacle.
		while( RightPosition!=-1 && RightPosition<obstacles.length() )
		{
			RightPosition = obstacles.indexOf(")(");
			int DotPosition = obstacles.indexOf(","); // record the index of ","
			if( RightPosition==-1 )
				break;
			for( int i=LeftPosition+1 ; i<RightPosition ; ++i )
			{
				if( !( (obstacles.charAt(i)<='9' && obstacles.charAt(i)>='0') || obstacles.charAt(i)== ',') )
					throw new PlanetExplorerException();
			}
			int TempX = Integer.parseInt(obstacles.substring(0, DotPosition ));
			int TempY = Integer.parseInt(obstacles.substring(DotPosition+1, RightPosition+1 ));
			if( TempX>x || TempY>y )
				throw new PlanetExplorerException();
			obstacle.put(obstacles.substring(LeftPosition, RightPosition+1), false);
			obstacles = obstacles.replace(obstacles.substring(LeftPosition, RightPosition+1 ),"");
			LeftPosition = 0;
		}
		// to deal with the last obstacle
		RightPosition = obstacles.length() - 1;
		for( int i=LeftPosition+1 ; i<RightPosition ; ++i )
		{
			if( !(obstacles.charAt(i)<='9' && obstacles.charAt(i)>='0' || obstacles.charAt(i)== ',') )
				throw new PlanetExplorerException();
		}
		obstacle.put(obstacles.substring(LeftPosition, RightPosition+1), false);
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		return null;
	}
}
