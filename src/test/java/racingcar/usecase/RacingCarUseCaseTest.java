package racingcar.usecase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceChecker;
import racingcar.port.in.RacingCarInputPort;
import racingcar.service.CarService;
import racingcar.service.RacingCarGameService;
import racingcar.view.RacingCarView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarUseCaseTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    @DisplayName("자동차 경주 게임 e2e 테스트")
    void play() {
        // given
        RacingCarInputPort racingCarInputPort = new RacingCarInputPort() {
            public List<String> getCarNames() {
                return List.of("pobi", "crong", "honux");
            }

            public int getTryCount() {
                return 5;
            }
        };

        CarService carService = Mockito.mock(CarService.class);
        Mockito.when(carService.createCars(List.of("pobi", "crong", "honux")))
                .thenReturn(List.of(
                        new Car("pobi", () -> true),
                        new Car("crong", () -> true),
                        new Car("honux", () -> false)
                ));


        RacingCarUseCase racingCarUseCase = new RacingCarUseCase(
                carService,
                new RacingCarGameService(new RaceChecker()),
                new RacingCarView(),
                racingCarInputPort
        );

        // when
        racingCarUseCase.play();

        // then
        assertThat(output()).isEqualTo("""
                경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)
                시도할 회수는 몇회인가요?
                실행 결과
                pobi : -
                crong : -
                honux :\s

                실행 결과
                pobi : --
                crong : --
                honux :\s

                실행 결과
                pobi : ---
                crong : ---
                honux :\s

                실행 결과
                pobi : ----
                crong : ----
                honux :\s

                실행 결과
                pobi : -----
                crong : -----
                honux :\s

                최종 우승자 : pobi, crong"""
        );
    }

    private String output() {
        return captor.toString().trim();
    }
}