package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.TestNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameServiceTest {

    RacingGameService racingGameService;

    @BeforeEach
    void beforeEach() {
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(new int[]{1,6,4,7});
        racingGameService = new RacingGameService(testNumberGenerator);
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

    /**
     *  테스트 숫자가 1,6,4,7 이므로
     *  자동차가 2개 기준 게임을 2번 반복했을때
     *  1번 자동차는 1 -> 정지 , 4 -> 전진
     *  2번 자동차는 6 -> 전진 , 7 -> 전진 이다.
     */
    @Test
    void 임의의_테스트_숫자로_게임진행_결과_테스트() {
        //given
        String[] carNames = {"hwan","looloo"};
        racingGameService.init(carNames);

        //when
        racingGameService.playGame(2);

        //then
        List<Car> carList = racingGameService.getCarList();
        Car hwan = carList.get(0);
        Car looloo = carList.get(1);
        assertThat(hwan.getPosition()).isEqualTo(1);
        assertThat(looloo.getPosition()).isEqualTo(2);
    }

}