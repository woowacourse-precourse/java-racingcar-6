package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    RacingGameService racingGameService;

    @BeforeEach
    void beforeEach() {
        racingGameService = new RacingGameService();
    }
    @Test
    void 입력받은_이름으로_Car_생성() {
        //given
        String[] carNames = {"hwan","hyen","hee"};

        //when
        racingGameService.init(carNames);

        //then
        List<Car> carList = racingGameService.getCarList();
        assertThat(carList)
                .extracting(c -> c.getName())
                .containsExactly(carNames);
    }

}