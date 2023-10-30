package controller;

import controller.dto.CarDto;
import domain.Car;
import domain.CarService;
import domain.RemainingRound;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService = new CarService();

    private RemainingRound remainingRound = new RemainingRound();

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.inputCarName();
        carService.add(inputView.carName());
        outputView.inputRoundNumber();
        remainingRound.set(inputView.roundNumber());
        outputView.outputRunResult();
    }

    public void playRound() {
        remainingRound.playRound();
        carService.playRound();
        outputView.outputCarPosition(carsToDto(carService.getState()));
    }

    public boolean isEnd() {
        return remainingRound.isEnd();
    }

    public void endGame() {
        outputView.outputFinalWinner(carsToDto(carService.decideWinner()));
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
