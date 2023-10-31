package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarDto;

class RaceControllerTest {
    private static RaceController raceController;
    private static PrintStream standardOut;
    private static OutputStream captor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        raceController = RaceController.getInstance(RaceService.getInstance());
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        Console.close();
        raceController = null;
    }

    /*
     * 공백제거
     * */
    final String output() {
        return captor.toString().trim();
    }


    /*
     * 입력문자열에 대한 입력스트림 생성
     * */
    final void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    @DisplayName("동일한 싱글톤 인스턴스를 보장합니다.")
    void getInstance() {
        // GIVEN
        RaceService service1 = RaceService.getInstance();
        RaceService service2 = RaceService.getInstance();

        // WHEN
        RaceController instance1 = RaceController.getInstance(service1);
        RaceController instance2 = RaceController.getInstance(service2);

        // THEN
        assertEquals(service1, service2);
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("레이싱 게임을 검증합니다.")
    void startRaceGame() {
        final int MOVE_FORWARD = 4;
        final int STOP = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    // GIVEN
                    command("pobi,woni", "1");

                    // WHEN
                    raceController.startRaceGame();

                    // THEN
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVE_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시도 횟수만큼 게인 진행 후, 우승자를 구합니다.")
    public void getWinnersAfterMultipleRounds() {
        final int MOVE_FORWARD = 4;
        final int STOP = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    // GIVEN
                    List<Car> cars = new ArrayList<>();
                    cars.add(Car.createCar("pobi", 0));
                    cars.add(Car.createCar("woni", 0));
                    int round = 4;

                    // WHEN
                    CarDto actualDto = raceController.getWinnerDto(cars, round);

                    // THEN
                    CarDto expectedDto = new CarDto("pobi");
                    assertEquals(actualDto.carNames(), expectedDto.carNames());
                },
                MOVE_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시도 횟수를 입력받습니다.")
    public void getRoundUserInput() {
        // GIVEN
        command("3");

        // WHEN
        int actualRound = raceController.getRound();

        // THEN
        int expectedRound = 3;
        assertEquals(expectedRound, actualRound);
    }

    @Test
    @DisplayName("자동차들을 입력받습니다.")
    public void getCarsFromUserInput() {
        // GIVEN
        command("pobi,jiwon,tony,jihoo");

        // WHEN
        List<Car> actualCars = raceController.getCars();
        List<String> actualCarNames = actualCars.stream()
                .map(car -> car.getName()).toList();
        List<Integer> actualCarLocations = actualCars.stream()
                .map(car -> car.getCurrentLocation()).toList();

        // THEN
        assertThat(actualCarNames).containsExactly(
                "pobi", "jiwon", "tony", "jihoo");
        assertThat(actualCarLocations).containsExactly(
                0, 0, 0, 0);
    }
}