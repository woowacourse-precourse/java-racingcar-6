package racingcar.controller.dto;

import java.util.List;
import racingcar.domain.Car;

public class RoundResponseDto {
    List<Car> carList;
    public static final String DISTANCE_MARKER = "-";

    public RoundResponseDto(List<Car> carList) {
        this.carList = carList;
    }

    public String covertOutput() {
        StringBuilder st = new StringBuilder();
        for (Car car : carList) {
            String name = car.getName();
            int position = car.getPosition();
            String dashes = DISTANCE_MARKER.repeat(position);
            st.append(name).append(" : ").append(dashes).append("\n");
        }

        return st.toString();
    }
}
