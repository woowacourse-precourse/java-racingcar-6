package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarManagerTest {
    @DisplayName("자동차 이름 리스트가 전달되었을 떄, 객체가 잘 생성되는지 확인")
    @Test
    void 올바른_자동차_이름_리스트가_전달되었을때_객체가_잘_생성됨을_확인() {
        // given
        final String[] carNames = {"woowa", "junju", "baemi", "alpha"};
        CarNameList carNameList = new CarNameList(carNames);

        // when, then
        assertThat(new RacingCarManager(carNameList)).isInstanceOf(RacingCarManager.class);
    }

    @DisplayName("객체가 생성된 뒤, 경주차 리스트를 관리하고 있는지 확인")
    @Test
    void 객체가_생성된뒤_경주차_리스트를_관리하고_있는지_확인() {
        // given
        final String[] carNames = {"woowa", "junju", "baemi", "alpha"};
        CarNameList carNameList = new CarNameList(carNames);
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);

        // when, then
        assertThat(racingCarManager.getCarList()).isInstanceOf(CarList.class);
        for (int i = 0; i < carNames.length; i++) {
            assertThat(racingCarManager.getCarList().getCarList().get(i)).isInstanceOf(Car.class);
        }
    }

    @DisplayName("객체가 생성된 뒤, 경주 게임을 시행할 수 있는지 확인")
    @Test
    void 객체가_생성된뒤_경주_게임을_시행할수_있는지_확인() {
        // given
        final String[] carNames = {"woowa", "junju", "baemi"};
        CarNameList carNameList = new CarNameList(carNames);
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);

        // when, then
        for (int i = 0; i < 10000000; i++) {
            assertThatNoException().isThrownBy(racingCarManager::playRacingGame);
        }
    }

    @DisplayName("경주 게임을 시행했을 때, 차량이 전진 혹은 정지하는지 여부 확인")
    @Test
    void 경주_게임을_시행할때_관리하는_차량이_전진_혹은_정지하는지_여부_확인() {
        // given
        final String[] carNames = {"woowa", "junju", "baemi"};
        CarNameList carNameList = new CarNameList(carNames);
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);

        // when, then
        for (int i = 0; i < 10000000; i++) {
            racingCarManager.playRacingGame();
        }
        CarList carList = racingCarManager.getCarList();
        for (int i = 0; i < carList.getCarList().size(); i++) {
            assertThat(carList.getCarList().get(i).getDistance()).isGreaterThan(0);
        }
    }
}