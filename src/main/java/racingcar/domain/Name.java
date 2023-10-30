package racingcar.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name){
        if(name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 5자를 초과할 수 없습니다.");
        }
    }
}