package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.enums.Constant.FORWARD_THRESHOLD;
import static racingcar.enums.Constant.MAX_NAME_LENGTH;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.TestUtils;
import racingcar.controller.dto.WinnerDto;

class RacingGameServiceImplTest {

    private RacingGameServiceImpl racingGameService;
    private Cars cars;
    private String name;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameServiceImpl();

        int length = MAX_NAME_LENGTH.getConstant();
        name = TestUtils.generateName(length, 'a');
        Car car1 = new Car(name);

        name = TestUtils.generateName(length, 'b');
        Car car2 = new Car(name);

        carList = List.of(car1, car2);
        cars = new Cars(carList);
    }

    @Test
    void 한_라운드_진행_전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingGameService.playRound(cars);
                    for (Car car : cars.getCar()) {
                        assertThat(car.getPosition()).isEqualTo(1);
                    }
                },
                FORWARD_THRESHOLD.getConstant()
        );
    }

    @Test
    void 한_라운드_진행_전진_실패_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingGameService.playRound(cars);
                    for (Car car : cars.getCar()) {
                        assertThat(car.getPosition()).isEqualTo(0);
                    }
                },
                FORWARD_THRESHOLD.getConstant() - 1
        );
    }

    @Test
    void 우승자_찾기_기능_테스트() {
        //given
        carList.get(1).moveForward();

        //when
        WinnerDto winner = racingGameService.findWinner(cars);

        //then
        assertThat(winner.getWinners().get(0)).isEqualTo(name);
    }

}