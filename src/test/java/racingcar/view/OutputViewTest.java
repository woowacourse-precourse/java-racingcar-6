package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
class OutputViewTest {
    OutputView outputView = new OutputView();

    @DisplayName("실행 결과 출력")
    @Test
    void moveResult() {
        Map<String,Integer> carMap = Map.of("pobi",1,"woni",0);
        List<String> carList = List.of("pobi","woni");
        StringBuilder sb = new StringBuilder();
        assertThat(outputView.moveResult(carMap,carList,sb).toString())
                .isEqualTo("pobi : -\n" + "woni : \n" );
    }
    @DisplayName("우승자 출력 시 괄호 제거")
    @Test
    void winnerList() {
        List<String> winnerList = List.of("pobi, woni");
        StringBuilder sb = new StringBuilder();
        assertThat(outputView.winnerList(winnerList,sb).toString())
                .isEqualTo("pobi, woni");
    }
}