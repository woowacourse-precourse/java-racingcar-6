package racingcar.engine;

import racingcar.common.Message;

public sealed interface RacingCarSystem {

    enum TextMessage implements Message {

        INPUT_THE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_THE_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?"),
        EXECUTION_RESULT_PREFIX("실행 결과"),
        OUTPUT_THE_WINNER_PREFIX("최종 우승자 : ");

        private final String message;

        TextMessage(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    Input<Integer> CAR_NAME_MINIMUM_LENGTH = new Input<>(1);
    Input<Integer> CAR_NAME_MAXIMUM_LENGTH = new Input<>(5);
    Input<Integer> ATTEMPTS_MINIMUM_VALUE = new Input<>(1);
    Input<Integer> ATTEMPTS_MAXIMUM_VALUE = new Input<>(100_000_000);
    Input<String> CAR_NAME_SEPARATOR = new Input<>(",");

    record Input<T>(T value) implements RacingCarSystem {
    }

    Policy<Integer> DRIVE_THRESHOLD = new Policy<>(4);
    Policy<Integer> RANDOM_NUMBER_MINIMUM_VALUE = new Policy<>(0);
    Policy<Integer> RANDOM_NUMBER_MAXIMUM_VALUE = new Policy<>(9);
    Policy<String> RACING_RESULT_FORMAT = new Policy<>("%s : %s");
    Policy<String> RACING_RESULT_PROGRESS_BAR = new Policy<>("-");

    record Policy<T>(T value) implements RacingCarSystem {
    }
}

