package racingcar.service;

public enum OutputSentence {

    INPUT_NAME_NOTICE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT_NOTICE("시도할 회수는 몇회인가요?"),
    RESULT_NOTICE("실행 결과"),
    GAME_WINNER_NOTICE("최종 우승자 : ");


    private String sentence;

    OutputSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
