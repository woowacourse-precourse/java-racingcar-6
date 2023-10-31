package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewMakerTest {

    @Test
    void 현재_위치_출력_테스트() {
        ViewMaker viewMaker = new ViewMaker();

        String expectA = "aaa : ---\n";
        String APositionView = viewMaker.makeCurrentPositionView("aaa", 3);

        String expectB = "b : \n";
        String BPositionVIew = viewMaker.makeCurrentPositionView("b", 0);

        Assertions.assertThat(expectA).isEqualTo(APositionView);
        Assertions.assertThat(expectB).isEqualTo(BPositionVIew);

    }

    @Test
    void 단일_승자_출력_테스트() {

        ViewMaker viewMaker = new ViewMaker();
        List<String> winner = new ArrayList<>();
        winner.add("bbb");

        String winnerView = viewMaker.makeWinnerView(winner);

        String expect = "최종 우승자 : bbb";
        Assertions.assertThat(expect).isEqualTo(winnerView);
    }


    @Test
    void 다중_승자_테스트() {

        ViewMaker viewMaker = new ViewMaker();
        List<String> winner = new ArrayList<>();
        winner.add("aaa");
        winner.add("bbb");

        String winnerView = viewMaker.makeWinnerView(winner);

        String expect = "최종 우승자 : aaa, bbb";
        Assertions.assertThat(expect).isEqualTo(winnerView);

    }

}
