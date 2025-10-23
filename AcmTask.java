import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class AcmTask extends GraphicsProgram {
    private static final int FIGURE_SIZE = 20;
    private static final int LINE_LENGTH = 160;
    private static final int MARGIN = 20;
    private static final int CELLS = 3;
    private static final int CELL_SIZE = LINE_LENGTH / CELLS;
    RandomGenerator generator = RandomGenerator.getInstance();
    public void run() {
        drawBoard();
        fillRandom();
    }

    private void drawBoard() {
        for (int i = 0; i <= CELLS; i++) {
            double y  = MARGIN + i * CELL_SIZE;
            GLine line = new GLine(MARGIN, y, LINE_LENGTH + MARGIN , y);
            add(line);
        }
        for (int i = 0; i <= CELLS; i++) {
            double x = MARGIN + i * CELL_SIZE;
            GLine line = new GLine(x, MARGIN, x, LINE_LENGTH + MARGIN);
            add(line);
        }
    }

    private void fillRandom() {
        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                int cellX = MARGIN + j * CELL_SIZE;
                int cellY = MARGIN + i * CELL_SIZE;
                boolean drawO = generator.nextBoolean();
                if (drawO) {
                    GOval oval = new GOval(cellX + FIGURE_SIZE, cellY + FIGURE_SIZE, FIGURE_SIZE, FIGURE_SIZE);
                    add(oval);
                } else {
                    double middleX = cellX + CELL_SIZE/2.0;
                    double middleY = cellY + CELL_SIZE/2.0;
                    GLine line1 = new GLine(middleX - FIGURE_SIZE/2.0, middleY - FIGURE_SIZE/2.0, middleX + FIGURE_SIZE/2.0, middleY + FIGURE_SIZE/2.0);
                    GLine line2 = new GLine(middleX - FIGURE_SIZE/2.0, middleY + FIGURE_SIZE/2.0, middleX + FIGURE_SIZE/2.0, middleY - FIGURE_SIZE/2.0);
                    add(line1);
                    add(line2);
                }
            }
        }
    }



    public static void main(String[] args) {
        new AcmTask().start(args);
    }
}
