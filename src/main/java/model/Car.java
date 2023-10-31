package model;

public class Car {
    final static int MAX_INPUT_LENGTH = 5;
    final static String INPUT_IS_EMPTY = "입력은 공백일 수 없습니다.";
    final static String INPUT_HAS_SPACE = "입력은 공백이 포함될 수 없습니다.";
    final static String INPUT_OVER_LENGTH = "입력은 5자 이하여야 합니다.";
    final static int FORWARDING_THRESHOLD = 4;
    final static String ONE_PLACE = "-";
    String name;
    String nowPlace = "";

    public Car(String name) {
        isOverLength(name);
        isEmpty(name);
        hasSpace(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.nowPlace = this.nowPlace + ONE_PLACE;
    }

    public String getNowPlace() {
        return nowPlace;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= FORWARDING_THRESHOLD) {
            moveForward();
        }
    }

    public void hasSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INPUT_HAS_SPACE);
        }
    }

    public void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }

    public void isOverLength(String input) {
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_OVER_LENGTH);
        }
    }


}
