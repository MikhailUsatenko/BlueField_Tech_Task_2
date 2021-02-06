package usatenko.pojo;

import java.util.LinkedList;

public class ShortestPath {

    private static class Cell  {
        int x;
        int y;
        int dist;
        Cell prev;

        Cell(int x, int y, int dist, Cell prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }

        @Override
        public String toString(){
            return "(" + x + "," + y + ")";
        }
    }


    public static void shortestPath(char[][] matrix, int[] start, int[] end) {
        int sx = start[0], sy = start[1];
        int dx = end[0], dy = end[1];

        if (matrix[sx][sy] == '#' || matrix[dx][dy] == '#')
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        Cell[][] cells = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '#') {
                    cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
                }
            }
        }

        LinkedList<Cell> queue = new LinkedList<>();
        Cell src = cells[sx][sy];
        src.dist = 0;
        queue.add(src);
        Cell dest = null;
        Cell p;
        while ((p = queue.poll()) != null) {

            if (p.x == dx && p.y == dy) {
                dest = p;
                break;
            }

            visit(cells, queue, p.x - 1, p.y, p);
            visit(cells, queue, p.x + 1, p.y, p);
            visit(cells, queue, p.x, p.y - 1, p);
            visit(cells, queue, p.x, p.y + 1, p);
        }

        if (dest == null) {
            return;
        } else {
            LinkedList<Cell> path = new LinkedList<>();
            p = dest;
            do {
                path.addFirst(p);
            } while ((p = p.prev) != null);
            path.removeFirst();
            System.out.print("Shortest path: ");
            path.forEach(cell -> {
                if (cell.x > cell.prev.x) System.out.print("d,");
                if (cell.x < cell.prev.x) System.out.print("u,");
                if (cell.y > cell.prev.y) System.out.print("r,");
                if (cell.y < cell.prev.y) System.out.print("l,");
            });
        }
    }


    static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
        if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
            return;
        }

        int dist = parent.dist + 1;
        Cell p = cells[x][y];
        if (dist < p.dist) {
            p.dist = dist;
            p.prev = parent;
            queue.add(p);
        }
    }
}
