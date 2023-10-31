package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.RacingCarRepository;

class RacingCarServiceTest {

    private RacingCarRepository racingCarRepository;
    private RacingCarService racingCarService;

    @BeforeEach
    void beforeEach() {
        racingCarRepository = new RacingCarRepository();
        racingCarService = new RacingCarService(racingCarRepository);
    }

    @Test
    @DisplayName("이동 횟수가 가장 많은 자동차가 하나일 경우 우승자는 한 명이다.")
    void getSingleWinnerWhenGreatestMovingCountCarOne() {
        //given
        Car winner = new Car("miro");
        Car firstLoser = new Car("romi");
        Car secondLoser = new Car("rimo");
        winner.move(4);
        winner.move(4);

        firstLoser.move(4);
        racingCarRepository.save(List.of(winner, firstLoser, secondLoser));

        //when
        List<String> winnerNames = racingCarService.getWinnerNames();
        //then
        assertThat(winnerNames).size().isEqualTo(1);
        assertThat(winnerNames).containsExactly(winner.getName());
    }

    @Test
    @DisplayName("이동 횟수가 가장 많은 자동차가 여러 대 일 경우 우승자가 여러 명이다.")
    void getMultipleWinnerWhenGreatestMovingCountCarMultiple() {
        //given
        Car firstWinner = new Car("miro");
        Car secondWinner = new Car("romi");
        Car loser = new Car("rimo");
        firstWinner.move(4);
        firstWinner.move(4);

        secondWinner.move(4);
        secondWinner.move(4);
        racingCarRepository.save(List.of(firstWinner, secondWinner, loser));

        //when
        List<String> winnerNames = racingCarService.getWinnerNames();
        //then
        assertThat(winnerNames).size().isEqualTo(2);
        assertThat(winnerNames).containsExactly(firstWinner.getName(), secondWinner.getName());
    }
}