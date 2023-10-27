package model;

import static fixture.CarFixture.createCar;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.Position.createWith;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import racingcar.exception.car_racing_manager.NotFoundCarException;
import racingcar.exception.car_racing_manager.NotUniqueCarNameException;
import racingcar.model.Car;
import racingcar.model.CarRacingManager;
import racingcar.model.Position;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarRacingManagerTest {

    private CarRacingManager carRacingManager;
    private Map<Car, Position> carPositionMap;

    @BeforeEach
    void setUp() {
        carPositionMap = new LinkedHashMap<>();
        carPositionMap.put(createCar("test"), createWith(0));
        carRacingManager = new CarRacingManager(carPositionMap);
    }

    @Test
    void 게임의_참여하는_자동차_중에_중복된_이름이_존재하면_예외를_발생시킨다() {
        // given
        carPositionMap.put(createCar("test"), createWith(0));

        // when & then
        assertThatThrownBy(() -> new CarRacingManager(carPositionMap))
                .isInstanceOf(NotUniqueCarNameException.class);

    }

    @Test
    void 자동차의_위치를_변경할_때_자동차가_게임_참여_대상에_없을_때_예외를_발생시킨다() {
        // given
        Car car = createCar("test1");
        Position position = createWith(1);

        // when & then
        assertThatThrownBy(() -> carRacingManager.changePosition(car, position))
                .isInstanceOf(NotFoundCarException.class);
    }
}
