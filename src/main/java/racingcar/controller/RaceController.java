package racingcar.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.Input;
import racingcar.view.Printer;

public class RaceController {

    final private CarController carController = new CarController();
    final private Validator validator = new Validator();

    public void start() {
        // 자동차 이름
        List<String> names = Input.getCarNames();
        validator.validateCar(names);

        // 차 생성
        List<Car> cars = carController.createCars(names);

        // 회차 입력
        int count = validator.validateCount(Input.getCount());

        // 경기 시작
        System.out.println("실행 결과");
        round(count, cars);

        // 우승자 찾기
        Car winner = findWinner(cars);

        // 우승자 출력
        Printer.printWinner(winner, cars);
    }

    private void round(int count, List<Car> cars) {
        IntStream.range(0, count).forEach(i -> {
            cars.forEach(carController::race);
            Printer.printRace(cars);
        });
    }

    private Car findWinner(List<Car> cars){
        cars.sort(Collections.reverseOrder());
        return cars.get(0);
    }
}
