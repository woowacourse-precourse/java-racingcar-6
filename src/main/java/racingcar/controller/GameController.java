package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GameService gameService = new GameService();

    public void run() {
        List<Car> carList = createCarList();
        int trialNum = createTrialNum();
        Game game = new Game(carList, trialNum);

        while (!finishedGame(trialNum, game.getTriedNum())) {
            gameService.play(game);
            printScore(game.getCars());
        }

        // 확인절차(추후 삭제 예정)
        System.out.println(carList.get(0).getName());
        System.out.println(carList.get(1).getName());
        System.out.println(carList.get(2).getName());
        System.out.println(trialNum);
    }

    private List<Car> createCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> carNames = gameService.parseCarName(carName);
        List<Car> cars = saveCars(carNames);
        return cars;
    }

    private int createTrialNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String countTrial = Console.readLine();
        int trialNum = saveTrialNum(countTrial);
        return trialNum;
    }

    private List<Car> saveCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private int saveTrialNum(String input) {
        int trialNum = Integer.parseInt(input);
        return trialNum;
    }

    private boolean finishedGame(int trialNum, int triedNum) {
        if (trialNum == triedNum) {
            return true;
        }
        return false;
    }

    private void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    private void printScoreOfCars(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
