package racingcar.model;

import racingcar.RandomNumberGenerator;

public class Car {
    private String name;
    private int forwardCount;
    private final RandomNumberGenerator generator = new RandomNumberGenerator();
    private static final int FORWARD_LOWER_INCLUSIVE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "이름은 5자 이하여야 합니다.";



    public Car(String name){
        validateLength(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validateLength(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void forward(){
        if(generator.generate() > FORWARD_LOWER_INCLUSIVE){
            forwardCount++;
        }
    }

    public String getName(){
        return name;
    }

    public int getStep(){
        return forwardCount;
    }

}
