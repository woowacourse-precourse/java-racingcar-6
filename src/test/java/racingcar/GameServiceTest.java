package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;

public class GameServiceTest extends NsTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }


    @Test
    void 자동차_객체_생성() {
        // given
        List<Car> cars = new ArrayList<>();
        List<String> carNames = List.of("pobi", "jun", "ker");

        // when
        gameService.setCars(carNames, cars);

        // then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
