package minmax.cell;

/**
 * Created by Vadim on 31.01.2016.
 */
public class Cell {
    private int cordinateA;
    private int getCordinateB;
    private char content;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public int getCordinateB() {
        return getCordinateB;
    }

    public void setCordinateB(int getCordinateB) {
        this.getCordinateB = getCordinateB;
    }

    public int getCordinateA() {
        return cordinateA;
    }

    public void setCordinateA(int cordinateA) {
        this.cordinateA = cordinateA;
    }



}