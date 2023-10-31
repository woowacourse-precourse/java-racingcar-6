package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Nested
    @DisplayName("자동차 생성")
    class Car_CreateTest {

        @DisplayName("자동차 이름을 올바르게 입력")
        @ParameterizedTest
        @ValueSource(strings = {"poby", "woni", "jun"})
        void string_자동차_이름을_올바르게_입력(String name) {
            assertThatNoException().isThrownBy(()
                    -> Car.of(name));
        }
    }

    @Nested
    @DisplayName("자동차 이름 예외")
    class Car_ValidateTest {

        @Test
        @DisplayName("자동차 이름이 빈 칸이면 예외 발생")
        void blank_자동차_이름이_빈_칸이면_예외_발생() {
            assertThatThrownBy(() -> Car.of(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("자동차 이름에 공백이 포함되면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"", "  ", "Hello ys"})
        void blank_자동차_이름에_공백이_포함되면_예외_발생(String name) {
            assertThatThrownBy(() -> Car.of(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("Car 기능 테스트")
    class Car_FunctionalTest {

        @DisplayName("자동차 이름 반환")
        @ParameterizedTest
        @ValueSource(strings = {"pobi", "woni", "jun"})
        void return_자동차_이름_반환(String name) {
            Car car = Car.of(name);

            assertThat(car.getName())
                    .isEqualTo(name);
        }

        @DisplayName("자동차 전진 횟수 반환")
        @ParameterizedTest
        @ValueSource(strings = {"pobi", "woni", "jun"})
        void return_자동차_전진_횟수_반환(String name) {
            Car car = Car.of(name);

            assertThat(car.getMove())
                    .isEqualTo(0);
        }

        @DisplayName("자동차 전진 횟수 n회 증가")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void increase_자동차_전진_횟수_n회_증가(int n) {
            Car car = Car.of("테스트차");

            for (int i = 0; i < n; i++) {
                car = car.increaseMove();
            }

            assertThat(car.getMove())
                    .isEqualTo(n);
        }

        @DisplayName("자동차 전진 횟수 n회 증가 시 이동 자국 반환")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void increase_자동차_전진_횟수_n회_증가_시_이동_자국_반환(int n) {
            Car car = Car.of("테스트차");

            for (int i = 0; i < n; i++) {
                car = car.increaseMove();
            }

            String forwardTrail = car.receiveMoveTrail();
            assertThat(forwardTrail.length()).isEqualTo(n);
        }

        @DisplayName("자동차 전진 횟수 비교")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        void increase_자동차_전진_횟수_비교(int n) {
            Car car = Car.of("테스트차");

            for (int i = 0; i < n; i++) {
                car = car.increaseMove();
            }

            assertThat(car.compare(n))
                    .isTrue();
        }

        @DisplayName("게임 실행 결과 출력 형식 확인")
        @ParameterizedTest
        @ValueSource(strings = {"pobi", "woni", "jun"})
        void toString_게임_실행_결과_출력_형식_확인(String name) {
            Car car = Car.of(name);
            String expected = String.format("%s : ", name);

            assertThat(car.toString())
                    .isEqualTo(expected);
        }
    }
}