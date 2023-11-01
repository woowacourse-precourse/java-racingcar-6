package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    RacingCarGame racingCarGame = new RacingCarGame();

    @Test
    @DisplayName("자동차 생성 테스트")
    void 자동차_생성_테스트() {
        List<String> players = Arrays.asList("pobi", "jun", "wooni");
        String name = String.join(",", players);

        racingCarGame.createCar(name);

        List<Car> car = racingCarGame.getCarList();

        assertThat(car.size()).isEqualTo(players.size());

        for (int i = 0; i < players.size(); i++) {
            Car oneCar = car.get(i);
            String onePlayer = players.get(i);
            assertThat(oneCar.getCarName()).isEqualTo(onePlayer);
        }
    }

    @Test
    @DisplayName("이동 횟수 저장 테스트")
    void 이동_횟수_저장_테스트() {
        int movingCount = 5;
        racingCarGame.saveMovingCount(movingCount);
        assertThat(racingCarGame.getMovingCount()).isEqualTo(movingCount);
    }

    @Test
    @DisplayName("자동차 전진 횟수 저장 테스트")
    void 자동차_전진_횟수_저장_테스트() {
        List<String> players = Arrays.asList("pobi", "jun", "wooni");
        String name = String.join(",", players);

        racingCarGame.createCar(name);
        racingCarGame.setCarMovingCountManager();

        CarMovingCountManager carMovingCountManager = racingCarGame.getCarMovingCountManager();
        List<Integer> carMovingCountList = carMovingCountManager.getCarMovingCountList();

        assertThat(carMovingCountList.size()).isEqualTo(players.size());

        for (int i = 0; i < carMovingCountList.size(); i++) {
            int movingCount = carMovingCountList.get(i);
            assertThat(movingCount).isEqualTo(0);
        }
    }
}