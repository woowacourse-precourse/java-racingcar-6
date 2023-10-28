package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import model.GroupOfCar;
import view.InputView;
import model.Car;
import validator.InputValidator;

public class Controller {
    private final InputValidator inputValidator = new InputValidator();
    private final GroupOfCar groupOfCar = new GroupOfCar();

    public void run(){ //프로그램의 시작
        setCarName(parseCarName(getCarNameByInput()));

    }

    private void setCarName(String[] carName) {
        for(String name: carName) {
            groupOfCar.addCar(new Car(name));
        }
    }

    private String[] parseCarName(String input){
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
