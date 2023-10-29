package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.view.input.InputView;
import utils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static racingcar.contant.GameNotice.EXECUTE_RESULT;
import static racingcar.contant.GameNotice.NOTICE_WINNER_RESULT;
import static racingcar.view.output.OutputView.printGameNotice;

public class RacingCarGame {
    private List<RacingCar> racingCarList;
    private int roundNumber;

    private void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void start() {
        String carNames = InputView.inputCarName();
        Console.println(carNames);

        String roundNumber = InputView.inputRoundNumber();
        Console.println(roundNumber);

        this.roundNumber = parseInt(roundNumber);

        printGameNotice(EXECUTE_RESULT);

        // racingCarList
        String[] splitCarNames = carNames.split(",");
        this.racingCarList = new ArrayList<RacingCar>();

        for(String carName: splitCarNames) {
            RacingCar racingCar = new RacingCar(carName);
            this.racingCarList.add(racingCar);
        }

        while(this.roundNumber > 0) {
            for(RacingCar car: racingCarList) {
                car.moveCar();
            }

            for(RacingCar car: racingCarList) {
                String moved = "";
                for(int i = 0; i < car.getCarMoveCount(); i++) {
                    moved = moved.concat("-");
                }

                Console.println(car.name + " : " + moved);
            }

            this.roundNumber--;
        }
        printGameNotice(NOTICE_WINNER_RESULT);
        String winner;

        List<Integer> movedList = new ArrayList<Integer>();
        for(RacingCar car: racingCarList) {
            movedList.add(car.getCarMoveCount());
        }

        int maxCount = Collections.max(movedList);

        racingCarList.stream().filter(
                car -> car.getCarMoveCount() == maxCount
        );

        List<String> winnerList = new ArrayList<String>();


        racingCarList.forEach(car -> winnerList.add(car.name));


        Console.print(String.join(", ", winnerList));
    }
}
