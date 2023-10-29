package racingcar.controller.dto;

import java.util.List;
import racingcar.domain.Car;

public class GameResultDto {

    List<Car> carList;

    public GameResultDto(List<Car> carList) {
        this.carList = carList;
    }

    public String convertOutput(){
        StringBuilder sb = new StringBuilder();

        for (Car car : carList) {
            if (!sb.isEmpty()){
                sb.append(", ");
            }
            sb.append(car.getName());
        }
        return sb.toString();
    }
}
