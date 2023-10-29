package racingcar.util;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class Validate {
    public static void carNameNumeric(String name) {
        if (name.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("자동차 이름에 숫자는 넣을 수 없습니다.");
        }
    }
    public static void lastCharIsComma(String name) {
        if(name.endsWith(",")) {
            throw new IllegalArgumentException("잘못된 입력 : \",\" 뒤는 자동차 이름이 들어가야합니다.");
        }
    }

    public static void carNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public static void carNameIsOne(List<String> list) {
        if(list.size() == 1) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야 합니다.");
        }
    }

    public static void inputStringNotContainsComma(String input) {
        if(input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름을 구분짓는 구분자는 쉼표(\",\")를 입력해야 합니다.");
        }
    }

    public static void inputIsNull(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값을 확인해주세요");
        }
    }

    public static int moveIsNumericAndReturnInteger(String move) {
        try {
            return Integer.parseInt(move);
        } catch(NumberFormatException exception) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    public static void carNamesDuplicate(List<Car> cars) {
        if(cars.size() != cars.stream().map(Car::getMember).distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 넣었습니다.");
        }
    }

    public static void moveIsPositiveNumber(int move) {
        if(move < 0) {
            throw new IllegalArgumentException("시도할 숫자는 0보다 커야합니다.");
        }
    }
}
