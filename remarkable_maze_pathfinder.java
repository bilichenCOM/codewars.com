public class Finder {    
    static boolean pathFinder(String maze) {
        // xour code here!!
        maze = maze.replaceAll("[^W^(\\.)]","");
        maze = maze.replaceAll("\\.","P");
        int len = maze.length();
        int n = (int)Math.sqrt(len);
        String[][] map = new String[n][n];

        for(int i = 0; i<n; i++) {
          String s ="";
          for(int j = 0; j<n; j++) {
            map[i][j]=maze.substring(i*n+j, i*n+j+1);
            s+=map[i][j];
          }
        }
        return isWay(map, 0 ,0);
    }
  
    public static boolean isWay(String[][] map, int y, int x) {
  		int n = map.length;
      
  		if(y==(n-1)&&x==(n-1)) return true;
      if(map[y][x].equals("O")) map[y][x]="W";
      else map[y][x]="O";
  		if(
         (((y+1)<n&&map[y+1][x].equals("P"))&&((x+1)<n&&map[y][x+1].equals("P")))||
         (((y+1)<n&&map[y+1][x].equals("P"))&&((y-1)>=0&&map[y-1][x].equals("P")))||
         (((y+1)<n&&map[y+1][x].equals("P"))&&((x-1)>=0&&map[y][x-1].equals("P")))||
         (((x+1)<n&&map[y][x+1].equals("P"))&&((y-1)>=0&&map[y-1][x].equals("P")))||
         (((x+1)<n&&map[y][x+1].equals("P"))&&((x-1)>=0&&map[y][x-1].equals("P")))||
         (((y-1)>=0&&map[y-1][x].equals("P"))&&((x-1)>=0&&map[y][x-1].equals("P")))
        )
        map[y][x]="C";
		
  		if((y+1)<n&&map[y+1][x].equals("P")) return isWay(map, y+1, x);
  		if((x+1)<n&&map[y][x+1].equals("P")) return isWay(map, y, x+1);
  		if((y-1)>=0&&map[y-1][x].equals("P")) return isWay(map, y-1, x);
  		if((x-1)>=0&&map[y][x-1].equals("P")) return isWay(map, y, x-1);
  		
  		map[y][x]="W";
      
  		if((y-1)>=0&&map[y-1][x].equals("O")) return isWay(map, y-1, x);
		if((x-1)>=0&&map[y][x-1].equals("O")) return isWay(map, y, x-1);
		if((y+1)<n&&map[y+1][x].equals("O")) return isWay(map, y+1, x);
		if((x+1)<n&&map[y][x+1].equals("O")) return isWay(map, y, x+1);
      
		if((y-1)>=0&&map[y-1][x].equals("C")) return isWay(map, y-1, x);
		if((x-1)>=0&&map[y][x-1].equals("C")) return isWay(map, y, x-1);
		if((y+1)<n&&map[y+1][x].equals("C")) return isWay(map, y+1, x);
		if((x+1)<n&&map[y][x+1].equals("C")) return isWay(map, y, x+1);
      
  		return false;
	  }  
}