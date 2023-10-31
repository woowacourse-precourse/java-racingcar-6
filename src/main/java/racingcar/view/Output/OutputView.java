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

    // 시도 횟수 입력 값 출력 --> String 으로 받아도 상관 없긴 함.
    public void printTrialNumber(int number) {
        System.out.println(number);
    }

}
