package racingcar;


import org.junit.platform.commons.util.StringUtils;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    private void validateName(String name) {
        // 사용해도 되나?? static import
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
