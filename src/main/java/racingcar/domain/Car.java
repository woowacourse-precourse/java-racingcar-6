package racingcar.domain;

import racingcar.exception.Validator;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        Validator.empty(name);
        Validator.fiveOrLess(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(){
        this.distance++;
    }


    public boolean canMove(int number){
        return number >= 4;
    }

    public int getDistance() {
        return distance;
    }
}
