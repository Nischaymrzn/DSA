package algorithms;

import java.util.ArrayList;
import java.util.List;

class NQueens {
    public static boolean isSafe(int row, int col, char[][] chess) {
        // Horizontal Checking
        for (int j = 0; j < chess.length; j++) {
            if (chess[row][j] == 'Q') {
                return false;
            }
        }

        //Vertical Checking
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal Checking
        // Upward Left Diagonal
        int i = row;
        for (int j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Downward Right Diagonal
        i = row;
        for (int j = col; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Upward Right Diagonal
        i = row;
        for (int j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // Downward Left Diagonal
        i = row;
        for (int j = col; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void helper(char[][] chess, int col, List<List<String>> allBoard) {
        if (col == chess.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                StringBuilder tempStr = new StringBuilder();
                for (int j = 0; j < chess[i].length; j++) {
                    if (chess[i][j] == 'Q') {
                        tempStr.append('Q');
                    } else {
                        tempStr.append('.');
                    }
                }
                temp.add(tempStr.toString());
            }
            allBoard.add(temp);
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            if (isSafe(i, col, chess)) {
                chess[i][col] = 'Q';
                helper(chess, col + 1, allBoard);
                chess[i][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> allBoard = new ArrayList<>();
        helper(new char[4][4], 0, allBoard); // helper function for backtracking to previous state
        System.out.println(allBoard);
    }
}