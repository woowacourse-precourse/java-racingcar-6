package racingcar.fake;

import racingcar.util.RandomNumber;

public class FakeRandomNumberUtil implements RandomNumber {

        private final int number;
        public FakeRandomNumberUtil(int number) {
                this.number = number;
        }

        @Override
        public int pickRandomNumber() {
                return number;
        }
}
