package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public void addOneMovingCount() {
        movingCount++;
    }

    public void printResult() {
        String movingWay = getMovingWay();
        System.out.println(name + " : " + movingWay);
    }

    private String getMovingWay() {
        String movingWay = "";
        for (int i = 0; i < movingCount; i++) {
            movingWay += "-";
        }
        return movingWay;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(movingCount, car.movingCount);
    }
}
