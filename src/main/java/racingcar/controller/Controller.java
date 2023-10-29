package racingcar.controller;

import static racingcar.utils.Converter.*;
import static racingcar.utils.validator.GetTrialNumberValidator.*;
import static racingcar.view.InputView.*;

import java.util.ArrayList;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.service.Service;
import racingcar.utils.validator.GetNameValidator;
import racingcar.view.OutView;

public class Controller {

    private static final Controller instance = new Controller();

    private final Service service;
    private Controller() {
        this.service = new Service();
    }

    public static Controller getInstance() {
        return instance;
    }

    public void settingGame() {
        saveCars(getCarsName());
    }


    private static ArrayList<String> getCarsName() {
        String inputString = inputCarsName();
        ArrayList<String> carNameArrayList = GetNameValidator.validateCarsName(inputString);
        return carNameArrayList;
    }


    private void saveCars(ArrayList<String> carsName) {
        ArrayList<CarDto> cars = new ArrayList<>();

        carsName.stream()
                        .forEach((car)->cars.add(new CarDto(car)));

        CarsDto carsDto = new CarsDto(cars);
        service.saveCars(carsDto);
    }

    public void startGame() {
        int trialNumber = getTrialNumber();
        while (trialNumber-- > 0) {
            runTrack();
            printEachTrackResult();
        }
    }

    private void runTrack() {
        service.runOnce();
    }

    private void printEachTrackResult() {
        CarsDto carsDto = service.getResultOfOneTrack();
        OutView.printResultEachTrack(carsDto);
    }


    private int getTrialNumber() {
        String inputString = inputTrialNumber();
        int trialNumber = convertStringToInt(inputString);
        validateNumberRange(trialNumber);
        return trialNumber;
    }

    public void printFinalResult() {
      OutView.printResultWinner(service.getWinner());
    }
}
