package racingcar.view;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @DisplayName("단독 우승자 메시지 출력")
    @Test
    void getWinnerMessageWithSingle(){
        //given
        OutputView outputView = new OutputView();
        List<String> winnerList = new ArrayList<>();
        winnerList.add("sin");

        //when
        outputView.getWinnerMessage(winnerList);

        //then
        assertThat(output.toString()).contains("최종 우승자 : sin");
    }

    @DisplayName("우승자가 여러명인 경우 메시지 출력")
    @Test
    void getWinnerMessageWithMany(){
        //given
        OutputView outputView = new OutputView();
        List<String> winnerList = new ArrayList<>();

        winnerList.addAll(List.of("abc", "efg"));

        //when
        outputView.getWinnerMessage(winnerList);

        //then
        assertThat(output.toString()).contains("최종 우승자 : abc, efg");
    }

    @DisplayName("자동차 경주 실행 결과 출력")
    @Test
    void getRacingResult(){
        //given
        OutputView outputView = new OutputView();
        String result = "\nhaha: ---";

        //when
        outputView.getRacingResult(result);

        //then
        assertThat(output.toString())
                .contains("실행 결과", "haha: ---");
    }

}