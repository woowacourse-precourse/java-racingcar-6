package racingcar.controller;


import java.util.ArrayList;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.service.Service;
import racingcar.utils.Converter;
import racingcar.utils.validator.GetNameValidator;
import racingcar.utils.validator.GetTrialNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutView;

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
        GetNameValidator.validateStringNames(inputString);

        ArrayList<String> carsNameList = Converter.convertStringToList(inputString);
        GetNameValidator.validateArrayListNames(carsNameList);
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
        String inputString = InputView.getTrialNumber();
        int trialNumber = Converter.convertStringToInt(inputString);
        GetTrialNumberValidator.validateNumberRange(trialNumber);
        return trialNumber;
    }

    private ArrayList<CarsDto> racing(int trialNumber) {
        ArrayList<CarsDto> resultEachTryList = service.racingGivenTrialNumber(trialNumber);
        return resultEachTryList;
    }

    private void printEachTryResult(ArrayList<CarsDto> resultList) {
        OutView.printResult(resultList);
    }

    public void finish() {
        OutView.printWinner(service.getWinner());
        service.initRepository();
    }

}
