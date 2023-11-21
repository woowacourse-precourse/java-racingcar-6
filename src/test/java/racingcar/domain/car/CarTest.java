package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.numbergenerator.MoveNumber;
import racingcar.exception.RacingException;

class CarTest {

    static final int MOVE = 4;
    Car car;

    @BeforeEach
    void initCar() {
        car = new Car("pobi");
    }

    @Nested
    @DisplayName("이동 테스트")
    class 이동_테스트 {
        @ParameterizedTest(name = "{0}을 전달받으면 이동한다.")
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("[SUCCESS] 이동 성공 테스트")
        void 이동_성공_테스트(int number) {
            Assertions.assertThat(car.move(new MoveNumber(number)))
                    .isTrue();
        }

        @ParameterizedTest(name = "{0}을 전달받으면 이동하지 않는다.")
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("[SUCCESS] 이동 실패 테스트")
        void 이동_실패_테스트(int number) {
            Assertions.assertThat(car.move(new MoveNumber(number)))
                    .isFalse();
        }

        @ParameterizedTest(name = "{0}을 전달받으면 예외가 발생한다.")
        @ValueSource(ints = {-1, 10, 1000})
        @DisplayName("[EXCEPTION] 파라미터 검증 테스트")
        void 잘못된_값_테스트(int number) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> car.move(new MoveNumber(number)))
                    .withMessage(RacingException.INVALID_NUMBERS.getMessage());
        }
    }

    @Nested
    @DisplayName("위치 질의 테스트")
    class 위치_질의_테스트 {
        @ParameterizedTest(name = "{0}번 움직인 자동차에게 {1}번 위치에 있는지 질의하면 참을 반환한다.")
        @CsvSource(value = {
                "4, 4",
                "1, 1",
                "11, 11"
        })
        @DisplayName("정확한 위치 질의 테스트")
        void 정확한_위치_질의(int moveNum, int queryPosition) {
            for (int i = 0; i < moveNum; i++) {
                car.move(new MoveNumber(MOVE));
            }
            Assertions.assertThat(car.at(queryPosition))
                    .isTrue();
        }

        @ParameterizedTest(name = "{0}번 움직인 자동차에게 {1}번 위치에 있는지 질의하면 거짓을 반환한다.")
        @CsvSource(value = {
                "3, 4",
                "12, 1",
                "11, 10"
        })
        @DisplayName("잘못된 위치 질의 테스트")
        void 잘못된_위치_질의(int moveNum, int queryPosition) {
            for (int i = 0; i < moveNum; i++) {
                car.move(new MoveNumber(MOVE));
            }
            Assertions.assertThat(car.at(queryPosition))
                    .isFalse();
        }
    }


}