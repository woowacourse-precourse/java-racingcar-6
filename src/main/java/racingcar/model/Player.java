package racingcar.model;

public class Player {

    static final int MAX_NAME_SIZE = 5;
    private String name;

    public Player(String name) {
        valid(name);
        this.name = name;
    }

    private void valid(String name) {
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름은 + MAX_NAME_SIZE + 자 이하만  가능합니다.");
        }
    }
}
