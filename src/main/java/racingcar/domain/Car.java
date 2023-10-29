package racingcar.domain;

import racingcar.utils.Constants;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(Constants.START_POSITION);
    }

    public int move(int random){
        if(random >= Constants.THRESHOLD_VALUE){
            position.addPosition();
        }
        return position.getPosition();
    }

}
