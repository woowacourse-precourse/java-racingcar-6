package racingcar.service.dto;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class GameResultTest {

    @DisplayName("자동차 당 게임 결과 입출력")
    @Test
    public void 게임결과_입출력_테스트() throws  Exception {
        //given
        String carName1 = "car1";
        String carName2 = "car2";
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);

        car1.move(
                Car.MINIMUM_FOR_MOVE
        );

        //when
        GameResult gameResult = new GameResult();
        gameResult.note(car1);
        gameResult.note(car2);

        Set<String> resultKeySet = gameResult.getKeySet();
        int expectedKeySetSize = 2;
        int distanceCar1 = gameResult.getDistance(carName1);
        int distanceCar2 = gameResult.getDistance(carName2);

        //then
        Assertions.assertThat(resultKeySet.size()).isEqualTo(expectedKeySetSize);
        Assertions.assertThat(resultKeySet).containsExactly(carName1, carName2);    // 정확한 요소 및 순서 검증
        Assertions.assertThat(distanceCar1).isEqualTo(car1.getDistance());
        Assertions.assertThat(distanceCar2).isEqualTo(car2.getDistance());
    }

}