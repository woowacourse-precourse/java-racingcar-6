package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    private String[] carList;
    private Map<String, String> racingResult;

    @BeforeEach
    void setUp() {
        carList = new String[]{"pobi", "woni", "jun"};
        InputService.carList = carList;
        GameService.setInitCars();
    }

    @Test
    @DisplayName("성공 : 자동차 초기화")
    void setInitCarsForSuccess() {
        // when
        Map<String, String> expectedRacingResult = new LinkedHashMap<>();
        expectedRacingResult.put(carList[0], "");
        expectedRacingResult.put(carList[1], "");
        expectedRacingResult.put(carList[2], "");

        // then
        assertEquals(expectedRacingResult, GameService.racingResult);
    }

    @Test
    @DisplayName("성공 : 한 세트에 대한 결과")
    void racingForSuccess() {
        // given

        // when
        GameService.racing();

        Map<String, String> expectedRacingResult = new LinkedHashMap<>();

        for (String car : carList) {
            expectedRacingResult.put(car, "-");
        }

        // then
//        assertEquals(expectedRacingResult, GameService.racingResult);
    }

    @Test
    @DisplayName("성공 : 각 차에 대한 움직임")
    void movingForSuccess() {
        // given
        String car = "pobi,woni,jun";

        // when
        GameService.moving(car);

        Map<String, String> expectedRacingResult = new LinkedHashMap<>();

        expectedRacingResult.put(car, "-");

        // then
//        assertEquals(expectedRacingResult, GameService.racingResult);
    }

    @Test
    @DisplayName("성공 : 결과 출력")
    void printEachRacingResultForSuccess() {
        // given
        racingResult = new LinkedHashMap<>();
        racingResult.put("pobi", "------");
        racingResult.put("woni", "-------");
        racingResult.put("jun", "---------");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        GameService.printEachRacingResult(racingResult);

        String expectedOutput = "pobi : ------\nwoni : -------\njun : ---------\n\n";

        // then
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("성공 : 승자 결정")
    void determineWinnerForSuccess() {
        // given
        racingResult = new LinkedHashMap<>();
        racingResult.put("pobi", "------");
        racingResult.put("woni", "-------");
        racingResult.put("jun", "---------");

        GameService.racingResult = racingResult;

        // when
        List<String> winners = GameService.determineWinner();
        List<String> expectedWinners = Arrays.asList("jun", "woni", "pobi");

        // then
        assertEquals(expectedWinners, winners);
    }
}
