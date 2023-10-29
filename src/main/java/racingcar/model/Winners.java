package racingcar.model;

import static racingcar.config.Settings.CAR_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class Winners {
    private final CarManager manager;

    private final List<String> winners = new ArrayList<>();

    public Winners(CarManager manager) {
        this.manager = manager;
    }

    public String getWinners() {
        calculateWinners();

        String string = String.join(",", winners);
        return string;
    }

    
    // 이동 횟수가 가장 많은 자동차들을 winners 배열에 삽입
    private void calculateWinners() {
        for (int index = 0; index < CAR_AMOUNT; index++) {
            int farthest = manager.getFarthestPosition();

            Car car = manager.getCarFromIndex(index);
            CarDTO dto = car.toDTO();

            if (dto.getPosition() == farthest) {
                winners.add(dto.getName());
            }
        }
    }

}
