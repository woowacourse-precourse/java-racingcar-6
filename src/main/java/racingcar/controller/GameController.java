package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.ConsoleView;

public class GameController {
    private ConsoleView view;

    public GameController() {
        view = new ConsoleView();
    }

    public void runGame() {
        CarList carList = new CarList();
        String[] carNames = carList.splitCarInput();

        TryInput tryInput = new TryInput();
        int tryCount = tryInput.getTryCount();
//        System.out.println();
        view.printMessage("");

        RacingCar[] cars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new RacingCar(carNames[i]);
        }

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
//        System.out.println("실행 결과");
        view.printMessage("실행 결과");
        RaceProgressPrinter raceProgressPrinter = new RaceProgressPrinter();
        WinnersAnnouncer winnersAnnouncer = new WinnersAnnouncer();

        for (int i = 0; i < tryCount; i++) {
            for (RacingCar car : cars) {
                int number = randomNumberGenerator.generateRandomNumber();
                car.move(number);
            }
            raceProgressPrinter.printRaceResult(cars);
//            System.out.println();
            view.printMessage("");
        }

        String winners = winnersAnnouncer.announceWinners(cars);
//        view.printMessage("최종 우승자 : " + winners);
        System.out.print("최종 우승자 : " + winners);
    }
}


