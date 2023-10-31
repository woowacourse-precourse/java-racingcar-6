package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static List<Car> inputCarNames(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .filter(name -> validateCarName(name))
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        return carList;
    }

    private static boolean validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        } else if (name.length() <= 0) {
            throw new IllegalArgumentException("자동차 이름을 1자 이상 적어주세요.");
        } else if (name.trim().length() == 0) {
            throw new IllegalArgumentException("공백만으로 구성된 이름은 안됩니다.");
        }
        return true;
    }

    public static int inputTryCount(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 input 형식입니다.");
        }
    }
}
