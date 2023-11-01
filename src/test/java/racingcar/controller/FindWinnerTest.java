package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import racingcar.AppConfig;
import racingcar.model.Car;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class FindWinnerTest {

    AppConfig appConfig = new AppConfig();
    List<Car> cars;
    PlayEachRacingGame playEachRacingGame = appConfig.playEachRacingGame();
    FindWinners findWinners = new FindWinnersImpl();
    Executable executable = () -> cars = playEachRacingGame.getPlayEachRacingGame(cars);


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
    void 단독_우승자() {
        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 3, 2);
                executable.execute();
            }
        });

        List<String> result = findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly("pobi");
    }

    @Test
    void 공동_우승자() {
        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 3, 7);
                executable.execute();
            }
        });

        List<String> result = findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly("pobi", "jun");
    }

}
