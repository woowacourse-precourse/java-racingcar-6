package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("[도메인] 자동차 도메인에서 ")
class CarTest {


    @Nested
    @DisplayName("생성 테스트")
    class CreateTest {
        @Test
        void _초기_설정은_시작라인에_위치합니다() {
            final var car = new Car("name");
            assertAll(
                    () -> assertThat(car.getName()).isEqualTo("name"),
                    () -> assertThat(car.getLap()).isEqualTo(0)
            );
        }

    }

    @Nested
    @DisplayName("기능 테스트의 경우")
    class ActionTest {
        @Test
        void 전략이_성립할_경우_한칸_전진한다() {
            final var car = new Car("name").move(() -> true);
            Assertions.assertThat(car.getLap()).isEqualTo(1);
        }

        @Test
        void _전략이_성립하지_않는_경우_전진하지_않는다() {
            final var car = new Car("name").move(() -> false);
            Assertions.assertThat(car.getLap()).isEqualTo(0);
        }
    }
}