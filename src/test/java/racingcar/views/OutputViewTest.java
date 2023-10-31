package racingcar.views;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constants.RacingCarGameComments;

class OutputViewTest {

    @Test
    @DisplayName("레이싱 자동차 경주 오프닝 멘트 출력 값 테스트")
    void racingCarOpeningComment() {

        String output = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        String outputConstant = RacingCarGameComments.OPENING_COMMENT;
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        OutputView.racingCarOpeningComment();

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        assertThat(output).isEqualTo(result);
        assertThat(outputConstant).isEqualTo(result);
    }

    @Test
    @DisplayName("도전 횟수 멘트 출력 값 테스트")
    void tryComment() {
        String output = "시도할 회수는 몇회인가요?";
        String outputConstant = RacingCarGameComments.TRY_COMMENT;
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        OutputView.tryCountInputComment();

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        assertThat(output).isEqualTo(result);
        assertThat(outputConstant).isEqualTo(result);
    }

    @Test
    @DisplayName("레이싱 결과 시작 멘트 출력 값 테스트")
    void racingCarResultCommentTest() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        OutputView.racingCarResultComment();

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        assertThat(result).isEqualTo(RacingCarGameComments.RESULT_COMMENT);
    }

    @Test
    @DisplayName("레이싱 이동 결과 출력 값 테스트")
    void racingCarResultPrintTest() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        OutputView.racingCarResultPrint("lee", "----");

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        assertThat(result).isEqualTo("lee : ----");
    }

    @Test
    @DisplayName("레이싱 우승자 출력 값 테스트")
    void racingCarWinnerPrintTest() {
        PrintStream standardOut = System.out;
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteOutput));

        OutputView.racingCarWinnerPrint(new String[]{"toby, lee"});

        System.setOut(standardOut);
        String result = byteOutput.toString().trim();
        assertThat(result).isEqualTo(RacingCarGameComments.WINNER_COMMENT + "toby, lee");
    }

}