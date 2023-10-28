package controller;

import camp.nextstep.edu.missionutils.Console;

import domain.Car;
import repository.CarRepository;
import util.Parser;
import util.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private CarRepository carRepository = new CarRepository();

    public void run() {
        saveCarNames(parser.parseCarNames(getCarNamesInput()));
        //Start
    }

    private void saveCarNames(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private String getCarNamesInput() {
        InputView.requestCarNames();
        String input = Console.readLine();

        return checkAllValidation(input);
    }

    private String checkAllValidation(String input) {
        try {
            validator.checkCarNamesInput(input, parser.parseCarNames(input));
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getCarNamesInput();
        }
    }

}
