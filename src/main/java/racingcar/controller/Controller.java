package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.Car;
import racingcar.service.Service;
import racingcar.view.CarListRequest;

public class Controller {

    private final static Integer NAME_LENGTH_LIMIT = 5;
    private final Parser parser;
    private final Service service;

    public Controller() {
        parser = new Parser();
        service = new Service();
    }

    public void registerCars(String line) {
        CarListRequest carListRequest = parser.parseCarListRequest(line);
        for (String carName : carListRequest.carNames()) {
            checkNameLength(carName);
        }
        service.registerCar(carListRequest);
    }

    private void checkNameLength(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public void playRace(String clientMessage) {
        Integer numberOfAttempts = parser.parseNumberOfAttempts(clientMessage);
        service.playRaceRoutine(numberOfAttempts);
    }

    public String getResult() {
        List<Car> result = service.getResult();
        return result.stream()
            .map(Car::getCarName)
            .collect(Collectors.joining(", "));
    }
}
