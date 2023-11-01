package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private static RacingCars racingCars;

    @BeforeEach
    void 테스트_준비() {
        racingCars = new RacingCars();
    }

    @Test
    void 사용자가_입력한_이름들로_Car_객체를_생성해_저장한다() {
        // given
        String names = "pobi,woni,jun";

        // when
        racingCars.addCars(names);
        String status = racingCars.getCarsStatus();
        String[] statusArray = status.split("\n");

        // then
        assertThat(statusArray[0]).isEqualTo("pobi : ");
        assertThat(statusArray[1]).isEqualTo("woni : ");
        assertThat(statusArray[2]).isEqualTo("jun : ");
    }

    @Test
    void 자동차들의_경주_상황에_대한_정보_반환한다() {
        // given
        racingCars.addCars("myCar");

        // when
        String status = racingCars.getCarsStatus();

        // then
        assertThat(status).isEqualTo("myCar : \n");
    }

    @Test
    void 임의의_수를_발생시켜_저장_중인_자동차들을_전진_혹은_정지시킨다() {
        // given
        String names = "pobi,woni,jun";
        racingCars.addCars(names);
        int lowerBound = 4;
        int upperBound = 9;

        // when
        racingCars.moveCars(lowerBound, upperBound);
        String status = racingCars.getCarsStatus();
        String[] statusArray = status.split("\n");

        // then
        assertThat(statusArray[0]).isEqualTo("pobi : -");
        assertThat(statusArray[1]).isEqualTo("woni : -");
        assertThat(statusArray[2]).isEqualTo("jun : -");
    }

    @Test
    void 자동차들_중_선두에_있는_자동차를_찾는다() {
        // given
        // myCar는 1번 전진했다.
        Car myCar = new Car("myCar");
        myCar.moveCar(4);

        // 그러나 pobi, woni, jun은 추가만 됐지 전진하지 않았다.
        String names = "pobi,woni,jun";
        racingCars.addCars(names);

        // when
        Car winnerCar = racingCars.findWinnerCar();

        // then
        assertThat(winnerCar.isSameDistanceAs(myCar)).isEqualTo(false);
    }

    @Test
    void 자동차들_중_최종_우승자들을_찾는다() {
        // given
        String names = "pobi,woni,jun";
        racingCars.addCars(names);

        // when
        String winners = racingCars.findRaceWinners();

        // then
        assertThat(winners).isEqualTo("pobi, woni, jun");
    }
}