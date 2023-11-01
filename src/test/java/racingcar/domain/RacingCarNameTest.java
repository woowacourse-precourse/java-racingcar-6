package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarNameTest {
    private RacingCarName racingCarName;
    private InputStream systemIn;

    @BeforeEach
    public void setUp(){
        racingCarName = new RacingCarName();
        systemIn = System.in; //콘솔 입력
    }

    @AfterEach //테스트 끝난 후 원래 상태로
    public void originSystemIn(){
        System.setIn(systemIn);
    }

    @Test
    void 이름_정상적으로_입력(){
        userInput("bbe,bbsde,ted");
        List<String> correctNames = racingCarName.carNameList();
        assertEquals(3, correctNames.size());

    }

    @Test
    void 이름_중복() {
        userInput("bbe,bbe,ted");
        assertThrows(IllegalArgumentException.class, () -> racingCarName.carNameList());
    }

    @Test
    void 이름_5자_초과(){
        userInput("bbe,bbsdee,ted");
        assertThrows(IllegalArgumentException.class, () -> racingCarName.carNameList());

    }

    @Test
    void 이름_입력하지_않았음(){
        userInput("\n");
        assertThrows(IllegalArgumentException.class, () -> racingCarName.carNameList());

    }

    private void userInput(String names){
        System.setIn(new ByteArrayInputStream(names.getBytes()));
    }
}