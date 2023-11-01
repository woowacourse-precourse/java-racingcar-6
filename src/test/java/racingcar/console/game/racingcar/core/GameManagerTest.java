package racingcar.console.game.racingcar.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.console.game.racingcar.car.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    public void setup() {
        gameManager = new GameManager();
    }

    @DisplayName("자동차 명단 등록 성공 테스트 - 참가자가 하나인 경우")
    @Test
    public void register_car_list_success_test_only_one() {
        // given
        String carListString = "우테코";

        // when
        gameManager.registerCarList(carListString);

        // then
        List<Car> cars = gameManager.getCars();
        assertEquals(1, cars.size());
        assertEquals("우테코", cars.get(0).getName());

    }

    @DisplayName("자동차 명단 등록 성공 테스트 - 참가자가 하나 이상인 경우")
    @Test
    public void register_car_list_success_test_more_than_one() {
        // given
        String carListString = "자비스,노비스,어비스,펄어비스";

        // when
        gameManager.registerCarList(carListString);

        // then
        List<Car> cars = gameManager.getCars();
        assertEquals(4, cars.size());
        assertEquals("자비스", cars.get(0).getName());
        assertEquals("노비스", cars.get(1).getName());
        assertEquals("어비스", cars.get(2).getName());
        assertEquals("펄어비스", cars.get(3).getName());

    }

    @DisplayName("총 라운드 등록 성공 테스트")
    @Test
    public void set_total_round_success_test() {
        // given
        String totalRound = "5";

        // when
        gameManager.setTotalRound(totalRound);

        // then
        assertEquals(5, gameManager.getGameConfig().getTotalRound());

    }

    @DisplayName("총 라운드 등록 실패 테스트 - 입력값이 정수가 아닐 때")
    @Test
    public void set_total_round_fail_test_not_integer() {
        // given
        String totalRound = "우테코";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> gameManager.setTotalRound(totalRound));

    }

    /*
        여기서부터는 테스트 과정이 원래 코드에 대한 의존성이 너무 높은 것 같음.
        의미없는 테스트 코드라는 생각이 든다.
        관련된 경험이 부족해서 해결책을 찾는데 어려움을 겪고 있음.
        그래도 의존성을 피할 수 있는 더 좋은 로직을 다방면으로 고민 중,
        한 마디로 지금 짠 코드가 매우 마음에 안 듬.
    */

    @DisplayName("우승자 테스트 - 가장 멀리간 자동차가 우승했는가?")
    @Test
    public void calculate_winners_farthest_test() {
        // given
        gameManager.registerCarList("자비스,노비스,어비스,펄어비스");
        gameManager.setTotalRound("5");
        gameManager.startRace();

        // when
        gameManager.calculateWinners();

        // then
        int max = gameManager.getCars().stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);
        assertEquals(max, gameManager.getWinners().get(0).getLocation());
    }


    @DisplayName("우승자 테스트 - 우승자 동률을 잘 처리했는가?")
    @Test
    public void calculate_winners_count_test() {
        // given
        gameManager.registerCarList("자비스,노비스,어비스,펄어비스");
        gameManager.setTotalRound("5");
        gameManager.startRace();

        // when
        gameManager.calculateWinners();

        // then
        int max = gameManager.getCars().stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);
        Long maxCount = gameManager.getCars().stream()
                .filter(car -> car.getLocation() == max)
                .count();
        assertEquals(maxCount, gameManager.getWinners().size());
    }

    @DisplayName("우승자 출력 테스트")
    @Test
    public void announce_winners_test() {
        // given
        gameManager.registerCarList("자비스,노비스,어비스,펄어비스");
        gameManager.setTotalRound("5");
        gameManager.startRace();
        gameManager.calculateWinners();

        // when & then
        int max = gameManager.getCars().stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);

        String[] winnerNames = gameManager.getCars().stream()
                .filter(car -> car.getLocation() == max)
                .map(Car::getName)
                .toArray(String[]::new);

        assertEquals(String.join(", ", winnerNames), gameManager.forwardWinners());
    }
}
