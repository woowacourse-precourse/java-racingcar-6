package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final InputUtil inputUtil;
    private Cars cars;

    public RacingCarService() {
        inputUtil = new InputUtil();
    }

    public void start() {
        initCars();
        int count = initCount();
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            move(cars);
        }
        printWinner();
    }

    public void move(Cars cars) {
        cars.moveCars();
        cars.printMoves();
    }

    public void initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> input = inputUtil.getCarNames();
        cars = createCars(input);
    }

    public int initRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return inputUtil.getRound();
    }

    public Cars createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        names.forEach(name -> carList.add(new Car(name)));
        cars = new Cars(carList);
        return cars;
    }

    public void printWinner() {
        String s = cars.showWinner();
        System.out.print("최종 우승자 : ");
        System.out.print(s);
    }
}
