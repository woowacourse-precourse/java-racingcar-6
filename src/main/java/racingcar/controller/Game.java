package racingcar.controller;

import java.util.List;
import racingcar.util.Validator;
import racingcar.dto.CarDto;
import racingcar.util.CarDtoConverter;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    Cars cars;
    OutputView outputView;
    InputView inputView;

    public Game() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    //start() 함수 구현
    public void start() {
        String carListString = inputView.inputCarNames();
        cars = new Cars(carListString);
        Validator.validateCars(cars);

        String roundNumberString = inputView.inputHowManyRound();
        int roundNumber = Validator.validateNumber(roundNumberString);
        Race race = new Race(cars, outputView);
        race.playGameAllRounds(roundNumber);

        List<CarDto> carDtoList = CarDtoConverter.convertCarsToCarDtoList(cars);
        outputView.printWinner(carDtoList);
    }






}


