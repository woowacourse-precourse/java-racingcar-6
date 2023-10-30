package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RaceService 클래스")
class RaceServiceTest {
    private RaceService raceService;

    @Nested
    @DisplayName("inputCars 메서드는")
    class Describe_inputCars {
        @Nested
        @DisplayName("1이상 5이하의 차 이름이 주어진다면")
        class Context_with_characters_ranging_from_1_to_5 {
            private Cars cars;

            @BeforeEach
            void setup() {
                raceService = new RaceService(new ByteArrayInputStream("apple,peer,fruit".getBytes()));
                cars = raceService.inputCars();
            }

            @Test
            @DisplayName("오류없이 리턴")
            void it_successfully_return() {
                assertThat(cars).isNotNull();
                assertThat(cars.getCars()).hasSize(3);
                assertThat(cars.getCars()).usingRecursiveComparison().isEqualTo(List.of(new Cars.Car("apple", 0), new Cars.Car("peer", 0), new Cars.Car("fruit", 0)));
            }
        }

        @Nested
        @DisplayName("1이상 5이하의 차 이름을 갖지 않는다면")
        class Context_with_characters_other_than_1_to_5 {
            @BeforeEach
            void setup() {
                raceService = new RaceService(new ByteArrayInputStream("apple,peer,tomato".getBytes()));
            }

            @Test
            @DisplayName("IllegalArgumentException 발생시킴")
            void it_throw_IllegalArgumentException() {
                assertThatThrownBy(() -> raceService.inputCars()).isInstanceOf(IllegalArgumentException.class).hasMessage("입력된 문자열이 1~5자가 아닙니다.");
            }
        }
    }

    @Nested
    @DisplayName("inputCnt 메서드는")
    class Describe_inputCnt {
        @Nested
        @DisplayName("양수인 횟수가 주어진다면")
        class Context_count_is_a_positive_number {
            @Test
            @DisplayName("오류없이 리턴")
            void it_successfully_return() {

            }
        }

        @Nested
        @DisplayName("횟수가 음수가 주어진다면")
        class Context_count_is_character {
            @Test
            @DisplayName("IllegalArgumentException 발생시킴")
            void it_throw_IllegalArgumentException() {

            }
        }
    }

    @Nested
    @DisplayName("raceStart 메서드는")
    class Describe_raceStart {
        @Test
        @DisplayName("차를 이동시키고 결과를 보여줌")
        void it_move_cars_and_show_cars_and_distance_moved() {

        }
    }

    @Nested
    @DisplayName("showWinner 메서드는")
    class Describe_showWinners {
        @Test
        @DisplayName("가장 많이 이동한 자동차 출력, 만약 여러대일 경우 복수 출력")
        void it_finds_the_cars_with_the_longest_distance_and_if_there_are_multiple_it_prints_all_of_them() {

        }
    }
}