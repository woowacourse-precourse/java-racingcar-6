package racingcar;

public class Car {

    private String name;
    private int move;

    public Car(String name) {
        name = name.trim();
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("글자수 문제 발생! 5글자가 넘거나 비어있습니다.");
        }
        this.name = name;
        this.move = 0;
    }

    public String getName() {
        return this.name;
    }
    public int getMove() {
        return this.move;
    }
    public void plusMove() {
        this.move++;
    }

}