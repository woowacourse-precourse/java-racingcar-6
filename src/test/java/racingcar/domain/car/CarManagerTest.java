package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.victory.VictoryManager;
import racingcar.domain.victory.VictoryView;

class CarManagerTest extends NsTest {

    @Test
    void 각_차수별_실행결과를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni");
                    CarManager carManager = new CarManager(new InputCarFactory(), new VictoryManager(new VictoryView()));
                    carManager.makeCar();
                    carManager.moveAndShowProgress();
                    assertThat(output()).contains("pobi : -", "woni :");
                },
                4, 3
        );
    }

    @Test
    void  누가_우승했는지를_알려준다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni");
                    CarManager carManager = new CarManager(new InputCarFactory(), new VictoryManager(new VictoryView()));
                    carManager.makeCar();
                    carManager.moveAndShowProgress();
                    carManager.showVictory();
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                4, 3
        );
    }

    @Override
    protected void runMain() {

    }
}