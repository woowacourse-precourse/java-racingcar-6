package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public List<String> getCarNamesFromUser() {

        String carName = Console.readLine().replace(" ", "").toLowerCase();

        List<String> carNames = new ArrayList<>(Arrays.asList(carName.split(",")));

        validateCarNameLength(carNames);

        return carNames;
    }

    public int getNumberOfMovesFromUser() {

        String number = Console.readLine();

        validateNumberOfTimesIsNumeric(number);

        int numberOfTimes = Integer.parseInt(number);

        validateNumberOfTimesIsPositive(numberOfTimes);

        return numberOfTimes;
    }


    private void validateCarNameLength(List<String> carNames) {

        for (String carName : carNames) {

            if (carName.length() > 5) {

                throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 가능합니다.");

            }
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
