package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class WinnerServiceTest {

    private WinnerService winnerService;


    @BeforeEach
    void init(){
        winnerService = new WinnerService();
    }

    @Test
    @DisplayName("우승자가 1명이 넘어가는 경우")
    void 우승자_1명_이상() {
        //given
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("pobi", 2));
        testCars.add(new Car("woni",3));
        testCars.add(new Car("jun", 3));
        //when
        String winners = winnerService.findWinners(testCars);

        //then
        Assertions.assertThat(winners).isEqualTo("woni, jun");
    }

    @Test
    @DisplayName("우승자가 1명인 경우")
    void findWinners2() {
        //given
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("pobi", 2));
        testCars.add(new Car("woni",3));
        testCars.add(new Car("jun", 2));
        //when
        String winners = winnerService.findWinners(testCars);

        //then
        Assertions.assertThat(winners).isEqualTo("woni");
    }


}