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
        validateCarNames(carNames);
        return Arrays.stream(carNames)
                .map(name -> new Car(name.trim(), new RandomMovement()))
                .collect(Collectors.toList());
    }

    private void validateCarNames(String[] carNames) {
        validateDuplicateNames(carNames);
        validateCarNamesLength(carNames);
    }

    private void validateDuplicateNames(String[] carNames) {
        if (uniqueNameCount(carNames) != carNames.length) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
        }
    }

    private void validateCarNamesLength(String[] carNames) {
        if(carNames.length > CarFactory.MAX_CAR_SIZE) {
            throw new IllegalArgumentException("자동차는 최대 " + CarFactory.MAX_CAR_SIZE + "대 만들 수 있습니다.");
        }
    }

    private int uniqueNameCount(String[] carNames) {
        return (int)Arrays.stream(carNames)
                .map(String::trim)
                .distinct()
                .count();
    }

    private void printMakeCarMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String[] inputCarName() {
        return Console.readLine()
                .split(",");
    }
}
