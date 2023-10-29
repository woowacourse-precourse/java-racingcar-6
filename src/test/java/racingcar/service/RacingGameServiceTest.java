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

    /**
     *  임의로 생성한 테스트 숫자가 1,6,4,7 이었을 때
     *  첫번째 숫자 1 빼고 나머지는 모두 숫자 4 이상으로
     *  2,3,4번째 자동차만 전진 조건(숫자 4 이상일 경우)에 해당하여
     *  position이 1씩 증가하여 2,3,4번째 자동차가 공동으로 최종 우승하게 된다.
     */
    @Test
    void 최종_우승자를_찾는_테스트_우승자가_여러_명일_경우() {
        //given
        String[] carNames = {"hwan","looloo","woo","hee"};
        racingGameService.init(carNames);
        racingGameService.playGame(1);

        //when
        String winningCarStr = racingGameService.getWinningCar();

        //then
        assertThat(winningCarStr).isEqualTo("looloo, woo, hee");
    }

    @Test
    void 최종_우승자를_찾는_테스트_우승자가_한_명일_경우() {
        //given
        String[] carNames = {"hwan","looloo"};
        racingGameService.init(carNames);
        racingGameService.playGame(1);

        //when
        String winningCarStr = racingGameService.getWinningCar();

        //then
        assertThat(winningCarStr).isEqualTo("looloo");
    }

}