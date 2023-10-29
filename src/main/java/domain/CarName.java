package domain;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";
    private static final String LENGTH_ERROR_MESSAGE = "[Error] 1자 이상, 5자 이하의 이름을 입력해 주세요.";
    private static final String CONTAIN_ERROR_MESSAGE = "[Error] 포함될 수 없는 문자가 포함되어 있습니다.";

    private String name;

    public CarName(String name) {
        validateLength(name);
        validateContain(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContain(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(CONTAIN_ERROR_MESSAGE);
        }
    }
}
