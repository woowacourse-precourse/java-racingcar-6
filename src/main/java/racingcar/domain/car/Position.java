package racingcar.domain.car;

public class Position {
    private int position;

    public Position(int position){
        this.position = position;
    }

    public void moveForward(){
        position++;
    }

    public int getPosition() {
        return position;
    }
}
