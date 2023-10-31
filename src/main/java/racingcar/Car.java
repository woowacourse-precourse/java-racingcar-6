package racingcar;

public class Car {
    String name;
    int move;

    public Car(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public String getResult() {
        String dash = "-".repeat(move);

        String result = String.format("%s : %s%n", name, dash);

        return result;
    }
}
