package racingcar.domain;

public class Position {
    private int position = 0;
    private static final int INIT_POSITION = 0;

    public Position(){
        this.position = 0;
    }
    private Position(int position){
        this.position = position;
    }

    public Position getIncreasedPosition(){
        return new Position(position++);
    }

    public Position getPausedPosition(){
        return new Position(position);
    }
}
