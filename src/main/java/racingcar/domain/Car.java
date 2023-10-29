package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    private Driver driver;

    public Car(String name, Driver driver){
        if(name.length()>5){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void drive(){
        int driverStatusNumber = driver.getNumber();
        if(driverStatusNumber >= 4){
            this.position += 1;
        }
    }
}
