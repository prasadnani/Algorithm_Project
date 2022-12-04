package Algorithms;
public class Maze {

	
//Taking input size 4 for 4*4 matrix
int n= 4;

//To verify the index is valid for n*n matrix 

boolean isValid(int[][] m,int i, int j)
{
//if i,j is not part of maze then it is not valid it should return false
   return ((i>=0) && (i<n) && (j>=0) && (j<n) && (m[i][j]==1));
 } 
    //The below function uses backtracking
    boolean backMaze(int[][] m)
    {
        int[][] ans = {{0,0,0,0},{0,0,0,0},{0,0,0,0 },{0,0,0,0}};
        if (solMaze(m,0,0,ans)==false) 
        {
         System.out.println("Path not found");
         return false;
        }
       printSolution(ans);
       return true;
    }
    boolean solMaze(int[][] m,int i,int j,int[][] ans)
    {
      if (i==n-1 && j==n-1) 
      {
        ans[i][j]=1;
        return true;
       }
      if (isValid(m,i,j)==true) 
       {
        ans[i][j] = 1;
        if (solMaze(m, i + 1, j, ans))
        {
         return true;
        }
        if (solMaze(m, i, j + 1, ans))
        {
         return true;
        }
          ans[i][j] = 0;
          return false;
        }
       return false;
     }
    
 // To print the final answer for matrix 
   public void printSolution(int[][] ans)
   {
     for (int a = 0; a < n; a++)
       {
         for (int b = 0; b < n; b++)
            {
                 System.out.print(" " + ans[a][b] + " ");
             }
             System.out.println();
         }
    }

    //INPUT
    public static void main(String args[])
    {
        Maze rat = new Maze();
        int[][] m= {{1,0,1,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        rat.backMaze(m);
    }
}

