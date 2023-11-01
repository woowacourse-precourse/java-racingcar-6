package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.AttemptInput;
import racingcar.domain.Car;
import racingcar.domain.CarInput;
import racingcar.domain.CarMoveGenrator;
import racingcar.domain.InputValidator;
import racingcar.domain.ResultPrinter;
import racingcar.domain.WinnerAnnouncer;
import racingcar.domain.WinnerDeterminer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator inputValidator = new InputValidator();

        CarInput carInput = new CarInput();
        List<String> carNames = carInput.getCarNames();
        inputValidator.validateCarNames(carNames);

        List <Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        AttemptInput attemptInput = new AttemptInput();
        int numAttempts = attemptInput.getNumAttempts();
        inputValidator.validateNumAttempts(numAttempts);

        CarMoveGenrator moveGenrator = new CarMoveGenrator();

        for (int i = 0; i < numAttempts; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                int move = moveGenrator.generateRandomMove();
                if (move >= 4) {
                    cars.get(j).forward();
                }
                ResultPrinter resultPrinter = new ResultPrinter();
                resultPrinter.printResult(carNames.get(j), cars.get(j).getPosition());
            }
            System.out.println();
        }

        WinnerDeterminer winnerDeterminer = new WinnerDeterminer();
        List<String> winners = winnerDeterminer.determineWinners(cars);

        WinnerAnnouncer winnerAnnouncer = new WinnerAnnouncer();
        if (winners.size() == 1) {
            winnerAnnouncer.announceSoloWinner(winners.get(0));
        } else {
            winnerAnnouncer.announceJointWinners(winners);
        }
        
    }
}
