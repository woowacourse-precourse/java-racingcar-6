package racingcar.model;

import static racingcar.config.Settings.CAR_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class RacingGame {
    private final CarManager manager;

    public RacingGame(CarManager manager) {
        this.manager = manager;
    }

    public String getWinners() {
        List<String> winners = new ArrayList<>();
        int farthest = manager.getFarthestPosition();

        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);
            CarDTO dto = car.toDTO();

            if (dto.getPosition() == farthest) {
                winners.add(dto.getName());
            }
        }

        return String.join(",", winners);
    }

    public String playRound() {
        StringBuilder roundResult = new StringBuilder();
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            car.tryMove();
            String status = getStatus(car);
            roundResult.append(status);
        }

        return roundResult.toString();
    }

    // dto로부터 이름과 위치를 받아 라운드 진행 상황 제작
    private String getStatus(Car car) {
        CarDTO dto = car.toDTO();

        String name = dto.getName();
        String position = "-".repeat(dto.getPosition());
        String status = String.format("%s : %s\n", name, position);

        return status;
    }

}
