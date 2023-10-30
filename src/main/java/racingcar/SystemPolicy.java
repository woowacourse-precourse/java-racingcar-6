package racingcar;

public sealed interface SystemPolicy {
    Input<Integer> CAR_NAME_MINIMUM_LENGTH = new Input<>(1);
    Input<Integer> CAR_NAME_MAXIMUM_LENGTH = new Input<>(5);
    Input<Integer> ATTEMPTS_MINIMUM_VALUE = new Input<>(1);
    Input<Integer> ATTEMPTS_MAXIMUM_VALUE = new Input<>(100_000_000);
    Input<String> CAR_NAME_SEPARATOR = new Input<>(",");

    final class Input<T> implements SystemPolicy {
        private T value;

        public Input(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }
}

