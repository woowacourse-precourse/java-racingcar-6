package racingcar;

public class Car {
    private String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public void moveAccordingToInput(int number) {
        if(number >= 4) {
            this.moving();
        }
    }

    private void moving() {
        this.movingCount++;
    }

    public int getMovingCount() {
        return this.movingCount;
    }

    public String getName() {
        return name;
    }
}
