package racingcar.model;

/**
 * 사용자의 이름을 검증하고, 저장하는 클래스
 */
public class Name {

    /**
     * 이름으로 가질 수 있는 최소한의 수
     */
    private final static int MIN_NAME_LENGTH = 1;
    /**
     * 이름으로 가질 수 있는 최대한의 수
     */
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;

    /**
     * 새로운 이름을 입력받는다.
     *
     * @param name 사용하려는 새로운 이름
     */
    public Name(String name) {
        validationName(name);
        this.name = name;
    }

    /**
     * 이름을 검증한다. 사용자가 정상적인 범위의 이름을 입력했는지 검증한다.
     *
     * @param name
     */
    private void validationName(String name) {
        // 이름이 0보다 커야 하고, 5보다 크면 안된다.
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 값이 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다.");
        }
    }

    public String getName() {
        return name;
    }
}
