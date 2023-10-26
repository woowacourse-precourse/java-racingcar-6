package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.exception.CarNameIncorrectException;
import racingcar.exception.CarNameSizeLimitExceededException;

public class InputView {

    private InputView() {
    }

    public static List<Car> getCarNames() {
        String carnames = Console.readLine();
        // 최초 입력 값에 대해서 빈값 null 체크
        checkNullAndEmpty(carnames);
        return getCarnameList(carnames);
    }

    public static void checkNullAndEmpty(String str) {
        isNull(str);
        isEmpty(str);
    }

    private static void isNull(String str) {
        if (str == null) {
            throw new CarNameIncorrectException("null 이 입력 되었습니다.");
        }
    }

    private static void isEmpty(String str) {
        if (str.trim().isEmpty()) {
            throw new CarNameIncorrectException("빈값 이 입력 되었습니다.");
        }
    }

    public static List<Car> getCarnameList(String carnames) {
        String[] carnameArr = carnames.split(",");
        checkLengthCarName(carnameArr);

        return Arrays.stream(carnameArr)
                .map(o -> new Car(o))
                .collect(Collectors.toUnmodifiableList());
    }

    private static void checkLengthCarName(String[] carnameArr) {
        for (String name : carnameArr) {
            isEmpty(name);
            if (name.length() > 5) {
                throw new CarNameSizeLimitExceededException("이름의 크기가 5를 초과 하였습니다.");
            }
        }
    }
}
