package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.constants.Phrase.GAME_RESULT;
import static racingcar.model.constants.Phrase.GAME_WINNER;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.dto.CarResponseDto;
import racingcar.model.dto.GameResponseDto;

class OutputViewTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("게임 결과 출력 문구인 '실행 결과'를 출력하는지 테스트 합니다.")
    void 게임_결과_출력_문구() {
        OutputView.printGameResult();
        assertOutputEquals(GAME_RESULT.getPhrase().trim());
    }

    @Test
    @DisplayName("게임 점수 출력 문구를 출력하는지 테스트 합니다.")
    void 게임_점수_출력_문구() {
        Car car = Car.from("pobi");
        car.move();
        GameResponseDto gameResponseDto = new GameResponseDto(car);
        OutputView.printGameScore(gameResponseDto);
        assertOutputEquals("pobi : -");
    }

    @Test
    @DisplayName("공백을 출력하는지 테스트 합니다.")
    void 공백_출력_문구() {
        OutputView.printJumpLine();
        assertOutputEquals("\n".trim());
    }

    @Test
    @DisplayName("우승자를 출력하는지 테스트 합니다.")
    void 우승자_출력_문구() {
        List<String> carNames = Arrays.asList("pobi");
        CarResponseDto carResponseDto = new CarResponseDto(carNames);
        OutputView.printWinner(carResponseDto);
        assertOutputEquals(GAME_WINNER.getPhrase() + carResponseDto.getCarNames().get(0));
    }

    private void assertOutputEquals(String expected) {
        String actual = outputStream.toString().trim();
        assertThat(actual).isEqualTo(expected);
    }

}