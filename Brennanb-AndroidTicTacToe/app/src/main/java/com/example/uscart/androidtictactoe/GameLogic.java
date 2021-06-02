package com.example.uscart.androidtictactoe;
/**
 * @author Brian Sea
 * @author Brennan Benson
 * @date 08/15/2017
 */

public class GameLogic {

    // The board spaces
    // -1 = O, 1 = X, 0 = empty space
    private int[] board;

    // Whose turn it is; -1 = O, 1 = X
    private int turn;
    private int boardLength;

    /**
     * Constructs a Tic-Tac-Toe logic with nine spaces
     */
    public GameLogic(int boardLength1) {
        // Create the array of nine spaces

        //Create the array of nine spaces
        boardLength = boardLength1;
        boardLength = boardLength * boardLength;
        board = new int[boardLength];
        reset();
    }

    /**
     * Get the number of spaces in the game.  The board will always
     * be square.
     * @return the total number of space in the game.
     */
    public int numSpaces() {
        return board.length;
    }

    /**
     * Resets the board to starting positions.
     * X always goes first
     */
    public void reset(){
        for( int i = 0; i < board.length; i++ ) {
            board[i] = 0;
        }
        turn = 1;  // X always goes first
    }

    /**
     * @param i the space to make the next move [0, numSpaces-1]
     * @return true if the move was made, false for an invalid move
     */
    public boolean makeMove( int i )
    {
        boolean rtn = false;

        // Make sure that i is within the board
        if( i >= 0 && i < board.length ) {

            //Make the move and change the turn

            board[i] = turn;
            turn = turn * -1;

        }
        return rtn;
    }


    /**
     * @return "X" if X wins, "O" if O wins, "Tie" if the game is a tie, or "" if the game is not over
     */
    public String checkWin() {
        String rtn = "";

		/*  The board is represented as follows:
		 *     -------------
		 *     | 0 | 1 | 2 |
		 *     -------------
		 *     | 3 | 4 | 5 |
		 *     -------------
		 *     | 6 | 7 | 8 |
		 *     -------------
		 *
		 *     Since O is -1 and X is 1, if the
		 *     sum of any row or column or diagonal
		 *     adds to 3 or -3, we know that we have
		 *     a winner
		 */

        int boardLength = (int)Math.sqrt(board.length);
        //check Rows
        for(int i = 0; i < board.length; i+=Math.sqrt(board.length)){
            int sum = 0;
            for(int count = 0; count < Math.sqrt(board.length); count+=1) {
                sum += board[count+i];
            }
            if (sum == boardLength) {rtn = "X";}
            if (sum == -boardLength) {rtn = "O";}
        }

        // Check Coloumns
        for(int i = 0; i < Math.sqrt(board.length); i++){
            int sum = 0;
            for(int count = 0; count < board.length; count+=Math.sqrt(board.length)) {
                sum += board[count+i];
            }
            if (sum == boardLength) {rtn = "X";}
            if (sum == -boardLength) {rtn = "O";}
        }


        // Check Diagonals (r-l)
        int sum = 0;
        for(int i = 0; i < board.length; i+=Math.sqrt(board.length)+1) {
            sum += board[i];
            if (sum == boardLength) {rtn = "X";}
            if (sum == -boardLength) {rtn = "O";}
        }

        //check l->r diagonal win
        sum = 0;
        for(int i = (int)Math.sqrt(board.length)-1; i <= board.length-Math.sqrt(board.length); i+=Math.sqrt(board.length)-1) {
            sum += board[i];
            if (sum == boardLength) {rtn = "X";}
            if (sum == -boardLength) {rtn = "O";}
        }

        // Check for a Tie
        //TODO:  Check for a tie. You may add a field for this to work
        if(rtn != "X" && rtn != "O") {
            int countUsedSpaces = 0;
            for(int i = 0; i < board.length; i++) {
                if(board[i] == -1 || board[i] == 1) {countUsedSpaces+=1;}
            }
            if(countUsedSpaces == board.length) {
                rtn = "Tie";
            }
        }

        return rtn;
    }

    /**
     * @param space the index of the space to check [0, numSpace() - 1]
     * @return the player in the space; An empty string is returned if the space is blank.
     */
    public String getPlayer( int space ) {
        String rtn = "";

        // Check that the space is in the board
        if( space >= 0 && space < board.length )
        {
            // It is, so translate it the player number
            // into a human readable string
            if( board[space ] == 1 ) {
                rtn = "X";
            }
            else if( board[space] == -1 )
            {
                rtn = "O";
            }
        }
        return rtn;
    }
}
