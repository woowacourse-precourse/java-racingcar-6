package racingcar.controller;

import static racingcar.utils.Converter.convertStringToInt;
import static racingcar.utils.Converter.convertStringToList;
import static racingcar.utils.validator.GetNameValidator.validateArrayListNames;
import static racingcar.utils.validator.GetNameValidator.validateStringNames;
import static racingcar.utils.validator.GetTrialNumberValidator.validateNumberRange;
import static racingcar.view.InputView.inputCarsName;
import static racingcar.view.InputView.inputTrialNumber;

import java.util.ArrayList;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.service.Service;
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
        String inputString = inputCarsName();
        validateStringNames(inputString);

        ArrayList<String> carsNameList = convertStringToList(inputString);
        validateArrayListNames(carsNameList);

        saveCars(carsNameList);
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
