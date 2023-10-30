package racingcar.car;

import racingcar.system.SystemConstant;

public class Car {

    private String carName;
    private int position;

    Car(String carName){
        this.carName = carName;
        this.position = SystemConstant.WAIT_LINE_POSITION;
    }

    public void goForward(){
        position++;
    }

    public boolean isNameEquals(CarNameDto carNameDto){
        return carName.equals(carNameDto.getCarName());
    }
}
