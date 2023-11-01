package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<RacingCar> racingCarList = List.of(new RacingCar("one"), new RacingCar("two"), new RacingCar("three"));

        racingCars = new RacingCars(racingCarList);
    }

    @Test
    void RacingCars_리스트에_생성된_RacingCar_들이_존재함() {
        // given

        // when, then
        assertTrue(racingCars.contains(new RacingCar("one")));
        assertTrue(racingCars.contains(new RacingCar("two")));
        assertTrue(racingCars.contains(new RacingCar("three")));
    }

    @Test
    void 최소_두_대의_RacingCar_가_없으면_경주가_진행되지_않는다() {
        // given
        List<RacingCar> racingCarList = new ArrayList<>();

        // when
        racingCarList.add(new RacingCar("four"));

        // then
        Assertions.assertThatThrownBy(() -> new RacingCars(racingCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주를 위해 최소 두 대의 RacingCar 가 필요합니다.");
    }

    @Test
    void 한_경기에_이름이_같은_RacingCar끼리_경주할_수_없다() {
        // given
        List<RacingCar> racingCarList = new ArrayList<>();

        // when
        racingCarList.add(new RacingCar("same"));
        racingCarList.add(new RacingCar("same"));

        // then
        Assertions.assertThatThrownBy(() -> new RacingCars(racingCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 가진 RacingCar 가 함께 경주할 수 없습니다.");
    }

    @Test
    void 깊은_복사된_객체는_서로_다르다() {
        // given

        // when
        RacingCars deepCopyRacingCar = new RacingCars(racingCars);

        // then
        assertNotSame(racingCars, deepCopyRacingCar);
    }

    @Test
    void RacingCars들의_초기_위치는_모두_0이다() {
        // given

        // when, then
        for (RacingCar racingCar : racingCars) {
            assertEquals(racingCar.getPosition(), 0);
        }
    }

    @Test
    void RacingCar들은_모두_move_될_수_있다() {
        // given

        // when
        RacingCars relocatedRacingCars = racingCars.move(() -> true);

        // then
        for (RacingCar racingCar : relocatedRacingCars) {
            assertEquals(racingCar.getPosition(), 1);
        }
    }

    @Test
    void 레이스의_결과로_우승한_RacingCar를_모두_찾을_수_있어야_한다() {
        // given
        List<RacingCar> racingCarList = moveOddRacingCars();

        RacingCars relocatedRacingCars = new RacingCars(racingCarList);

        // when
        RacingCarWinners winners = relocatedRacingCars.findWinners();

        // then
        assertTrue(winners.contains(new Name("one")));
        assertTrue(winners.contains(new Name("three")));
    }

    private List<RacingCar> moveOddRacingCars() {
        boolean isMovable = true;
        List<RacingCar> racingCarList = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            boolean movableFlag = isMovable;

            racingCarList.add(racingCar.move(() -> movableFlag));
            isMovable = !movableFlag;
        }
        return racingCarList;
    }
}