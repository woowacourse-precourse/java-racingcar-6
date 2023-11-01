package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Nested
    @DisplayName("레이싱카 이동 시도 요청 시")
    class CreateRacingCars{

        @Test
        @DisplayName("유효한 횟수를 파라미터로 넘겨주면 예외없이 성공")
        void success(){
            List<String> carNames = List.of("car1", "car2", "car3");
            RacingCars racingCars = new RacingCars(carNames);

            int numberOfAttempts = 1;

            assertDoesNotThrow(() -> racingCars.attemptMove(numberOfAttempts));
        }
    }

    @Nested
    @DisplayName("레이싱카 우승자 출력 요청 시")
    class PrintWinners{

        @Test
        @DisplayName("유효한 RacingCar를 가졌다면 예외없이 성공")
        void success(){
            List<String> carNames = List.of("car1", "car2", "car3");
            RacingCars racingCars = new RacingCars(carNames);

            assertDoesNotThrow(() -> racingCars.printWinners());
        }
    }
}