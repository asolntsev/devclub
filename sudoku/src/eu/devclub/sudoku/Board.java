package eu.devclub.sudoku;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
  final int[][] cells = new int[9][9];

  public Board(int[][] cells) {

    for(int i =0;i<cells.length;i++){
      for(int j=0;j<cells[i].length;j++){
         this.cells[i][j] = cells[i][j];
      }
    }
  }

  public Boolean isRowValid(int rowIndex) {
    return hasAllUniques(getRow(rowIndex));
  }

  public Boolean isColumnValid(int columnIndex) {
    return hasAllUniques(getColumn(columnIndex));
  }

  private List<Integer> getColumn(int columnIndex) {
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < cells.length; i++) {
      numbers.add(cells[i][columnIndex]);
    }
    return numbers;
  }

  private Boolean hasAllUniques(List<Integer> row) {
    Set<Integer> uniques = new HashSet<Integer>();
    int totalNumbersKnown = 0;
    for (int i : row) {
      if (i != 0) {
        totalNumbersKnown++;
        uniques.add(i);
      }
    }

    return uniques.size() == totalNumbersKnown;
  }

  private List<Integer> getRow(int rowIndex) {
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i : cells[rowIndex]) {
      numbers.add(i);
    }
    return numbers;
  }


  public Boolean isSquareValid(int rowIndex, int columnIndex) {
    Set<Integer> allNumbers = new HashSet<Integer>();
    for (int k = rowIndex; k < rowIndex + 3; k++) {
      for (int j = columnIndex; j < columnIndex + 3; j++) {
        if (this.cells[k][j] == 0)
          continue;
        if (allNumbers.contains(this.cells[k][j]))
          return false;
        allNumbers.add(this.cells[k][j]);
      }
    }


    return true;
  }

  public boolean isValid() {
    for (int i = 0; i < 9; i++) {
      if (!isRowValid(i))
        return false;
    }

    for (int i = 0; i < 9; i++) {
      if (!isColumnValid(i))
        return false;
    }

    return isSquareValid(0, 0) &&
           isSquareValid(0, 3) &&
           isSquareValid(0, 6) &&
           isSquareValid(3, 0) &&
           isSquareValid(3, 3) &&
           isSquareValid(3, 6) &&
           isSquareValid(6, 0) &&
           isSquareValid(6, 3) &&
           isSquareValid(6, 6);
  }

  public void set(Point point, int candidate) {
    cells[(int)point.getX()][(int)point.getY()] = candidate;
 }
}
