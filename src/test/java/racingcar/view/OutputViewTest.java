package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private String getSystemOutput() {
        return output.toString();
    }

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void buildResultString_자동차별_문자열을_합쳐_결과_문자열로_만들어_반환() {
        //given
        java.util.List<String> carNames = List.of("dawin", "woowa", "han", "tech", "cours");
        List<Integer> roundResult = List.of(1, 2, 3, 4, 5);

        //when
        String result = OutputView.buildResultString(carNames, roundResult);

        //then
        assertThat(result).contains("dawin : -\n",
                "woowa : --\n",
                "han : ---\n",
                "tech : ----\n",
                "cours : -----\n");
    }

    @Test
    void makeResultString_자동차의_이름과_이동_거리를_문자열로_만들어_반환() {
        //given
        String carName = "dawin";
        int distance = 7;

        //when
        String result = OutputView.makeResultString(carName, distance);

        //then
        assertThat(result).isEqualTo("dawin : -------\n");
    }

    @Test
    void printResultStartMessage_결과_출력_시작_메시지_출력() {
        //given

        //when
        OutputView.printResultStartMessage();

        //then
        assertThat(getSystemOutput()).isEqualTo("\n실행 결과" + "\n");

    }

    @Test
    void printRoundResult_자동차_이름과_라운드_결과를_전달받아_출력() {
        //given
        List<String> carNames = List.of("dawin", "woowa", "han", "tech", "cours");
        List<Integer> roundResult = List.of(1, 2, 3, 4, 5);

        //when
        OutputView.printRoundResult(carNames, roundResult);

        //then
        assertThat(getSystemOutput()).contains("dawin : -\n",
                "woowa : --\n",
                "han : ---\n",
                "tech : ----\n",
                "cours : -----\n",
                "\n");

    }

    @Test
    void printGameWinners_우승자가_한_명인_경우_한_명의_우승자_출력() {
        //given
        List<String> winners = List.of("dawin");

        //when
        OutputView.printGameWinners(winners);

        //then
        assertThat(getSystemOutput()).isEqualTo("최종 우승자 : dawin" + "\n");
    }

    @Test
    void printGameWinners_우승자가_여러_명인_경우_모든_우승자_출력() {
        //given
        List<String> winners = List.of("dawin", "tech", "cours");

        //when
        OutputView.printGameWinners(winners);

        //then
        assertThat(getSystemOutput()).isEqualTo("최종 우승자 : dawin, tech, cours" + "\n");
    }
}