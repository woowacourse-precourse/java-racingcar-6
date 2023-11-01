package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (shouldMove()) {
            this.position++;
        }
    }

    public static boolean shouldMove() {
        return GameUtil.generateRandomNumber() >= 4;
    }


    public String makeMoveResult() {
        StringBuilder result = new StringBuilder();

        result.append(this.name + " : ");
        for (int round = 0; round < this.position; round++) {
            result.append("-");
        }
        return result.toString();
    }
}
