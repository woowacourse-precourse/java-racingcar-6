package racingcar.view;

/**
 * 자동차 결과 게임 결과를 출력하는 인터페이스입니다.
 */
public interface ResultView {
    static final String RESULT_MESSAGE = "실행 결과";

    public void displayRaceResults();

    public void displayWinners();
}
