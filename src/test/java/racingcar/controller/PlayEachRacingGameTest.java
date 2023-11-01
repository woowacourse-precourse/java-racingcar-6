package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import racingcar.AppConfig;
import racingcar.model.Car;

import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;


public class PlayEachRacingGameTest {

    List<Car> cars;
    AppConfig appConfig = new AppConfig();
    PlayEachRacingGame playEachRacingGame = appConfig.playEachRacingGame();

    @Mock
    private Randoms randoms;

    @BeforeEach
    void setCars() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    @Test
    void 각각_레이스_시작() throws Exception {

        Executable executable = () -> cars = playEachRacingGame.getPlayEachRacingGame(cars);


        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 3, 2);
                executable.execute();
            }
        });


        Assertions.assertThat(cars.get(0).getMoveCount()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getMoveCount()).isEqualTo(0);
        Assertions.assertThat(cars.get(2).getMoveCount()).isEqualTo(0);

        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(6, 5, 2);
                executable.execute();
            }
        });

        Assertions.assertThat(cars.get(0).getMoveCount()).isEqualTo(2);
        Assertions.assertThat(cars.get(1).getMoveCount()).isEqualTo(1);
        Assertions.assertThat(cars.get(2).getMoveCount()).isEqualTo(0);
    }
}
