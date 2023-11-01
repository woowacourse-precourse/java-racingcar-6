package racingcar.gamefield;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.car.Car;
import racingcar.car.CarsStatusDto;

public class Racing {

    public CarsStatusDto getCarsStatus(List<Car> carList) {
        LinkedHashMap<Car, String> carsStatus = new LinkedHashMap<>();
        for (Car car : carList) {
            carsStatus.put(car, car.getPosition());
        }
        return new CarsStatusDto(carsStatus);
    }


    public List<String> getWinnerList(List<Car> carList) {
        CarsStatusDto currentCarsStatusDto = getCarsStatus(carList);
        Map<Car, String> currentCarsPositions = currentCarsStatusDto.getCurrentCarsPositions();
        List<String> winnerList = new ArrayList<>();
        int maxPosition = currentCarsStatusDto.getCarsMaxPositionLength();
        for (Car car : currentCarsPositions.keySet()) {
            if (currentCarsPositions.get(car).length() == maxPosition) {
                winnerList.add(car.toString());
            }
        }
        return winnerList;
    }
}
