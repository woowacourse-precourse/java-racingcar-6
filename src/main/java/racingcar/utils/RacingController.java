package racingcar.utils;

import racingcar.controller.RandomNumberGenerater;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final Cars cars;
    private final Race race;
    private final RandomNumberGenerater randomNumberGenerater;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(Cars cars, Race race, RandomNumberGenerater randomNumberGenerater, InputView inputView, OutputView outputView) {
        this.cars = cars;
        this.race = race;
        this.randomNumberGenerater = randomNumberGenerater;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Car> carList = getCars();
        race.setTimes(getTimes());

        while (race.run(carList)) {
            printProcess(carList);
        }

        List<Car> winnerList = race.getWinner(carList);
        String winnersString = race.getWinnersString(winnerList);

        outputView.printWinner(winnersString);
    }

    public void printProcess(List<Car> carList) {
        StringBuilder process = new StringBuilder();
        carList.forEach(car -> process.append(String.format("%s : %s\n", car.getCarName(), "-".repeat(car.getProcess()))));
        outputView.printProcess(process.toString());
    }

    public List<Car> getCars() {
        outputView.printInputCars();
        String carsString = inputView.inputCars();
        cars.generateCars(carsString);
        return cars.getCars();
    }

    public int getTimes() {
        outputView.printInputTimes();
        String timesString = inputView.inputTimes();
        return Integer.parseInt(timesString);
    }
}
