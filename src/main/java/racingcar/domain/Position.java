package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;
    private static final int INIT_POSITION = 0;

    public Position(){
        this.position = INIT_POSITION;
    }
    public Position(int position){
        this.position = position;
    }

    public static Position getIncreasedPosition(int position){
        return new Position(position + 1);
    }

    public static Position getPausedPosition(int position){
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Position otherPosition = (Position) o;
        return this.position == otherPosition.position;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.position);
    }
}
