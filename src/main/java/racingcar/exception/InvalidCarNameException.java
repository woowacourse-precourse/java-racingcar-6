package racingcar.exception;

import java.util.List;
import racingcar.domain.Car;

/**
 * <p>자동차 이름이 올바르지 않을 경우 발생하는 예외 클래스입니다.</p>
 */
public class InvalidCarNameException extends IllegalArgumentException {


    private static final int MAX_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEED_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String DUPLICATE_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    /**
     * <p>기본 생성자로 예외 객체를 생성합니다.</p>
     */
    public InvalidCarNameException() {
        super();
    }


    /**
     * <p>지정된 메시지를 사용하여 예외 객체를 생성합니다.</p>
     *
     * @param message 예외 메시지
     */
    public InvalidCarNameException(String message) {
        super(message);
    }

    /**
     * <p>제공된 자동차 목록의 이름이 올바른지 검증합니다.</p>
     *
     * <p>이름의 길이와 중복 여부를 확인합니다.</p>
     *
     * @param cars 검증할 자동차 목록
     * @throws InvalidCarNameException 이름의 길이나 중복 여부에 문제가 있을 경우 발생
     */
    public static void validate(List<Car> cars) {
        List<String> names = cars.stream().map(Car::getName).toList();
        validateNameLength(names);
        validateUniqueNames(names);
    }

    /**
     * <p>제공된 자동차 목록의 이름 길이가 올바른지 검증합니다.</p>
     *
     * @param names 검증할 자동차 목록
     * @throws InvalidCarNameException 이름의 길이가 5자를 초과할 경우 발생
     */
    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.trim().length() > MAX_NAME_LENGTH) {
                throw new InvalidCarNameException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }

    /**
     * <p>제공된 자동차 목록의 이름이 중복되지 않았는지 검증합니다.</p>
     *
     * @param names 검증할 자동차 목록
     * @throws InvalidCarNameException 이름에 중복이 있을 경우 발생
     */
    private static void validateUniqueNames(List<String> names) {
        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new InvalidCarNameException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
