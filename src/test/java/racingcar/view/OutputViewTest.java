package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.constants.Phrase.GAME_RESULT;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
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

    private void assertOutputEquals(String expected) {
        String actual = outputStream.toString().trim();
        assertThat(actual).isEqualTo(expected);
    }

}