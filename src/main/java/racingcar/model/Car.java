package racingcar.model;

import racingcar.model.constant.CarConstant;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = CarConstant.INITIAL_POSITION.getNumber();
    }

    public void moveOrStop(int moveCommand) {
        if (isCarMoveable(moveCommand)) {
            this.position++;
        }
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private static boolean isCarMoveable(int moveCommand){
        return moveCommand >= CarConstant.CAR_MOVEABLE_VALUE.getNumber();
    }
}
