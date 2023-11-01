package racingcar.game;

import java.util.Arrays;
import racingcar.domain.Create;
import racingcar.domain.InputView;
import racingcar.domain.Judgment;
import racingcar.domain.OutputView;

public class Game {

    public void run() {
        Create create = new Create();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Judgment judgment = new Judgment();

        OutputView.printMessage(outputView.introduceGameMessage());
        String names = inputView.scan();

        String[] namesList = judgment.checkCarsName(names);
        Car[] cars = new Car[namesList.length];

        createInstanceCars(namesList, cars);

        OutputView.printMessage(outputView.howManyGamesMessage());
        String userInputHowManyTimes = inputView.scan();

        int howManyMoves = judgment.howManyTimesGameStart(userInputHowManyTimes);
        carsMove(howManyMoves, cars, outputView);

        String finalMessage = outputView.finalVictoryCarsMessage() + judgment.finalCarCheck(cars);
        OutputView.printMessage(finalMessage);

    }


    public void outputMoveResults(Car cars) {
        OutputView.printMessage(cars.getName() + " : " + cars.getDistanceString());
    }

    public void createInstanceCars(String[] namesList, Car[] cars) {
        for (int i = 0; i < namesList.length; i++) {
            cars[i] = new Car(namesList[i]);
        }

    }

    public void carsMove(int howManyMoves, Car[] cars, OutputView outputview) {
        OutputView.printMessage("");
        OutputView.printMessage(outputview.roundResultMessage());
        for (int i = 0; i < howManyMoves; i++) {

            for (Car car : cars) {
                car.move();
                outputMoveResults(car);
            }
            OutputView.printMessage("");
        }

    }
}
