# Kuromasu

![Kuromasu](https://www.gmpuzzles.com/images/puzzles/KuromasuEx.png)

This is project is an exact algorithm to solve a small kuromasu puzzle.

## About the game
Kuromasu (also known as Where Is The Black Cell) is a binary-determination logic puzzle published by Nikoli.

## How to play
Kuromasu is played on a rectangular grid. Some of these cells have numbers in them. Each cell may be either black or white. The object is to determine what type each cell is.

The following rules determine which cells are which:

- Each number on the board represents the number of white cells that can be seen from that cell, including itself. A cell can be seen from another cell if they are in the same row or column, and there are no black cells between them in that row or column.
- Numbered cells may not be black.
- No two black cells may be horizontally or vertically adjacent.
- All the white cells must be connected horizontally or vertically.

