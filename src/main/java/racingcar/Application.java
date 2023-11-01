package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static final int CAR_NAME_MAX = 5;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> cars = Arrays.asList(carNames.split(","));

        for (String car: cars) {
            checkCarNameValid(car);
        }



    }

    /**
     * 자동차 이름의 유효성 검사(5자 이하만 가능함)
     * @param car 자동차 이름
     */
    public static void checkCarNameValid(String car) {
        if (car.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
