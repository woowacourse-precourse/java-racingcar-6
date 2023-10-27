package racingcar.model;

public class Car {

    private static int CAR_ADVANCE_NUMBER = 4;
    private final Name name;
    private final Advance advance;

    public Car(final Name name) {
        this.name = name;
        this.advance = new Advance();
    }

    public void addAdvances(){
        advance.addAdvance();
    }

    public String getCarName(){
        return this.name.getName();
    }

    public int getCarAdvances(){
        return this.advance.getValue();
    }

    public boolean isValidateAdvance(final int randomNumber){
        return randomNumber >= CAR_ADVANCE_NUMBER;
    }
}
