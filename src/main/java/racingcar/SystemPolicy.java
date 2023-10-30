package racingcar;

public sealed interface SystemPolicy {

    enum Input implements SystemPolicy {
        CAR_NAME_MINIMUM_LENGTH(1),
        CAR_NAME_MAXIMUM_LENGTH(5),
        ATTEMPTS_MINIMUM_VALUE(1),
        ATTEMPTS_MAXIMUM_VALUE(100_000_000);


        private final int value;

        Input(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}

