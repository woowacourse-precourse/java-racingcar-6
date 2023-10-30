package racingcar;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Car {
    private int moveForwardCount;
    private final String name;

    Car(String name) {
        this.name = name;
        this.moveForwardCount = 0;
    }

    void tryMove(int movePower) {
        if (movePower >= 4) {
            moveForwardCount++;
        }
    }

    @Override
    public String toString() {
        String moveForwardString = IntStream.range(0, moveForwardCount)
                .boxed()
                .map(operand -> "-")
                .collect(Collectors.joining());
        return String.format("%s : %s", name, moveForwardString);
    }

    int getMoveForwardCount() {
        return moveForwardCount;
    }

    String getName() {
        return name;
    }
}
