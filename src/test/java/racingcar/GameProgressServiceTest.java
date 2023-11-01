package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.service.GameProgressService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameProgressServiceTest {
    List<Car> cars;
    @BeforeEach
    void setUp() {
        this.cars= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.cars.add(new Car("Car" + i));
        }
    }
    @ParameterizedTest
    @CsvSource({"0, 3"})
    void 자동차_정지_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        //then
        cars.forEach(car -> assertEquals(0, car.getPosition()));
    }

    @ParameterizedTest
    @CsvSource({"4, 9"})
    void 자동차_전진_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        //then
        cars.forEach(car -> assertEquals(1, car.getPosition()));
    }

    @ParameterizedTest
    @CsvSource({"4, 9"})
    void 자동차_전진_누적_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        gameProgressService.moveCars(cars);
        gameProgressService.moveCars(cars);
        //then
        cars.forEach(car -> assertEquals(3, car.getPosition()));
    }
    @ParameterizedTest
    @CsvSource({"0, 3"})
    void 라운드_출력_메시지_정지_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        String result = gameProgressService.getRoundResults(cars);
        //then
        assertThat(result).isEqualTo("Car0 : \nCar1 : \nCar2 : " );

    }
    @ParameterizedTest
    @CsvSource({"4, 9"})
    void 라운드_출력_메시지_전진_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        String result = gameProgressService.getRoundResults(cars);
        //then
        assertThat(result).isEqualTo("Car0 : -\nCar1 : -\nCar2 : -" );
    }
    @ParameterizedTest
    @CsvSource({"4, 9"})
    void 라운드_출력_메시지_전진누적_테스트 (int begin, int end) {
        //given
        GameProgressService gameProgressService = new GameProgressService(begin,end);
        //when
        gameProgressService.moveCars(cars);
        gameProgressService.moveCars(cars);
        gameProgressService.moveCars(cars);
        String result = gameProgressService.getRoundResults(cars);
        //then
        assertThat(result).isEqualTo("Car0 : ---\nCar1 : ---\nCar2 : ---" );
    }
}
