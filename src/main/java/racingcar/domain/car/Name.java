package racingcar.domain.car;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 0;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNameNull(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() <= MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상, 5자 이하여야 합니다.");
        }
    }

    private void checkNameNull(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

}
