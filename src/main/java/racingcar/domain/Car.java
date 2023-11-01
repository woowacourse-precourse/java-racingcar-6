package racingcar.domain;

import racingcar.NumberGenerator;
import racingcar.firstClassCollection.CarName;

public class Car {
    private final static int START_NUMBER_RANGE = 0;
    private final static int END_NUMBER_RANGE = 9;
    private final static int FORWARD_BOUND_NUMBER = 4;
    CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = 0;
    }

    public void proceedOwnRound() {
        int number = NumberGenerator.generateRandomNumber(START_NUMBER_RANGE,END_NUMBER_RANGE);
        updatePosition(number);
    }

    public void updatePosition(int number) {
        if(number>FORWARD_BOUND_NUMBER){
            position++;
        }
    }

    public String getFormattedPostion(){
        StringBuilder positionString = new StringBuilder();
        positionString.append(carName.getName()+" : ");
        for(int i=0;i<position;i++){
            positionString.append("-");
        }
        return positionString.toString();
    }

    public int getPosition() {
        return position;
    }
    public String getCarName(){
        return carName.getName();
    }
}
