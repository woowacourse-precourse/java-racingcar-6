package racingcar;


public class RacingCarOutputView {

    public static final String RACING_EXECUTE_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(RACING_EXECUTE_MESSAGE);
    }

    // 횟수는 밖에서 조절, Cars(Car들이 들어있는 일급컬렉션)를 넘겨받아 매 회차 레이싱 결과를 출력.
    public void printEachRacingResult() {
    }
}
