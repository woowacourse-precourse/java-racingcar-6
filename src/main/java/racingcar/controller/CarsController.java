package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    Cars cars;
    OutputView outputView;
    InputView inputView;

    public CarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    //start() 함수 구현
    public void start() {
        String carListString = inputView.inputCarNames();
        cars = new Cars(carListString);

        int roundNumber = inputView.inputHowManyRound();

        System.out.println("실행 결과");
        playGameAllRounds(roundNumber);

        List<CarDto> carDtoList = convertCarsToCarDtoList();
        outputView.printWinner(carDtoList);
    }

    private void playGameAllRounds(int roundNumber) {
        for (int i=0; i<roundNumber; i++) {
            playGameSingleRound();
        }
    }

    private void playGameSingleRound() {
        carsMoving();
        List<CarDto> carDtoList = convertCarsToCarDtoList();
        outputView.printSingleRound(carDtoList);
    }

    private List<CarDto> convertCarsToCarDtoList() {
        List<CarDto> carDtoList = new ArrayList<>();

        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            String carName = car.getCarName();
            int movedDistance = car.getMovedDistance();
            carDtoList.add(new CarDto(carName, movedDistance));
        }

        return carDtoList;
    }

    private void carsMoving() {
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            car.move();
        }
    }

}


