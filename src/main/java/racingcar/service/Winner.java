package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.dto.CarDTO;
import racingcar.model.dto.WinnerDTO;

public class Winner {

    public static WinnerDTO getWinners(Cars cars) {
        List<Car> winners = cars.getBiggestDistCars();
        List<CarDTO> winnerCarsDTO = convertToCarDTO(winners);
        return WinnerDTO.from(winnerCarsDTO);
    }

    private static List<CarDTO> convertToCarDTO(List<Car> carList) {
        List<CarDTO> carsDTO = new ArrayList<>();
        for (Car car : carList) {
            carsDTO.add(car.toCarDTO());
        }
        return carsDTO;
    }
}
