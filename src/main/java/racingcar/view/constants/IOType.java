package racingcar.view.constants;

public enum IOType {
    REQUEST_CAR_NAMES_SENTENCE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ATTEMPTS_COUNT_SENTENCE("시도할 회수는 몇회인가요?"),
    SPLIT_DELIMITER(","),
    REMOVE_WHITE_SPACE_REGEX("\\s+");



    private final String sentence;

    IOType(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

}
