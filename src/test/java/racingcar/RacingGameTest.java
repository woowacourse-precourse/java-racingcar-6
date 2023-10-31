package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;
import racingcar.model.RealRandomGenerator;
import racingcar.model.TestRandomGenerator;

public class RacingGameTest {

    private RacingGame racingGame;
    private TestRandomGenerator testRandomGenerator;

    @BeforeEach
    public void setUp() {
        testRandomGenerator = new TestRandomGenerator(4); // 항상 전진하는 조
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        racingGame = new RacingGame(carNames, testRandomGenerator);
    }

    @Test
    public void 모든_차가_전진_했는지_확인() {
        racingGame.getCars().forEach(car ->
                assertThat(car.getPosition()).isEqualTo(0)
        );

        racingGame.race();

        racingGame.getCars().forEach(car ->
                assertThat(car.getPosition()).isEqualTo(1));
    }

}
