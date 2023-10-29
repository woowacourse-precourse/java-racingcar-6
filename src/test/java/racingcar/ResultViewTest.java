package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ResultViewTest {
    @Test
    void ResultView_인스턴스_생성확인() {
        ResultView resultView = new ResultView(new ArrayList<Car>());
    }
}