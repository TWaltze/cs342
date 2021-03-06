package pa2;

public class NQueens {
	private StackArray<Integer> board;	// index = row, data = column
	private int n;						// Number of queens
 
    public NQueens(int n){
        this.n = n;
        this.board = new StackArray<Integer>();
    }
    
    public NQueens(){
        this(8);
    }
 
    private boolean isValid(StackArray<Integer> board) {
        if (board.size() == 1) {
            return true;
        }
 
        /**
         * Check for diagonal conflicts, y = mx + b
		 *
         * Find the slope of the newest queen and compare it to all
         * the other queens. If the differences in x and y are equal,
         * then the newest queen on the stack conflicts with another queen.
         */
        int size = board.size() - 1;
        int lastX = size;
        int lastY = board.get(lastX);
        for (int i = 0; i < size; i++) {
            // Check horizontal conflict
            if (board.peek() == board.get(i)) {
                return false;
            }
 
            int xDiff = Math.abs(lastX - i);
            int yDiff = Math.abs(lastY - board.get(i));
 
            // Conflict
            if (xDiff == yDiff) {
                return false;
            }
        }
        return true;
    }
 
    private StackArray<Integer> compute(StackArray<Integer> board){
    	// Base case: When the board size and n are equal, we've found
    	// a valid configuration for all queens.
        if (this.n == board.size()) {
            return board;
        }
        
        for (int i = 0; i < this.n; i++) {
            // Push i (a column) onto the stack (next row)
        	board.push(i);
            
            // Check for valid placement
            if (isValid(board)) {
                // Try to place something in the next column
                StackArray<Integer> tmp = this.compute(board);
                
                // Non-null value means a valid configuration.
                if (tmp != null) {
                    return tmp;
                }
            }
            
            // No valid configuration. Backtrack. 
            board.pop();
        }
        
        // Backtrack.
        return null;
    }
 
    public String toString(){
        String s = "";
        s += this.board.toString();
 
        // rows
        for (int i = 0; i < this.n; i++) {
            s += "\n";
            // column in each row
            for (int j = 0; j < this.n; j++) {
            	// Check if stack has a queen in the column of this row
                if (this.board.get(i) == j) {
                    s += "| " + this.board.get(i) + " ";
                } else {
                    s += "|   ";
                }
            }
            s += "|";
        }
        
        return s.toString();
    }
    
    public void solve(){
        this.board = compute(new StackArray<Integer>());
    }
    
    public static void main(String argv[]){
        NQueens queens = new NQueens(8);
        queens.solve();
        
        System.out.println(queens);
    }
}
