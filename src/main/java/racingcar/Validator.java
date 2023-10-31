package racingcar;

import java.util.List;

public class Validator {
    public void isEmpty(String carNames) {
        if (carNames.isEmpty() || carNames.isBlank()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    public void hasSpace(String carNames) {
        if (carNames.contains(" ")) {
            throw new IllegalArgumentException("띄어쓰기를 제외하고 입력해주세요.");
        }
    }

    public void isLengthZeroOrOverFive(List<String> carNames) {
        for (String str : carNames) {
            if (str.isEmpty() || str.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 1~5자 사이로 입력해주세요.");
            }
        }
    }

    public void hasSameCarName(List<String> carNames) {
        List<String> distinctList = carNames.stream().distinct().toList();

        if (distinctList.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public int toNumber(String inputNumber) {
        int tryNumber;

        try {
            tryNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        return tryNumber;
    }

    public void isNumberOneToThousand(int tryNumber) {
        if (tryNumber <= 0 || tryNumber > 1000) {
            throw new IllegalArgumentException("1~1000 사이의 숫자를 입력해주세요.");
        }
    }
}
