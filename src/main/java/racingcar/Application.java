package racingcar;

import racingcar.exception.TrialCountValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static class TrialCount {

        private final Integer number;

        public TrialCount(Integer number) {
            TrialCountValidator.validateTrialCount(number);
            this.number = number;
        }

        public Integer getNumber() {
            return number;
        }
    }
}
