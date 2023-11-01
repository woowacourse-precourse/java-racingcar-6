package racingcar;

public enum Prompt {
    GET_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_TURNS("시도할 회수는 몇회인가요?"),
    START_GAME("실행 결과")
    ;
    private final String content;

    Prompt(String content) {
        this.content = content;
    }
    void print(){
        System.out.println(this.content);
    }
}
