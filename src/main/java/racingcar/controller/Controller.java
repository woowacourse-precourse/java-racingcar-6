package racingcar.controller;

import static racingcar.utils.Converter.convertStringToInt;
import static racingcar.utils.Converter.convertStringToList;
import static racingcar.utils.validator.GetNameValidator.validateArrayListNames;
import static racingcar.utils.validator.GetNameValidator.validateStringNames;
import static racingcar.utils.validator.GetTrialNumberValidator.validateNumberRange;
import static racingcar.view.InputView.inputCarsName;
import static racingcar.view.InputView.inputTrialNumber;
import static racingcar.view.OutView.printResult;
import static racingcar.view.OutView.printResultWinner;

import java.util.ArrayList;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.service.Service;

public class Controller {

    private static final Controller instance = new Controller();

    private final Service service;

    private Controller() {
        this.service = Service.getInstance();
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
                .forEach((carName) -> cars.add(new CarDto(carName)));

        CarsDto carsDto = new CarsDto(cars);
        service.saveCars(carsDto);
    }

    public void startGame() {
        int inputTrialNumber = getTrialNumber();
        ArrayList<CarsDto> resultList = run(inputTrialNumber);
        printEachTrackResult(resultList);
    }

    private int getTrialNumber() {
        String inputString = inputTrialNumber();
        int trialNumber = convertStringToInt(inputString);
        validateNumberRange(trialNumber);
        return trialNumber;
    }

    private ArrayList<CarsDto> run(int trialNumber) {
        ArrayList<CarsDto> resultEachTrackList = service.runTrack(trialNumber);
        return resultEachTrackList;

    }

    private void printEachTrackResult(ArrayList<CarsDto> resultList) {
        printResult(resultList);
    }

    public void printFinalResult() {
        printResultWinner(service.getWinner());
        service.initRepository();
    }

}
