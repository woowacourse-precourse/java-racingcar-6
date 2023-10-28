package racingcar.model;

public class Name {
    private static final int MAX_LENGTH = 5;
    
    private final String name;

    public Name(String name) {
        // 이름 검증도 필요
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
