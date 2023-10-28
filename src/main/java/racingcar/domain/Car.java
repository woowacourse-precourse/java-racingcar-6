package racingcar.domain;

public class Car {
    private final String name;
    private int raceDistance;
    private static final int START_MOVING_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    public void moveAdvance(int randomNumber) {
        if (isOkayToGoForward(randomNumber)) {
            this.raceDistance++;
            return;
        }
    }

    public boolean isOkayToGoForward(int randomNumber){
        return randomNumber >= START_MOVING_VALUE;
    }

    public int getRaceDistance(){
        return this.raceDistance;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name+" : "+"-".repeat(raceDistance);
    }
}
