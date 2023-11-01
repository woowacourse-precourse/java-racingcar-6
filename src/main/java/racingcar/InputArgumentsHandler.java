package racingcar;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.CommandLine.inputln;

public class InputArgumentsHandler {

    /**
     * car 목록 초기화
     */
    public List<Car> inputCars() {
        String input = inputln("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return mapToCarList(input);
    }

    /**
     * 시도 횟수 초기화
     */
    public int inputRoundNumbers() {
        String attempt = inputln("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(attempt);
    }

    private List<Car> mapToCarList(String input) {
        return Arrays
                .stream(input.split(","))
                .map(carName -> new Car(carName.trim(), 0))
                .collect(toList());
    }
}
