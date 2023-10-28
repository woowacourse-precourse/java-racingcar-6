package racingcar;

import static racingcar.Converter.*;
import static racingcar.GetTrialNumberValidator.*;
import static racingcar.InputView.*;

import java.util.ArrayList;
import javax.xml.validation.Validator;

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
    }

    private void printEachTrackResult() {
    }


    private int getTrialNumber() {
        return 0;
    }

    public void printFianlResult() {
        OutView.printWinner();
    }
}
