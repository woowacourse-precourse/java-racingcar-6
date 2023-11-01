package racingcar.model;

import racingcar.message.ErrorMessage;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        validateNameNull(name);
        validateNameLength(name);
        this.name = name;
    }

    public void move(int power){
        if(power >= 4){
            position += 1;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public static void validateNameNull(String name) {
        if (name.isBlank() || name.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.NAME_HAS_BLANK.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_5_LENGTH.getMessage());
        }
    }
}
