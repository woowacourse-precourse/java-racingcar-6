package racingcar.domain;

import java.util.List;

public class Judgement {
    public boolean isFourOrMore(int number) {
        return number >= 4;
    }

    public void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자입니다!");
            }
        }
    }

}
