import java.util.ArrayList;
import java.util.List;

public class RecursionAndBacktracking{

/* 
    public static void recurPermute(int index,int[] nums,List<List<Integer>> ans,int n){
        if(index == n){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<n; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=index; i<n;i++){
            swap(index,i,nums);z
            recurPermute(index+1,nums,ans,n);
            swap(index,i,nums);
        }
    }
    public static void swap(int i, int j, int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }
    public static List<List<Integer>> permute(int[]nums){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        recurPermute(0,nums,ans,n);
        return ans;
    }*/
    
    /* 
    public static void solve(int col,char[][]board,List<List<String>>res ,int []leftrow,int[]lowerDiagonal,int[]upperDiagonal,int n){
        if(col == n){
            res.add(construct(board,n));
            return;
        }

        for(int row=0; row<n;row++){
            if(leftrow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1 + col - row]==0){
                board[row][col]='Q';
                leftrow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                solve(col+1,board,res,leftrow,lowerDiagonal,upperDiagonal,n);
                board[row][col]='.';
                leftrow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }
    public static List<String> construct(char[][]board,int n){
        List<String> s = new LinkedList<>();
        for(int i=0; i<n; i++){
            String str = new String(board[i]);
            s.add(str);
        }
        return s;
    }  
    public static List<List<String>> solveQueens(int n){
        char[][] board = new char[n][n];
        List<List<String>>res = new ArrayList<>();
        int leftrow[] = new int[n];
        int lowerDiagonal[] = new int[2*n -1];
        int upperDiagonal[] = new int[2*n -1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        solve(0,board,res,leftrow,lowerDiagonal,upperDiagonal,n);
        return res;
    }
    public static void main(String args[]) {
       int N = 8;
       List<List<String>> res = solveQueens(N);
       int i=1;
       for(List<String> it: res){
        System.out.println("Arrangement "+i);
        for(String s: it){
            System.out.println(s);
        }
        i+=1;
       }
    }
       */
/* 
    public static boolean solveSudoku(char[][] board) {
        for(int row = 0; row <9; row++){
            for(int col = 0; col<9; col++){
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,row,col,c)){
                        board[row][col]=c;

                        if(solveSudoku(board))
                        return true;
                        else
                        board[row][col]='.';
                    }
                }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][]board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c)return false;
            if(board[row][i]==c)return false;
            if(board[3 * (row/3) + i / 3][3 * (col/3) + i % 3]==c)return false;
        }
        return true;
    }
    public static void main(String[]args){
        char[][] board= {
            {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
            {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
            {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
            {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
            {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
            {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
            {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
            {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
            {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
            };
        solveSudoku(board);
        for(int row = 0; row<9; row++){
            for(int col = 0; col<9; col++){
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }
        */

    /*     
    public static boolean graphColoring(int v, List<int[]> G, int C) {
        int[] color = new int[v]; // Array to store colors for each node
        return solve(G, color, 0, C, v);
    }

    public static boolean isSafe(int node, List<int[]> G, int[] color, int C) {
        for (int[] edge : G) { // Iterate over edges
            if (edge[0] == node && color[edge[1]] == C) return false; // Neighbor has the same color
            if (edge[1] == node && color[edge[0]] == C) return false; // Neighbor has the same color
        }
        return true;
    }

    public static boolean solve(List<int[]> G, int[] color, int node, int M, int N) {
        if (node == N) {
            return true; // All nodes are colored
        }

        for (int i = 1; i <= M; i++) { // Try each color
            if (isSafe(node, G, color, i)) {
                color[node] = i; // Assign color

                if (solve(G, color, node + 1, M, N)) return true; // Recurse to the next node

                color[node] = 0; // Backtrack
            }
        }
        return false;
    }



        public static void main(String[] args) {
            int N = 4; // Number of nodes
            int M = 3; // Number of colors
            List<int[]> G = new ArrayList<>();
    
            // Add edges as adjacency lists (int[] format)
            G.add(new int[]{1, 3, 2}); // Node 0 is connected to 1, 3, 2
            G.add(new int[]{0, 2});    // Node 1 is connected to 0, 2
            G.add(new int[]{1, 3, 0}); // Node 2 is connected to 1, 3, 0
            G.add(new int[]{2, 0});    // Node 3 is connected to 2, 0
    
            // Call graph coloring method
            boolean ans = graphColoring(N, G, M);
            if (ans == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
        */
        private static void solve(int i, int j, ArrayList<ArrayList<Integer>> mat, int n, ArrayList<String> ans, String move,
                       int[][] vis, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                vis[nexti][nextj] == 0 && mat.get(nexti).get(nextj) == 1) {

                vis[i][j] = 1;
                solve(nexti, nextj, mat, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }

    // Main method to find all possible paths in the matrix
    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int[][] vis = new int[n][n];
        
        // Initializing visited matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        
        int[] di = { +1, 0, 0, -1 }; // Direction for down, left, right, up
        int[] dj = { 0, -1, 1, 0 };

        ArrayList<String> ans = new ArrayList<>();
        
        // Start the path search from (0, 0) if the starting point is valid
        if (mat.get(0).get(0) == 1) {
            solve(0, 0, mat, n, ans, "", vis, di, dj);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
        // Test input matrix (4x4 matrix)
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(List.of(1, 0, 0, 0)));
        mat.add(new ArrayList<>(List.of(1, 1, 0, 1)));
        mat.add(new ArrayList<>(List.of(1, 1, 0, 0)));
        mat.add(new ArrayList<>(List.of(0, 1, 1, 1)));

        ArrayList<String> res = findPath(mat);
        
        if (res.size() > 0) {
            for (String path : res) {
                System.out.print(path + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}
