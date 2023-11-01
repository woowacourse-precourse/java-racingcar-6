package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.service.GameProgressService;
import racingcar.service.GameResultService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultServiceTest {
    GameResultService gameResultService;
    List<Car> cars;
    @BeforeEach
    void setUp() {
        this.gameResultService = new GameResultService();
        this.cars= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.cars.add(new Car("Car" + i));
        }
    }

    @Test
    void 우승자_출력_메시지_단일우승 () {
        //given
        GameProgressService gameProgressService = new GameProgressService();
        //when
        Car car1 = cars.get(1);
        car1.addPosition();
        String result = gameResultService.getFinalWinners(cars);
        //then
        assertThat(result).isEqualTo("Car1");
    }
    @ParameterizedTest
    @CsvSource({"4, 9"})
    void 우승자_출력_메시지_공동우승 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        String result = gameResultService.getFinalWinners(cars);
        //then
        assertThat(result).isEqualTo("Car0,Car1,Car2" );
    }
}
