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
import static org.mockito.Mockito.*;
import static racingcar.domain.Cars.Car;
import static racingcar.domain.Cars.createCars;

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
                assertThat(cars.getCarList()).hasSize(3);
                assertThat(cars.getCarList()).usingRecursiveComparison().isEqualTo(List.of(new Car("apple", 0), new Car("peer", 0), new Car("fruit", 0)));
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
            private int cnt;

            @BeforeEach
            void setup() {
                raceService = new RaceService(new ByteArrayInputStream("5".getBytes()));
                cnt = raceService.inputCnt();
            }

            @Test
            @DisplayName("오류없이 리턴")
            void it_successfully_return() {
                assertThat(cnt).isEqualTo(5);
            }
        }

        @Nested
        @DisplayName("횟수가 음수 혹은 문자가 주어진다면")
        class Context_count_is_character {

            @BeforeEach
            void setup() {
                raceService = new RaceService(new ByteArrayInputStream("-5".getBytes()));
            }

            @Test
            @DisplayName("IllegalArgumentException 발생시킴")
            void it_throw_IllegalArgumentException() {
                assertThatThrownBy(() -> raceService.inputCnt()).isInstanceOf(IllegalArgumentException.class).hasMessage("입력된 문자열이 숫자가 아닙니다.");
            }
        }
    }

    @Nested
    @DisplayName("raceStart 메서드는")
    class Describe_raceStart {
        @Nested
        @DisplayName("한 대의 자동차가 주어질경우")
        class Context_one_car {
            private RaceService raceService;
            private Cars cars;

            @BeforeEach
            void setup() {
                raceService = spy(new RaceService());
                cars = createCars();
                cars.addCar(new Car("pobi", 0));
                when(raceService.getRandomMoveDistance()).thenReturn(6);
            }

            @Test
            @DisplayName("자동차가 멈추거나 랜덤하게 앞으로 감")
            void it_move_car_randomly() {
                raceService.raceStart(cars, 2);
                assertThat(cars.getCarList()).hasSize(1);
                assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
                assertThat(cars.getCarList().get(0).getDistance()).isEqualTo(12);
            }
        }

        @Nested
        @DisplayName("여러 대의 자동차가 주어질 경우")
        class Context_many_cars {
            private RaceService raceService;
            private Cars cars;

            @BeforeEach
            void setup() {
                raceService = spy(new RaceService());
                cars = createCars();
                cars.addCar(new Car("pobi", 0));
                cars.addCar(new Car("crong", 0));
                cars.addCar(new Car("maxi", 0));
                when(raceService.getRandomMoveDistance()).thenReturn(4);
            }

            @Test
            @DisplayName("여러 대의 자동차가 멈추거나 랜덤하게 앞으로 감")
            void it_move_cars_randomly() {
                raceService.raceStart(cars, 2);
                assertThat(cars).isNotNull();
                assertThat(cars.getCarList()).isNotNull();
                assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
                assertThat(cars.getCarList().get(0).getDistance()).isEqualTo(8);
                assertThat(cars.getCarList().get(1).getName()).isEqualTo("crong");
                assertThat(cars.getCarList().get(1).getDistance()).isEqualTo(8);
                assertThat(cars.getCarList().get(2).getName()).isEqualTo("maxi");
                assertThat(cars.getCarList().get(2).getDistance()).isEqualTo(8);
            }
        }

    }

    @Nested
    @DisplayName("showWinner 메서드는")
    class Describe_showWinner {
        @Nested
        @DisplayName("우승 차가 한대일 경우 자동차 출력")
        class Context_single_car {
            private RaceService raceService;
            private Cars cars;

            @BeforeEach
            void setup() {
                raceService = spy(new RaceService());
                cars = createCars();
                cars.addCar(new Car("pobi", 8));
                cars.addCar(new Car("crong", 4));
                cars.addCar(new Car("maxi", 2));
            }

            @Test
            void it_show_winner_car() {
                String winner = raceService.showWinners(cars);
                assertThat(winner).isEqualTo("pobi");
            }

        }

        @Nested
        @DisplayName("우승 차가 복수일 경우 복수 출력")
        class Context_multiple_cars {
            private RaceService raceService;
            private Cars cars;

            @BeforeEach
            void setup() {
                raceService = spy(new RaceService());
                cars = createCars();
                cars.addCar(new Car("pobi", 8));
                cars.addCar(new Car("crong", 8));
                cars.addCar(new Car("maxi", 2));
            }

            @Test
            void it_show_winner_car() {
                String winner = raceService.showWinners(cars);
                assertThat(winner).isEqualTo("pobi, crong");
            }

        }

    }


}