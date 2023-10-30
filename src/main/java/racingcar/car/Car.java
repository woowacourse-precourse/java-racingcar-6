package racingcar.car;

import racingcar.system.SystemConstant;

public class Car {

    private String carName;
    private int position;

    Car(){
        this.position = SystemConstant.WAIT_LINE_POSITION;
    }

    public void goForward(){
        position++;
    }
}
