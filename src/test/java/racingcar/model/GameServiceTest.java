package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;
import racingcar.model.gameinfo.RoundInfo;

class GameServiceTest {

    private List<CarInfo> createCarInfos(Map<String, Integer> createInfo) {
        List<CarInfo> carInfos = new ArrayList<>();

        createInfo.forEach((name, position) -> {
            CarInfo carInfo = new CarInfo(name);
            setCarPosition(position, carInfo);
            carInfos.add(carInfo);
        });

        return carInfos;
    }

    private void setCarPosition(Integer position, CarInfo carInfo) {
        for (int i = 0; i < position; i++) {
            carInfo.proceed();
        }
    }

    @Test
    @DisplayName("라운드 종료 False")
    public void checkGameOverFalse() {
        int maxRound = 3;
        RoundInfo roundInfo = new RoundInfo(maxRound);
        GameService gameService = new GameService();

        for (int i = 0; i < 1; i++) {
            roundInfo.finishRound();
        }

        Assertions.assertThat(gameService.isGameOver(roundInfo)).isFalse();
    }

    @Test
    @DisplayName("라운드 종료 True")
    public void checkGameOverTrue() {
        int maxRound = 3;
        RoundInfo roundInfo = new RoundInfo(maxRound);
        GameService gameService = new GameService();

        for (int i = 0; i < maxRound; i++) {
            roundInfo.finishRound();
        }

        Assertions.assertThat(gameService.isGameOver(roundInfo)).isTrue();
    }

    @Test
    @DisplayName("우승자 찾기 한 명")
    public void findWinners() {
        Map<String, Integer> createInfo = new HashMap<>();
        createInfo.put("A", 5);
        createInfo.put("B", 3);
        createInfo.put("C", 4);

        List<CarInfo> carInfos = createCarInfos(createInfo);
        GameService gameService = new GameService();
        Winners winners = gameService.findWinners(carInfos);

        Assertions.assertThat(winners.getWinnerList()).containsExactly("A");
    }

    @Test
    @DisplayName("우승자 찾기 한 명 이상")
    public void findWinners2() {
        Map<String, Integer> createInfo = new HashMap<>();
        createInfo.put("A", 5);
        createInfo.put("B", 3);
        createInfo.put("C", 5);

        List<CarInfo> carInfos = createCarInfos(createInfo);
        GameService gameService = new GameService();
        Winners winners = gameService.findWinners(carInfos);

        Assertions.assertThat(winners.getWinnerList()).containsExactly("A", "C");
    }
}