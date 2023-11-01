package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;
import racingcar.model.service.GameService;
import racingcar.view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.view.OutputView.outputWinner;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class forwardAndStopTest {
        @Test
        void 전진_정지() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        @DisplayName("많은 반복에 의한 결과 출력")
        void manyAttemptsResultTest() {
            run("pobi,woni,faker,bdd,chovy", "5");
            assertThat(output()).contains("pobi : ", "woni : ", "faker : ", "bdd : ", "chovy : ");
        }
    }

    @Nested
    @DisplayName("예외 처리에 대한 테스트")
    class exceptionTest {
        @Test
        void 이름에_대한_예외_처리() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void emptyNameCheck() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void negativeAttemptCheck() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi", "-1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    @DisplayName("복수의 우승자에 대한 출력 검사")
    void multiWinnerTest() {
        //given
        CarRepository carRepository = new CarRepository();
        GameService gameService = new GameService(carRepository);
        List<String> players = new ArrayList<>(List.of("faker", "chovy", "bdd"));
        gameService.createCars(players);

        //when
        carRepository.findByName("faker").setForward(5);
        carRepository.findByName("chovy").setForward(5);
        carRepository.findByName("bdd").setForward(4);
        //then
        outputWinner(gameService.resultGame());
        assertThat(output()).contains("faker, chovy");
    }

    @Test
    @DisplayName("반복 횟수 예외 처리")
    void attemptVaildTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    @DisplayName("Repository tests")
    class CarRepositoryTest {

        @Test
        void save() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            assertThat(carRepository.findByName("pobi")).isNotNull();
        }

        @Test
        void carForward() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            carRepository.carForward(0, 5); // randomNumber가 4 이상일 때 전진해야한다.
            assertThat(carRepository.findByName("pobi").getForward()).isEqualTo(1);
        }

        @Test
        void carStop() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            carRepository.carForward(0, 3); // randomNumber가 4 미만일 때 정지해야한다.
            assertThat(carRepository.findByName("pobi").getForward()).isEqualTo(0);
        }

        @Test
        void findAllMaxForward() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            carRepository.save("woni");
            carRepository.save("faker");
            carRepository.save("bdd");
            carRepository.save("chovy");
            carRepository.findByName("pobi").setForward(5);
            carRepository.findByName("woni").setForward(5);
            assertThat(carRepository.findAllMaxForward()).containsExactly("pobi", "woni");
        }

        @Test
        void findByName() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            carRepository.save("woni");
            carRepository.save("faker");
            carRepository.save("bdd");
            carRepository.save("chovy");
            assertThat(carRepository.findByName("pobi").getName()).isEqualTo("pobi");
        }
    }

    @Nested
    @DisplayName("OutputView tests")
    class OutputViewTest {

        @Test
        void outputForward() {
            CarRepository carRepository = new CarRepository();
            carRepository.save("pobi");
            carRepository.findByName("pobi").setForward(5);
            OutputView.outputForward(carRepository.findByName("pobi"));
            assertThat(output()).isEqualTo("pobi : -----");
        }

        @Test
        void outputWinner() {
            CarRepository carRepository = new CarRepository();
            GameService gameService = new GameService(carRepository);
            carRepository.save("pobi");
            carRepository.save("woni");
            carRepository.save("faker");
            carRepository.save("bdd");
            carRepository.save("chovy");
            carRepository.findByName("pobi").setForward(5);
            carRepository.findByName("woni").setForward(5);
            OutputView.outputWinner(gameService.resultGame());
            assertThat(output()).isEqualTo("최종 우승자 : pobi, woni");
        }
    }

    @Nested
    class CarTest {

        @Test
        void setAndGetForward() {
            Car car = new Car("temp");
            car.setForward(5);
            assertThat(car.getForward()).isEqualTo(5);
        }

        @Test
        void getName() {
            Car car = new Car("temp");
            assertThat(car.getName()).isEqualTo("temp");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
