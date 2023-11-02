package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


class WinnerServiceTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private WinnerService winnerService;


    @BeforeEach
    void setUp() {
        car1 = new Car("pobi", List.of(TRUE, TRUE, TRUE, TRUE, TRUE));
        car2 = new Car("woni", List.of(FALSE, TRUE, TRUE, TRUE, TRUE));
        car3 = new Car("jun", List.of(TRUE, TRUE, TRUE, TRUE, TRUE));
        winnerService = new WinnerService();
    }

    @Test
    void findWinners_정확한_순서로_우승자를_찾는지_확인() {
        List<Car> winners = winnerService.findWinners(List.of(car1, car2, car3));
        Assertions.assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("pobi", "jun");
    }
}