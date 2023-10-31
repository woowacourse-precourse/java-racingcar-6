package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 받기
        String userInput = InputView.requestUserInputNames();

        // 이름 리스트 만들기 [name, name, name, ...]
        List<String> names = List.of(userInput.split(","));

        // 돌아가면서 Car 객체 생성하여 List<Car>로 변환
        List<Car> cars = names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        // 횟수 입력받기
        String runningNumber = InputView.requestRunningCount();

        // 횟수(String 타입) 을 숫자로 변환
        Integer runningCount = Integer.parseInt(runningNumber);

        // 회차별 결과 출력
        OutputView.noticeRunningResult();

        for (int i = 0; i < runningCount; i++) {
            cars.forEach(Car::moveByGeneratedNumber);
            cars.forEach(car ->
                    OutputView.printPerMoveResult(car.toString()));
            System.out.println();
        }

        OutputView.noticeFinalWinner();
    }
}
