package racingcar.domain;

public class LicensePlate {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public LicensePlate(String name) {
        verifyNameLength(name);
        this.name = name;
    }

    private static void verifyNameLength(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("최대 이름 길이는 " + MAX_NAME_LENGTH + "입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
