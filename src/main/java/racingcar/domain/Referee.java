package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {

    public int inputRoundNumber(String inputRoundNumber) {
        return validateRoundNumber(inputRoundNumber);
    }

    private int validateRoundNumber(String inputRoundNumber) {
        try {
            int roundNumber = Integer.parseInt(inputRoundNumber);

            if (roundNumber < 1) {
                throw new IndexOutOfBoundsException();
            }

            return roundNumber;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요.");
        }
    }

    public List<String> inputCarNames(String inputCarNames) {
        return validateCarNames(inputCarNames);
    }

    private List<String> validateCarNames(String inputCarNames) {
        List<String> carNamesList = Arrays.stream(inputCarNames.split(",")).toList();

        List<String> validDuplicateList = new ArrayList<>();
        if (inputCarNames.isEmpty() || carNamesList.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 두 개 이상의 자동차를 입력하세요.");
        }

        for (String carName : carNamesList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름을 5자 이하로 입력하세요.");
            }

            // ",pobi,jun" "pobi,,jun" "pobi,woni,"
            if (carName.isEmpty() || inputCarNames.charAt(inputCarNames.length() - 1) == ',') {
                throw new IllegalArgumentException("[ERROR] 앞, 중간, 뒤에 공백없이 자동차를 입력하세요.");
            }

            if (validDuplicateList.contains(carName)) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
            }

            validDuplicateList.add(carName);
        }

        return validDuplicateList;
    }


}
