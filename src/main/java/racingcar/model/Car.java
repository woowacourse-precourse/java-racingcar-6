package racingcar.model;

import racingcar.utils.RuleConstant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void drive(int num){
        if(RuleConstant.CAN_DRIVE_CRITERIA>=num){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
