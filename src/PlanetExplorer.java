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
			int TempX = Integer.parseInt(obstacles.substring(1, DotPosition ));
			int TempY = Integer.parseInt(obstacles.substring(DotPosition+1, RightPosition ));
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
	
	public String executeCommand(String command) throws PlanetExplorerException {
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		int pos_x = 0, pos_y = 0; // coordinates of the position of the explorer
		String facing = "N";
		String result = "";
		String obs = "";
		for( int i=0 ; i<command.length() ; ++i )
		{
			char cmd = command.charAt(i);
			if ( !check(cmd) )
				throw new PlanetExplorerException();
			switch( cmd )
			{
			case 'r' :  // Do not move. Turn right.
				facing = int_to_facing( ((facing_to_int(facing) + 1))%4 ); break;
			case 'l' :  // Do not move. Turn left.
				facing = int_to_facing( ((facing_to_int(facing) + 3))%4 );break;
			case 'f' :  // Do not turn. Move forward.
			{
				Integer temp_x = pos_x, temp_y = pos_y;
				get_next_pos(temp_x, temp_y, facing);
				if( obstacle.containsKey("(" + String.valueOf(temp_x) + "," + String.valueOf(temp_y) + ")" ) )
				{
					if( !obstacle.get("(" + String.valueOf(temp_x) + "," + String.valueOf(temp_y) + ")") )
					{
						obs += "(" + String.valueOf(temp_x) + "," + String.valueOf(temp_y) + ")";
						obstacle.put("(" + String.valueOf(temp_x) + "," + String.valueOf(temp_y) + ")", true);  // TODO: change the value
					}
				}
				else
				{
					pos_x = temp_x;	 pos_y = temp_y;
				}
			}
			case 'b' :  // Do not turn. Move backward.
				
			}
		}
		
		
		
		result = "(" + String.valueOf(pos_x) + "," + String.valueOf(pos_y) + "," + facing + ")" + obs ;
		return result;
	}
	
	private boolean check(char ch) {
		if( ch!='f' && ch!='b' && ch!='l' && ch!='r')
			return false;
		return true;
	}
	
	private int facing_to_int (String facing) throws PlanetExplorerException {
		switch( facing )
		{
		case "N" : return 0;
		case "E" : return 1;
		case "S" : return 2;
		case "W" : return 3;
		}
		throw new PlanetExplorerException();
	}
	
	private String int_to_facing ( int f) throws PlanetExplorerException {
		switch( f )
		{
		case 0: return "N";
		case 1: return "E";
		case 2: return "S";
		case 3: return "W";
		}
		throw new PlanetExplorerException();
	}
	
	private void get_next_pos(Integer temp_x, Integer temp_y, String facing) throws PlanetExplorerException {
		switch( facing )
		{
		case "N" : temp_y = (temp_y + 1) % y; break;
		case "E" : temp_x = (temp_x + 1) % x; break;
		case "S" : temp_y = (temp_y + y - 1) % y; break;
		case "W" : temp_x = (temp_x + x -1 ) % x; break;
		}
		throw new PlanetExplorerException();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
