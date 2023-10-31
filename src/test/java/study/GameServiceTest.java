package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.util.MessageProcessor;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setup() {
        MessageProcessor messageProcessor = mock(MessageProcessor.class);
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        gameService = new GameService(messageProcessor, randomNumberGenerator);
    }

    @Test
    void createCars_유효한_입력() {
        List<Car> cars = gameService.createCars("car1,car2,car3");
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void playGame() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        int tryCount = 5;

        gameService.playGame(cars, tryCount);
        // 여기에서 playGame() 메서드를 호출하고 반환값을 확인하는 방법에 따라 추가 테스트 구성 가능
    }
}
