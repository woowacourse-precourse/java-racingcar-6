package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.Model.Cars;
import racingcar.View.OutputView;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    Cars player1 = new Cars("kim");
    Cars player2 = new Cars("lee");
    Cars player3 = new Cars("park");

    @Test
    void 최종우승자_출력_Test() {
        // given
        ArrayList<String> winnerNames = new ArrayList<>();
        winnerNames.add("kim");
        winnerNames.add("park");
        PrintStream standardOut = System.out; // 표준 스트림 초기화
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        //when
        outputView.printFinalWinner(winnerNames);

        //then
        System.setOut(standardOut);
        String result = captor.toString().trim();

        assertThat("최종 우승자 : kim, park").isEqualTo(result);
    }

    @Test
    void singleGame_Test() {
        for (int i = 0; i < 2; i++) { // kim 2번 전진
            player1.goOneStep();
        }

        for (int i = 0; i < 3; i++) { // lee 3번 전진
            player2.goOneStep();
        }

        for (int i = 0; i < 5; i++) { // park 5번 전진
            player3.goOneStep();
        }

        ArrayList<Cars> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        //given
        PrintStream standardOut = System.out; // 표준 스트림 초기화
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        //when
        outputView.printSingleGame(players);

        //then
        System.setOut(standardOut);
        String result = captor.toString().trim();

        assertThat("kim : --\nlee : ---\npark : -----").isEqualTo(result);
    }
}