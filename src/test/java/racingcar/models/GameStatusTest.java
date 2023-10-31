package racingcar.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {

    private List<String> getSampleCarNames() {
        return List.of("pobi", "crong", "honux");
    }

    @Test
    void 게임_상태_생성_테스트() {
        // given
        List<String> carNames = getSampleCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        List<CarStatus> carStatuses = cars.stream()
                .map(CarStatus::of)
                .toList();

        // when
        GameStatus gameStatus = new GameStatus();
        for (CarStatus carStatus : carStatuses) {
            gameStatus.addCarStatus(carStatus);
        }

        // then
        assertEquals(gameStatus.getCarStatuses().size(), carStatuses.size());
    }

    @Test
    void 게임_상태_문자열_변환_테스트() {
        // given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");

        carProceed(pobi, 2);
        carProceed(crong, 1);
        carProceed(honux, 3);

        List<CarStatus> carStatuses = List.of(
                CarStatus.of(pobi),
                CarStatus.of(crong),
                CarStatus.of(honux)
        );

        // when
        GameStatus gameStatus = new GameStatus();
        for (CarStatus carStatus : carStatuses) {
            gameStatus.addCarStatus(carStatus);
        }

        // then
        assertEquals("pobi : --\ncrong : -\nhonux : ---\n", gameStatus.toString());
    }

    private void carProceed(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.proceed();
        }
    }

}