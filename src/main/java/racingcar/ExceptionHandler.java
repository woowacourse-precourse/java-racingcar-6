package racingcar;

import java.util.List;

import static racingcar.Input.carNames;

public class ExceptionHandler {
    public static void run_ExceptionHandler() {
        exceedFive(carNames);
        duplicatedName(carNames);
    }



    //이름 5자 초과
    private static void exceedFive(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    //이름 중복
    private static void duplicatedName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
