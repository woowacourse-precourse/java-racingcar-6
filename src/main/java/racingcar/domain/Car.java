package racingcar.domain;

public class Car {
    private String name;
    private int aheadCount;

    public Car(String name){
        this.name = name;
        this.aheadCount = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getAheadCount(){
        return this.aheadCount;
    }

    public void updateAheadCount() {
        this.aheadCount += 1;
    }
}
