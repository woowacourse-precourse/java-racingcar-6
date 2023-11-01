package racingcar.domain;

import static racingcar.service.CarService.checkCarMovement;

public class Car {
    private final String carName;
    private int position = 0;

    public Car(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public int getPosition(){
        return position;
    }

    public void carMovement(){
        if(checkCarMovement()){
            move();
        }
    }

    public void move(){
        this.position++;
    }
}
