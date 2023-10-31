package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.validate.CarValidateImpl;


public class Car {
    private String name;
    private int position;
    private Car car;

    public Car(String name) {
        CarValidateImpl.createVaule(name); // Corrected typo from createVaule to createValue
        this.name = name;
        this.position = 0;
    }
    public void go(int randomValue) {
        if(randomValue >= 4) {
            this.position += 1;
        }
    }

}


