package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

class CarResultTest {

    @Test
    @DisplayName("가장 많이 전진한 플레이어의 정보를 올바르게 가져오는지 테스트")
    public void mostMovedPlayer() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", "-"),
                new Car("woni", "---"),
                new Car("jun", "--")
        );
        CarResult result = new CarResult(cars);
        List<String> maxPlayer = result.findMaxPlayers();
        Assertions.assertThat("woni").contains(maxPlayer);
    }

    @Test
    @DisplayName("가장 많이 전진한 플레이어가 2명 이상일 때 올바르게 작동하는지 테스트")
    public void multipleMovedPlayers(){
        List<Car> cars = Arrays.asList(
                new Car("pobi", "-"),
                new Car("woni", "--"),
                new Car("jun", "--")
        );
        CarResult result = new CarResult(cars);
        List<String> maxPlayer = result.findMaxPlayers();
        Assertions.assertThat(2).isEqualTo(maxPlayer.size());
    }



}