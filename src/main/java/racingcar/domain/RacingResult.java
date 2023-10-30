package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDto;

public class RacingResult {
    private static final String JOIN_SEPARATOR = ", ";
    private List<CarStatusDto> carStatuses;


    public RacingResult(List<CarStatusDto> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public void update(List<CarStatusDto> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public String findWinner() {
        return carStatuses.stream()
                .filter(car -> car.position() == getMaxPosition())
                .map(CarStatusDto::name)
                .collect(Collectors.joining(JOIN_SEPARATOR));
    }

    public List<CarStatusDto> getCarStatuses() {
        return Collections.unmodifiableList(carStatuses);
    }

    public void createResult() {
        String result = "";
        for (CarStatusDto carStatus : carStatuses) {
            String movement = "-".repeat(carStatus.position());
            result += String.format("%s : %s\n", carStatus.name(), movement);
        }
        result += "\n";
        System.out.println(result);
    }

    private int getMaxPosition() {
        return carStatuses.stream()
                .mapToInt(CarStatusDto::position)
                .max()
                .getAsInt();
    }
}
