package pa2;

public class NQueens {
	private StackArray<Integer> board;	// index = row, data = column
	private int n;	// Number of queens
 
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
         * We have to check for diagonal conflicts, y = mx + b
		 *
         * Find the slope of the last queen location on the stack and compare it to
         * all the other queen positions. If the differences in x and y are equal,
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
        // If the board size is equal to n we have a valid configuration
        if (this.n == board.size()) {
            return board;
        }
        
        for (int i = 0; i < this.n; i++) {
            // Push i onto the stack
        	board.push(i);
            
            // Check for valid placement
            if (isValid(board)) {
                // Try to place something in the next column
                StackArray<Integer> tmp = this.compute(board);
                
                if (tmp != null) {
                    // Non-null value means a valid configuration.
                    return tmp;
                }
            }
            
            // Backtrack because there is no valid configuration
            board.pop();
        }
        
        // If we reach this point we need to backtrack.
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
