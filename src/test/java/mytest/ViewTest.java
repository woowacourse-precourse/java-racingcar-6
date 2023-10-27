package mytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingview.MainView;
import racingview.Viewable;

public class ViewTest {
    private final static ViewTestTemplete testTemplete = new ViewTestTemplete();
    private final static Viewable testView = new MainView();
    @BeforeEach
    void setOut()
    {
        testTemplete.setOut();
    }
    void isPrintEqualTo(String expected)
    {
        assertThat(testTemplete.flushAndResetoutAndGetbaos().toString().trim()).isEqualTo
                (expected);
    }

    @DisplayName("시작 문구 테스트")
    @Test
    void speakStartTest() {
        testView.speakStart();
        isPrintEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @DisplayName("시도횟수 물어보는 테스트")
    @Test
    void askForTimesTest() {
        testView.askForTimes();
        isPrintEqualTo("시도할 회수는 몇회인가요?");
    }

    @DisplayName("실행결과 시작 호출 테스트")
    @Test
    void speakresultStart() {
        testView.speakResultStart();
        isPrintEqualTo("실행 결과");
    }

    @Test
    @DisplayName("경기 결과를 알려주는 테스트")
    void speakresult() {
        LinkedHashMap<String, StringBuilder> testMap = new LinkedHashMap<>();
        testMap.put("FriedHam", new StringBuilder("--"));
        testMap.put("JustHam", new StringBuilder("-"));
        testView.speakResult(testMap);
        isPrintEqualTo("FriedHam : --\nJustHam : -");
    }

    @Test
    @DisplayName("우승자 테스트")
    void speakWinner() {
        List<String> testList = new ArrayList<>();
        testList.add("FriedHam");
        testView.speakWinner(testList);
        isPrintEqualTo("최종 우승자 : FriedHam");
    }
}
