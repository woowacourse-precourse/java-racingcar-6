package racingcar.view.Output;

public class OutputView {
    private final String RACE_REULT= "실행 결과";

    // 결과 출력
    public void printResult() {
        System.out.println(RACE_REULT);
    }

    // 입력받은 자동차 List 출력
    public void printCars(String cars) {
        System.out.println(cars);
    }

}
