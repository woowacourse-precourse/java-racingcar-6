package racingcar.controller;

import racingcar.domain.Announcer;
import racingcar.domain.Car;
import racingcar.domain.Random;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    private final static Random random = new Random();
    private final static Referee referee = new Referee();
    private final static Announcer announcer = new Announcer();
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public void start() {
        outputView.displayCarNameInputMessage();
        List<Car> carList = prepareCarList();

        outputView.displayTryCountInputMessage();
        int tryNumber = inputView.inputTry();

        outputView.displayResultGuideMessage();
        executeRaces(carList, tryNumber);

        announceWinner(carList);
    }

    private List<Car> prepareCarList() {
        List<Car> list = new LinkedList<>();
        for (String name : inputView.inputCarNames()) {
            list.add(new Car(name));
        }
        return list;
    }

    private void executeRaces(List<Car> list, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            executeSingleRace(list);
            outputView.displayNewLine();
        }
    }

    private void executeSingleRace(List<Car> carList) {
        for (Car car : carList) {
            moveOrStop(car);
        }
        String locationAnnouncement = announcer.generateLocationAnnouncement(carList);
        outputView.displayLocation(locationAnnouncement);
    }

    private void moveOrStop(Car car) {
        int number = random.createNumber();
        if (referee.isGreaterThanEqual(number)) {
            car.go();
        }
    }

    private void announceWinner(List<Car> carList) {
        List<String> winners = referee.judgeWinner(carList);
        String winnerAnnouncement = announcer.generateWinnerAnnouncement(winners);
        outputView.displayWinner(winnerAnnouncement);
    }
}
