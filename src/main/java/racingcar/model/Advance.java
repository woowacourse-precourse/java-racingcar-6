package racingcar.model;

public class Advance {
    private int value;

    public Advance(){
        this.value = 0;
    }

    public void addAdvance(){
        value++;
    }

    public int getValue(){
        return value;
    }
}
