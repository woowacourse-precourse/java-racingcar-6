package racingcar.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.List;

public class GameTest {
    private RacingCars racingCars;
    private TrialCount trialCount;

    @BeforeEach
    public void setUp() {
        // given, RacingCars와 TrialCount 초기화
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        List<Car> carList = Car.createCarList(names);
        racingCars = RacingCars.of(carList, () -> true);
        trialCount = TrialCount.of("3");
    }

    @Test
    public void 게임_진행_테스트() {
        // give,: Game 객체 생성
        Game game = Game.of(racingCars);

        // when, 게임 진행
        game.play(trialCount);

        // then, 결과 검증
        List<Car> finalCarsState = racingCars.cars();

        //then,  모든 차가 이동할 수 있으므로 각 차의 거리는 3이어야 함
        for (Car car : finalCarsState) {
            Assertions.assertEquals(3, car.getDistance());
        }
    }
}
