package racingcar.model;

public class Car {

    private static final int CAR_ADVANCE_NUMBER = 4;
    private final Name name;
    private final Advance advance;

    public Car(final Name name) {
        this.name = name;
        this.advance = new Advance();
    }

    public void addAdvances(final int randomNumber){
        if(randomNumber >= CAR_ADVANCE_NUMBER){
            advance.add();
        }
    }

    public String getCarName(){
        return name.getName();
    }

    public int getCarAdvances(){
        return advance.getValue();
    }
}
