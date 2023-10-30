package racingcar.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        validateGapName(name);
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

    private void validateGapName(String name){
        boolean anyCharMatchGap = name.chars()
                .anyMatch(ch -> ch == ' ');

        if(anyCharMatchGap){
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }
}