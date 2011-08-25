package eu.devclub.sudoku;

import java.awt.*;

public class Solver {
  public Board solve(Board puzzle) {
    Point point = findZero(puzzle);
    if (point == null)
      return puzzle.isValid() ? puzzle : null;

    for (int candidate = 1; candidate <= 9; candidate++) {
      puzzle.set(point, candidate);

      if (puzzle.isValid()) {
        if (solve(puzzle) != null) return puzzle;
      }
    }

    puzzle.set(point, 0);
    return null;
  }

  private Point findZero(Board puzzle) {
    for (int i = 0; i < 9; i++)
      for (int j = 0; j < 9; j++)
        if (puzzle.cells[i][j] == 0) return new Point(i, j);
    return null;
  }

  public boolean isSolved(Board board) {

    for (int y = 0; y < 9; y++)
      for (int x = 0; x < 9; x++)
        if (board.cells[y][x] == 0)
          return false;
    if (!board.isValid())
      return false;
    return true;
  }
}
