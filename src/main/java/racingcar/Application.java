package racingcar;

class Car {
    private String name;
    private Integer move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void forward() {
        this.move += 1;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
