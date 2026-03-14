public class MazeSolver {

    private char[][] maze;

    // constructor just stores the maze
    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    // prints the maze nicely
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    // wrapper to find 'S' and start recursion
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;

        // look for the starting point
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        // start the recursive solve
        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    // the main recursive method
    private boolean solve(int row, int col) {

        // check if we are out of bounds
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) return false;

        // check if this cell is a wall or already visited
        if (maze[row][col] == '#' || maze[row][col] == '.') return false;

        // check if we reached the finish
        if (maze[row][col] == 'F') return true;

        // mark the path with a dot so we don't revisit
        char temp = maze[row][col];
        maze[row][col] = '.';

        // try all four directions: North, East, South, West
        if (solve(row - 1, col)) return true; // North
        if (solve(row, col + 1)) return true; // East
        if (solve(row + 1, col)) return true; // South
        if (solve(row, col - 1)) return true; // West

        // backtracking: no path found from this cell, unmark it
        maze[row][col] = temp;
        return false;
    }

    public static void main(String[] args) {
        // first maze with a solution
        char[][] maze1 = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver1 = new MazeSolver(maze1);

        System.out.println("Maze 1 Original:");
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Maze 1 Solution Found:");
        } else {
            System.out.println("Maze 1 No Solution Found:");
        }
        solver1.printMaze();

        // second maze with no solution
        char[][] maze2 = {
            {'#', '#', '#', '#', '#'},
            {'#', 'S', '#', 'F', '#'},
            {'#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(maze2);

        System.out.println("Maze 2 Original:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Maze 2 Solution Found:");
        } else {
            System.out.println("Maze 2 No Solution Found:");
        }
        solver2.printMaze();
    }
}
