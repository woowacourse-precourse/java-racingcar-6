package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.CarGameService;
import racingcar.domain.Car;

import java.util.List;
import java.util.Set;

public class CarGameController {

    private final CarGameService carGameService;

    public CarGameController(CarGameService carGameService) {
        this.carGameService = carGameService;
    }

    public void startGame() {
        List<Car> cars = initCars();
        int tryCount = inputTryCount();

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            tryMoveAndPrint(cars);
        }

        List<Car> winners = carGameService.winners(cars);
        printWinners(winners);
    }

    private int inputTryCount() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        try {
            int tryCount = Integer.parseInt(userInput);

            assertValidTryCount(tryCount);

            return tryCount;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("시도할 회수는 양수여야 합니다.");
        }
    }

    private void assertValidTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> initCars() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputNames = Console.readLine();
        List<String> carNames = List.of(userInputNames.split(","));

        return carGameService.initCars(carNames);
    }

    private void tryMoveAndPrint(List<Car> cars) {
        for (Car car: cars) {
            carGameService.moveCar(car);
            System.out.println(car);
        }
        System.out.println();
    }

    private void printWinners(List<Car> winners) {
        StringBuilder result = new StringBuilder();

        for (Car car : winners) {
            result.append(car.getName()+",");
        }
        result.deleteCharAt(result.length()-1);
        System.out.printf("최종 우승자 : %s%n",result);
    }
}
