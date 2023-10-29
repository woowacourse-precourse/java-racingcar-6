package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.move.RandomMovement;

public class InputCarFactory implements CarFactory {

    @Override
    public List<Car> createCars() {
        printMakeCarMessage();
        return convertNamesToCars(inputCarName());
    }

    private List<Car> convertNamesToCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name.trim(), new RandomMovement()))
                .collect(Collectors.toList());
    }

    private void printMakeCarMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String[] inputCarName() {
        return Console.readLine()
                .split(",");
    }
}
