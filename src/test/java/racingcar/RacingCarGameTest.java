package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest extends NsTest {
    @CsvSource({
            "'woni,jun,pobi,mooso',4",
            "'    woni    ,jun   ,pobi,   mooso  ',4",
            "',,,,',5"
    })
    @ParameterizedTest
    void 자동차_이름_받은_후_자동차_컬랙션에_넣기(String givenCarNames, int expectedSize) {
        RacingCarGame game = new RacingCarGame();
        game.addRacingCar(givenCarNames);
        CarCollection givenCarCollection = game.getCarCollection();
        int givenSize = givenCarCollection.size();
        assertThat(givenSize).isEqualTo(expectedSize);
    }

    @Test
    void 시도할_회수_저장() {
        RacingCarGame game = new RacingCarGame();
        TryCount expectTryCount = TryCount.fromString("1");
        game.setTryCount("1");
        TryCount givenTryCount = game.getTryCount();
        assertThat(givenTryCount).isEqualTo(expectTryCount);
    }

    @Test
    void 자동차_이름_입력하는_프롬프트에서_경주할_자동차_이름_입력_출력() {
        String expectCarNameString = "woni,jun,pobi,mooso";
        command(expectCarNameString);
        RacingCarGame game = new RacingCarGame();
        game.getCarNameFromPrompt();
        assertThat(output()).isEqualTo(OutputView.RACINGCAR_REQUEST_MULTIPLE_CAR_NAME);
    }

    @Test
    void 자동차_이름_입력하는_프롬프트에서_자동차_이름_문자열_반환() {
        String expectCarNameString = "woni,jun,pobi,mooso";
        command(expectCarNameString);
        RacingCarGame game = new RacingCarGame();
        String carNameString = game.getCarNameFromPrompt();
        assertThat(carNameString).isEqualTo(expectCarNameString);
    }

    @Test
    void 자동차_시도_회수_입력하는_프롬프트에서_시도할_회수_몇회_출력() {
        String expectTryCountString = "5";
        command(expectTryCountString);
        RacingCarGame game = new RacingCarGame();
        game.getTryCountFromPrompt();
        assertThat(output()).isEqualTo(OutputView.RACINGCAR_REQUEST_TRY_COUNT);
    }

    @Test
    void 자동차_시도_회수_입력하는_프롬프트에서_시도할_회수_문자열_반환() {
        String expectTryCountString = "5";
        command(expectTryCountString);
        RacingCarGame game = new RacingCarGame();
        String tryCountString = game.getTryCountFromPrompt();
        assertThat(tryCountString).isEqualTo(expectTryCountString);
    }

    @Test
    void 자동차_게임_실행_결과_출력() {
        RacingCarGame game = new RacingCarGame();
        game.addRacingCar("woni,jun,pobi,mooso");
        game.displayRacingCarGameResult();
        assertThat(output()).contains(OutputView.RACINGCAR_EXECUTE_RESULT);
    }

    @Test
    void 자동차_게임_현재_자동차_위치_출력한_후_마지막은_공백_출력() {
        RacingCarGame game = new RacingCarGame();
        game.addRacingCar("woni,jun,pobi,mooso");
        game.displayCurrentCarStatus();
        game.displayCurrentCarStatus();
        assertThat(output()).contains("\n\n", "woni : ", "jun : ", "pobi : ", "mooso :");
    }

    @Test
    void 자동차_게임_최종_우승자_출력() {
        RacingCarGame game = new RacingCarGame();
        game.addRacingCar("mooso");
        game.displayWinners();
        assertThat(output()).isEqualTo("최종 우승자 : mooso");
    }

    @Test
    void 자동차_게임_최종_우승자들_출력() {
        RacingCarGame game = new RacingCarGame();
        game.addRacingCar("woni,jun,pobi,mooso");
        game.displayWinners();
        assertThat(output()).contains("최종 우승자 : ", "woni", "jun", "pobi", "mooso", ", ");
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
    }

}
