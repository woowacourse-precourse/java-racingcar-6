package racingcar.data;

public class Car {
    private String name;
    private int moveDistance;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveDistance = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move(boolean isPossibleMove) {
        if (isPossibleMove) {
            moveDistance++;
        }

        print();
    }

    private void print() {
        String moveString = "-".repeat(moveDistance);
        System.out.println(name + " : " + moveString);
    }
}
