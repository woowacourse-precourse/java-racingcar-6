package racingcar.controller;

import static racingcar.utils.Converter.convertStringToInt;
import static racingcar.utils.Converter.convertStringToList;
import static racingcar.utils.validator.GetNameValidator.validateArrayListNames;
import static racingcar.utils.validator.GetNameValidator.validateStringNames;
import static racingcar.utils.validator.GetTrialNumberValidator.validateNumberRange;
import static racingcar.view.InputView.inputTrialNumber;
import static racingcar.view.OutView.printResult;
import static racingcar.view.OutView.printWinner;

import java.util.ArrayList;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.service.Service;
import racingcar.view.InputView;

public class Controller {

    Service service;

    public Controller() {
        this.service = new Service();
    }

    public void setting() {
        ArrayList<String> carsNameList = getCarsNameList();
        saveCars(carsNameList);
    }

    private static ArrayList<String> getCarsNameList() {
        String inputString = InputView.getCarsName();
        validateStringNames(inputString);

        ArrayList<String> carsNameList = convertStringToList(inputString);
        validateArrayListNames(carsNameList);
        return carsNameList;
    }

    private void saveCars(ArrayList<String> carsName) {
        ArrayList<CarDto> cars = new ArrayList<>();

        carsName.stream()
                .forEach((carName) -> cars.add(new CarDto(carName)));

        CarsDto carsDto = new CarsDto(cars);
        service.saveCarsToRepository(carsDto);
    }

    public void play() {
        int inputTrialNumber = getTrialNumber();
        ArrayList<CarsDto> resultList = racing(inputTrialNumber);
        printEachTryResult(resultList);
    }

    private int getTrialNumber() {
        String inputString = inputTrialNumber();
        int trialNumber = convertStringToInt(inputString);
        validateNumberRange(trialNumber);
        return trialNumber;
    }

    private ArrayList<CarsDto> racing(int trialNumber) {
        ArrayList<CarsDto> resultEachTryList = service.racingGivenTrialNumber(trialNumber);
        return resultEachTryList;
    }

    private void printEachTryResult(ArrayList<CarsDto> resultList) {
        printResult(resultList);
    }

    public void finish() {
        printWinner(service.getWinner());
        service.initRepository();
    }

}
