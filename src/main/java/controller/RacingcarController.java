package controller;

import controller.dto.CarDto;
import domain.Car;
import domain.CarService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService = new CarService();

    private int remainingRounds;

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.inputCarName();
        carService.add(inputView.carName());
        outputView.inputRoundNumber();
        remainingRounds = inputView.roundNumber();
        outputView.outputRunResult();
    }

    public void playRound() {
        carService.playRound();
        outputView.outputCarPosition(carsToDto(carService.getState()));
        remainingRounds--;
    }

    public boolean isEnd() {
        return remainingRounds <= 0;
    }

    public void endGame() {

    }

    // 제거 필요
    private List<CarDto> carsToDto(List<Car> cars) {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : cars) {
            carDtoList.add(new CarDto(car.getName(), car.getPosition()));
        }
        return carDtoList;
    }
}
