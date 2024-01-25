package runstatic.leetcode.i31_40;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmoand
 */
public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {

        final Set<Integer> rowSet = new HashSet<>();
        int addRowNum = 0;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                char chr = board[x][y];
                if (chr != '.') {
                    int value = chr - 48;
                    rowSet.add(value);
                    ++addRowNum;
                }
                if (x == 8 && rowSet.size() != addRowNum) {
                    return false;
                }
            }
            addRowNum = 0;
            rowSet.clear();
        }

        final Set<Integer> colSet = new HashSet<>();
        int addColNum = 0;

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char chr = board[x][y];
                if (chr != '.') {
                    int value = chr - 48;
                    colSet.add(value);
                    ++addColNum;
                }
                if (y == 8 && colSet.size() != addColNum) {
                    return false;
                }
            }
            addColNum = 0;
            colSet.clear();
        }

        final Set<Integer> blockSet = new HashSet<>();
        int addBlockNum = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Integer value = getInteger(board[x * 3 + i][y * 3 + j]);
                        if (value != null) {
                            blockSet.add(value);
                            ++addBlockNum;
                        }
                    }
                }
                if (blockSet.size() != addBlockNum) {
                    return false;
                }
                addBlockNum = 0;
                blockSet.clear();
            }
        }

        return true;
    }

    private Integer getInteger(char chr) {
        if (chr == '.') {
            return null;
        }
        return chr - 48;
    }


    @Test
    public void testCase() {
        // boolean validSudokuOne = isValidSudoku(new char[][]{
        //         {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        //         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        //         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        //         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        //         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        //         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        //         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        //         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        //         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        // });
        //
        // System.out.println(validSudokuOne);

        boolean validSudokuTwo = isValidSudoku(new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        });

        System.out.println(validSudokuTwo);
    }


}
