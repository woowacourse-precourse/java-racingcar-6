package racingcar.View;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.View.InputView;
public class InputViewTest {
    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    void askCarName(){
        InputStream readLine = setReadLine("Pobi,NANa,Kane");
        System.setIn(readLine);


        String expectCarName = "Pobi,NANa,Kane";
        String resultCarName = InputView.askCarName();

        assertEquals(expectCarName,resultCarName);
    }




    @Test
    void askTryCountTest(){
        InputStream readLine = setReadLine("5");
        System.setIn(readLine);


        int inputTryCount = 5;
        int intTrtCount = InputView.askTryCount();

        assertEquals(inputTryCount,intTrtCount);
    }

    @Test
    void storeCarNameTest(){
        InputStream readLine = setReadLine("Pobi,NANa,Kane");
        System.setIn(readLine);

        Map<String,Integer> carCountMapTest = new HashMap<String,Integer>();
        carCountMapTest.put("Pobi",0);
        carCountMapTest.put("NANa",0);
        carCountMapTest.put("Kane",0);

        Map<String,Integer> carCountMap = InputView.storeCarName();
        assertEquals(carCountMapTest,carCountMap);


    }
}