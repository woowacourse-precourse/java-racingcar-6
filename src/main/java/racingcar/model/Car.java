package racingcar.model;

public class Car {
    private final Name name;
    private Advance advance;

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
}
