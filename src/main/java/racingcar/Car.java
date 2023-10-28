package racingcar;

public class Car {
    private String name;
    private int movingCount = 0;

    public void increaseMovingCount() {
        this.movingCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMovingCount() {
        return this.movingCount;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "null";
        }
        return this.name;
    }
}