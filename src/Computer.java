import minmax.cell.Cell;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Computer extends Player {





    @Override
    protected void getCordinates(char [] [] gameField) {
        MinMax minMax= new MinMax();
        Cell cell = new Cell();

        cell = minMax.calculateMove(gameField,'O');
        super.cordinateA=1;//cell.getCordinateA() -1 ;
        super.cordinateB=1;//cell.getCordinateB()-1 ;
    }

    @Override
    public void move(char[][] gameField) {


        this.getCordinates(gameField);
        super.placeSighn(gameField, 'O');
    }
}
