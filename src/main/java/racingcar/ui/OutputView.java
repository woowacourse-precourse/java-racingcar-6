package racingcar.ui;

public class OutputView {

    private final static String GET_NAMES= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String GET_GAME_COUNT = "시도할 횟수는 몇회인가요?";
    private final static String RESULT_COMMENT = "실행 결과";
    private final static String SEPARATOR = " : ";
    private final static String WINNER_COMMENT = "최종 우승자 : ";

    //TODO 이렇게 System.out.println을 추출해서 사용하는 것이 적절한 방식일까?
    public void printGetNames() {
        print(GET_NAMES);
    }

    public void print(String comment) {
        System.out.println(comment);
    }

}
