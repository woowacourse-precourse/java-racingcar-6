package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingServiceTest {
    private final RacingService racingService = new RacingService();

    @DisplayName("입력받은 자동차의 이름으로 자동차 객체 리스트를 생성한다.")
    @Test
    void createCarList() {
        // given
        String[] names = new String[]{"pobi","woni","jun"};

        // when
        List<Car> carList = racingService.createCarList(names);

        // then
        assertThat(carList)
                .extracting("name", "winCount")
                .containsExactly(
                        tuple("pobi", 0),
                        tuple("woni", 0),
                        tuple("jun", 0)
                );
    }
}