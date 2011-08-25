package eu.devclub.sudoku;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BoardTest {

  @Test
  public void fieldSize9x9() {
    Board board = new Board(new int[9][9]);
    assertThat(board.cells.length, equalTo(9));
    assertThat(board.cells[0].length, equalTo(9));
  }

  @Test
  public  void whenBoardCreatedThenCellsAreCreated()  {
    int[][] cells = new int[][]{{0,1}, {0,1}};
    Board board = new Board(cells);
    assertThat(board.cells, equalTo(cells));
  }

  @Test
  public void allNumbersInRowAreUniqueFailed() {

    int[][] validRow = new int[][]{
                                    {1,2,3,4,6,6,7,8,9},
                                    {1,2,3,4,6,6,7,8,9}
                                  };
    Board board = new Board(validRow);
    assertThat(board.isRowValid(0), is(false));
  }

  @Test
  public void validRowTestReturnsTrue() {
    int[][] validRow = new int[][]{
                                    {1,2,3,4,5,6,7,8,9},
                                    {1,2,3,4,5,6,7,8,9}
                                  };
    Board board = new Board(validRow);
    assertThat(board.isRowValid(0), is(true));
  }

  @Test
  public void zeroesAreAllowed() {
    int[][] validRowBoard = new int[][]{
                                    {1,2,3,4,0,0,7,8,9},
                                    {1,2,3,4,5,6,7,8,9}
                                  };
    Board board = new Board(validRowBoard);
    assertThat(board.isRowValid(0), is(true));
  }

  @Test
  public void ColumnBothValidAndInvalid() {
    int[][] invalidColumnBoard = new int[][]{
                                    {1,2,3,4,0,0,7,0,9},
                                    {1,2,3,4,5,6,7,0,9}
                                  };
    Board board = new Board(invalidColumnBoard);
    assertThat(board.isColumnValid(0), is(false));
    assertThat(board.isColumnValid(4), is(true));
    assertThat(board.isColumnValid(7), is(true));
  }

  @Test
  public void testValidityOfSquares() {
    int[][] matrix = new int[][]{
      {1,2,3,4,0,0,7,0,9},
      {4,5,6,3,0,0,7,0,9},
      {7,8,9,1,0,0,7,0,9},
      {1,2,3,4,5,6,7,0,9},
      {1,2,3,4,0,0,7,0,9},
      {1,2,3,4,0,0,7,0,9},
      {1,2,3,4,0,0,7,0,9},
      {1,2,3,4,5,6,7,0,9},
      {1,2,3,4,5,6,7,0,9}
    };
  Board board = new Board(matrix);
  assertThat(board.isSquareValid(0, 0), is(true));
  assertThat(board.isSquareValid(0, 3), is(true));
  assertThat(board.isSquareValid(0, 6), is(false));
  }

  @Test
  public void testThatBoardIsValid() {
        int[][] matrix = new int[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,4},
      {2,8,7,4,1,9,6,3,5},
      {3,4,5,2,8,6,1,7,9}
    };
    Board board = new Board(matrix);
    assertTrue(board.isValid());
  }
}
