package racingcar.model;

import racingcar.Util;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void validRacingCars(){
        if( Util.getRandomNum() >= 4){
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : "
                + "-".repeat(Math.max(0, position));
    }
}
