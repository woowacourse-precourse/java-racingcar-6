package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final String DELIMITER = ",";

    // 1. 경주할 자동차 이름 입력 받기
    // 2. 시도 횟수 입력 받기
    // 3. 입력받은 이름을 쉼표를 기준으로 나눠서 컬렉션에 넣기
    // 4. 컬렉션을 돌면서 Car 객체 생성해서 컬렉션에 넣기
    // 5. Car 객체가 들어있는 컬렉션으로 Cars 객체 생성하기
    // 6. << 실행 결과 >>
    // 7. loop(시도 횟수)
    //      NumberGenerator로 랜덤 숫자 입력받기
    //      Cars의 move 메서드로 전진하기.
    //      결과 출력
    // 8. Cars에서 winner 얻어오기
    // 9. winner 출력하기

    public void gameStart() {
        Cars cars = generateCars();
        int tryNumber = getTryNumber();

        outputView.printResultStart();
        for (int i = 0; i < tryNumber; i++) {
            List<Integer> numbers = numberGenerator.createRandomNumbers(cars.getNumberOfPeople());
            cars.move(numbers);
            outputView.printResult(cars);
        }

        Winner winner = cars.getWinner();
        outputView.printWinner(winner);
    }

    private Cars generateCars() {
        outputView.printInputCarsName();
        String stringNames = inputView.inputName();
        // 검증
        List<String> carsName = Arrays.stream(stringNames.split(DELIMITER)).toList();
        List<Car> cars = new ArrayList<>();
        for (String carName : carsName) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }

    private int getTryNumber() {
        outputView.printInputTryNumber();
        String tryNumber = inputView.inputTryNumber();
        // 검증
        return Integer.parseInt(tryNumber);
    }

}
