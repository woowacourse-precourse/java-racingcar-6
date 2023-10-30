package racingcar.view;

public class Console {

    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String readCarNames() {
        output.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String value = input.read();
        validateNull(value);

        return value;
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

}
