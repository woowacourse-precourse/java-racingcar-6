package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Validator;

public class GameController {
    private final Validator validator = Validator.getInstance();
    private Cars cars;
    private int rounds;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();

        initCars(namesInput);

        System.out.println("시도할 회수는 몇회인가요?");
        String roundInput = Console.readLine();
        System.out.println();

        setRounds(roundInput);
        runRounds(rounds);

        printWinner();
    }

    private void initCars(String input) {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = validator.checkValidInputList(input);

        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        cars = new Cars(carList);
    }

    private void setRounds(String input) {
        rounds = validator.checkValidInputNumber(input);
    }

    private void runRounds(int rounds) {
        System.out.println("실행 결과");

        for (int i=1; i<=rounds; i++) {
            cars.moveCars();
            List<String> resultList = cars.getRoundResult();

            printRoundResult(resultList);
        }
    }

    private void printRoundResult(List<String> resultList) {
        for (String result: resultList) {
            System.out.println(result);
        }
            System.out.println();
    }

    private void printWinner() {
        List<String> winner = cars.getWinner();
        String result = String.join(", ", winner);

        System.out.println("최종 우승자 : " + result);
    }
}
