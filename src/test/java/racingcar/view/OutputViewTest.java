package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private static final String FORWARD_SYMBOL = "-";
    private static final String GAME_RESULT = "실행결과";
    private static final String MVP = "최종 우승자 : ";
    private static final String Comma = ", ";

    private OutputView outputView;
    @BeforeEach
    void setUp(){
        outputView = new OutputView();
    }
    @Test
    void 우승자_반환_테스트(){

    }


}