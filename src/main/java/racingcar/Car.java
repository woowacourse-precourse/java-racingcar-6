package racingcar;

public class Car {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
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
}
