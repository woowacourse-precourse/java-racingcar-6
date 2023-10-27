package racingcar.model;

public class Advance {
    private int value;

    public Advance(){
        this.value = 0;
    }

    public void add(){
        value++;
    }

    public int getValue(){
        return value;
    }
}
