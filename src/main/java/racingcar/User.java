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

        String numberOfTimes = Console.readLine();

        validateNumberOfTimesIsNumeric(numberOfTimes);

        return Integer.parseInt(numberOfTimes);
    }


    private void validateCarNameLength(List<String> carNames) {

        for (int i = 0; i < carNames.size(); i++) {

            if (carNames.get(i).length() > 5) {

                throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 가능합니다.");

            }
        }
    }

    private void validateNumberOfTimesIsNumeric(String numberOfTimes) {

        if (!numberOfTimes.chars().allMatch(Character::isDigit)) {

            throw new IllegalArgumentException("사용할 횟수는 숫자로만 가능합니다.");

        }
    }
}
