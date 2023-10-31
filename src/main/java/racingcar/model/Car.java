package racingcar.model;

import static racingcar.util.Util.getRandomNumber;
import static racingcar.util.validator.InputValidator.isStringLengthValid;
import static racingcar.util.validator.InputValidator.checkBlank;

public class Car {
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        isStringLengthValid(name);
        checkBlank(name);
        this.NAME = name;
    }
    public void move(){
        if(getRandomNumber() >= 4){
            position++;
        }
    }

    public int getPosition()
    {
        return position;
    }
}
