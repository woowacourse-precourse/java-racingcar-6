package racingcar.model;


import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;
import racingcar.dto.GameDTO;

public class Winners {
    private final List<String> winners = new ArrayList<>();
    private final CarManager manager;
    private final RacingGame game;

    public Winners(CarManager manager, RacingGame game) {
        this.manager = manager;
        this.game = game;
    }


    public String getWinners() {
        calculateWinners();

        String string = String.join(",", winners);
        return string;
    }


    // 이동 횟수가 가장 많은 자동차들을 winners 배열에 삽입
    private void calculateWinners() {
        GameDTO gameData = game.toDTO();
        int carAmount = gameData.getCarAmount();
        
        for (int index = 0; index < carAmount; index++) {
            int farthest = manager.getFarthestPosition();

            Car car = manager.getCarFromIndex(index);
            CarDTO carData = car.toDTO();

            if (carData.getPosition() == farthest) {
                winners.add(carData.getName());
            }
        }
    }

}
