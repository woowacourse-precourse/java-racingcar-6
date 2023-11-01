package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class WinnerDTO {
    private final List<String> winners;

    public WinnerDTO(List<String> winners) {
        this.winners = winners;
    }

    public static WinnerDTO from(List<CarDTO> carsDTO) {
        List<String> carNames = new ArrayList<>();
        for (CarDTO carDTO : carsDTO) {
            carNames.add(carDTO.getName());
        }
        return new WinnerDTO(carNames);
    }

    @Override
    public String toString() {
        return String.join(",", winners);
    }
}
