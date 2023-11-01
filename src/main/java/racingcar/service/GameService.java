package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Movable;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.dto.CarsDTO;
import racingcar.domain.gameInfo.InputManager;

public class GameService {
    private static Cars cars;

    public static int racingStart(InputManager inputManager) {
        int round = inputProcessing(inputManager);
        return round;
    }

    public static CarsDTO transferCarsDTO(){
        CarsDTO carsDTO = new CarsDTO();
        carsDTO.toDTO(cars);
        return carsDTO;
    }

    private static int inputProcessing(InputManager inputManager) {
        List<Car> parsedCarList = inputManager.getParsedCarList();
        cars = new Cars(parsedCarList);
        return inputManager.getGameProcessCount();
    }

    public static void progressRound() {
        cars.oneRoundProgress(new Movable());
    }

    public static String chooseWinner() {
        List<Car> winnerList = cars.getWinners();
        return winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
