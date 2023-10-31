package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private UserInputer userInputer = new UserInputer();
    private NumberGenerator numberGenerator = new NumberGenerator();
    private Splitter splitter = new Splitter();
    private Validator validator = new Validator();

    private RacingCar racingCar;

    public void start() {
        String userInput = userInputer.inputCarString();
        List<String> carNameList = splitter.stringToList(userInput);
        validator.validateCarNameLength(carNameList);
        List<Car> carList = splitter.makeCar(carNameList);
        racingCar = new RacingCar(carList);

        int trialCount = userInputer.inputTryCount();
        startRacing(trialCount);

        printWinners();
    }

    public void startRacing(int repeatCount) {
        System.out.println("실행 결과");
        raceAll(repeatCount);

    }

    public void raceAll(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            racingCar.moveRandomAllCar();
            racingCar.printLocationAllCar();
        }
    }


    public void printWinners() {
        List<Car> winnerList = racingCar.findWinner();

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
