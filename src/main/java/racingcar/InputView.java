package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carName = Console.readLine().replace(" ", "").toLowerCase();

        List<String> carNames = new ArrayList<>(Arrays.asList(carName.split(",")));

        validateCarNameLength(carNames);
        validateDuplicateCarName(carNames);

        return carNames;
    }

    public int getNumberOfMoves() {

        System.out.println("시도할 회수는 몇회인가요?");

        String number = Console.readLine();

        validateNumberOfTimesIsNumeric(number);

        int numberOfTimes = Integer.parseInt(number);

        validateNumberOfTimesIsPositive(numberOfTimes);

        return numberOfTimes;
    }

    public void printRaceProgress(List<Car> cars) {

        for (Car car : cars) {

            System.out.println(car.getCarName() + " : " + car.getCarStateMessage());
        }

        System.out.println();
    }


    private void validateCarNameLength(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.length() > 5) {

                throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 가능합니다.");
            }
        }
    }

    private void validateDuplicateCarName(List<String> carNames) {

        long numberOfCars = carNames.stream().distinct().count();

        if (carNames.size() != numberOfCars) {

            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateNumberOfTimesIsNumeric(String number) {

        if (!number.chars().allMatch(Character::isDigit)) {

            throw new IllegalArgumentException("사용할 횟수는 숫자로만 가능합니다.");
        }
    }

    private void validateNumberOfTimesIsPositive(int numberOfTimes) {

        if (numberOfTimes <= 0) {

            throw new IllegalArgumentException("사용할 횟수는 1 이상으로만 가능합니다.");
        }
    }
}
