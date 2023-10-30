package racingcar.business;

import racingcar.ui.InputView;
import racingcar.ui.Output;
import racingcar.ui.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Racing {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberMaker numberMaker = new NumberMaker();

    List<Car> carList;

    public void doRacing() {
        outputView.print(Output.GET_NAMES);
        List<String> names = inputView.getNames();

        outputView.print(Output.GET_GAME_COUNT);
        Integer gameCount = inputView.getGameCount();

        System.out.println("gameCount = " + gameCount);
        System.out.println("names = " + names);

        carList = getCars(names);

        for (int i = 0; i < gameCount; i++) {
            runRound();
        }

        String winnerNames = getWinnerNames();
        outputView.printWinnerNames(winnerNames);
    }

    private String getWinnerNames() {
        Optional<Car> maxDistanceCar = carList.stream().max(Comparator.comparingInt(Car::getDistance));
        Integer maxDistance = maxDistanceCar.get().getDistance();

        return carList.stream().filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getCars(List<String> names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }

    private void runRound() {
        for (Car car : carList) {
            tryMoving(car);
        }

        outputView.print(Output.BLANK_LINE);
    }

    private void tryMoving(Car car) {
        int randomNumber = numberMaker.getRandomNumber();
        car.moveCar(randomNumber);
        outputView.printMoveResult(car);
    }

}
