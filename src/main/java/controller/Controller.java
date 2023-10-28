package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import model.Car;
import validator.InputValidator;
import view.OutputView;

public class Controller {
    private final InputValidator inputValidator = new InputValidator();
    private int numOfAttempt;
    private final List<Car> groupOfCar = new ArrayList<Car>();
    public void run() { //프로그램의 시작
        createCar(parseCarName(getCarNameByInput()));
        startRace();
    }

    private void startRace() {
        setNumOfAttemptByInput();
        OutputView.printResultMessage();

    }

    private int getNumOfAttemptByInput() {
        return Integer.parseInt(readLine());
    }

    private int checkNumOfAttempt(String input){
        try{
            inputValidator.checkNumOfAttempt(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    private void createCar(String[] carName) {
        for(String name: carName) {
            groupOfCar.addCar(new Car(name));
        }
    }

    private String[] parseCarName(String input) {
        String carNames = getCarNameByInput();
        return carNames.split(",");
    }

    private String getCarNameByInput() {
        InputView.printUserInputCarNameMessage();
        String input = readLine();
        return checkCarName(input);
    }

    private String checkCarName(String input) {
        try {
            inputValidator.checkCarNameValidate(input);
            return input;
        } catch (IllegalArgumentException e){
            throw e;
        }
    }


}
