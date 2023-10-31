package racingcar;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 받기
        String userInput = InputView.requestUserInputNames();

        Cars cars = Cars.createCarList(userInput);

        // 횟수 입력받기
        String runningNumber = InputView.requestRunningCount();

        // 횟수(String 타입) 을 숫자로 변환
        Integer runningCount = Integer.parseInt(runningNumber);

        // 회차별 결과 출력
        OutputView.noticeRunningResult();

        cars.printCarsGameResult(runningCount);

        OutputView.noticeFinalWinner();
        OutputView.printWinnerNames(cars.findWinnerCars());
    }
}
