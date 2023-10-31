package model;

public class Name {
    final static int MAX_INPUT_LENGTH = 5;
    final static String INPUT_IS_EMPTY = "입력은 공백일 수 없습니다.";
    final static String INPUT_HAS_SPACE = "입력은 공백이 포함될 수 없습니다.";
    final static String INPUT_OVER_LENGTH = "입력은 5자 이하여야 합니다.";
    String name = "";

    public Name(String input) {
        hasSpace(input);
        isEmpty(input);
        isOverLength(input);
        name = input;
    }

    public String getName() {
        return name;
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
