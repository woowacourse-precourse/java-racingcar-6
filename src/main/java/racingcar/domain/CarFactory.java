package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>자동차 목록 생성 및 변환을 위한 팩토리 클래스입니다.</p>
 */
public class CarFactory {

    /**
     * <p>쉼표로 구분된 자동차 이름 문자열을 받아 {@code Car} 객체의 목록을 반환합니다.</p>
     *
     * @param nameString 쉼표로 구분된 자동차 이름 문자열
     * @return {@code Car} 객체의 목록
     */
    public static List<Car> fromNameString(String nameString) {
        String[] names = nameString.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    /**
     * <p>{@code Car} 객체의 목록을 받아 자동차 이름 문자열로 변환하여 반환합니다.</p>
     * <p>자동차가 여러 대인 경우, 각 이름은 쉼표와 공백(", ")으로 구분됩니다.</p>
     *
     * @param cars {@code Car} 객체의 목록
     * @return 자동차 이름 문자열
     */
    public static String toNameString(List<Car> cars) {
        if (cars.size() == 1) {
            return cars.get(0).getName();
        }
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
