package racingcar.model;

public class Car {
    private final String name;
    private int position;
    private final static int CAR_MOVEABLE_VALUE = 4;

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public void moveOrStop(int moveCommand){
        if (isCarMoveable(moveCommand)) {
            this.position += 1;
        }
    }

    public int getPosition(){
        return this.position;
    }
    private static boolean isCarMoveable(int moveCommand){
        return moveCommand >= CAR_MOVEABLE_VALUE;
    }
}
