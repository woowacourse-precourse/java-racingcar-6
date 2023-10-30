package model;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
        validateOverLength();
    }

    public String getName() {
        return name;
    }

    private void validateOverLength() {
        if (name.length() > 4) {
            throw new IllegalArgumentException("5글자 미만 이름만 입력 가능합니다.");
        }
    }
}
