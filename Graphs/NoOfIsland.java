package Graphs;

public class NoOfIsland {
    public void IslandDFS(int[][] islandId, char[][] grid, boolean visited[][], int row, int col, int count){
        if (row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0' || visited[row][col]){
            return;
        }
        else{
            visited[row][col]= true;
            islandId[row][col]= count;
            IslandDFS(islandId, grid, visited, row-1, col, count);
            IslandDFS(islandId, grid, visited, row+1, col, count);
            IslandDFS(islandId, grid, visited, row, col-1, count);
            IslandDFS(islandId, grid, visited, row, col+1, count);
        }
    }

    public int IslandCount(char[][] grid){
        boolean visited[][]= new boolean[grid.length][grid.length];
        int islandId[][]= new int[grid.length][grid.length];

        int count=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (!visited[i][j] && grid[i][j]=='1'){
                    IslandDFS(islandId, grid, visited, i, j, count);
                    count++;
                }
            }
        }

        System.out.println("The islands are:");
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(islandId[i][j]+ "\t");
            }
            System.out.println("");
        }
        return count-1;
    }
    public static void main(String[] args) {
        int dimension= 4;
        char[][] grid= new char[dimension][dimension];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                grid[i][j]='0';
            }
        }

        grid[0][0]='1';
        grid[0][1]='1';
        grid[1][0]='1';
        grid[2][2]='1';
        grid[3][3]='1';

        NoOfIsland obj1= new NoOfIsland();
        int count=obj1.IslandCount(grid);
        System.out.println("No.of Island in the givan grid is : " + count);
    }
}
