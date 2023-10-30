package racingcar.model;

import racingcar.exception.ErrorMessage;

public class Car {
    private final String name;
    private int step;
    private final NumberGenerator generator = new RandomNumberGenerator();
    private static final int FORWARD_LOWER_INCLUSIVE = 4;
    private static final int MAX_NAME_LENGTH = 5;




    public Car(String name){
        validateLength(name);
        this.name = name;
        this.step = 0;
    }

    private void validateLength(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void moveOneStep(){
        if(generator.generate() >= FORWARD_LOWER_INCLUSIVE){
            step++;
        }
    }

    public String getName(){
        return name;
    }

    public int getStep(){
        return step;
    }

}
