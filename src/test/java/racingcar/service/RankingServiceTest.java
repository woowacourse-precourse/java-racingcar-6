package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarList.CarDto;

class RankingServiceTest {

    private final RankingService rankingService = new RankingService();

    @DisplayName("우승 판정 테스트")
    @Test
    void checkWinner() {
        List<CarDto> carDtoList = new ArrayList<>();
        List<String> winner = new ArrayList<>();
        CarDto carDto1 = new CarDto("a", 1);
        CarDto carDto2 = new CarDto("b", 2);

        winner.add(carDto2.carName());
        carDtoList.add(carDto1);
        carDtoList.add(carDto2);
        List<String> winnerList = rankingService.checkWinner(carDtoList);
        assertThat(winner).isEqualTo(winnerList);

    }
}