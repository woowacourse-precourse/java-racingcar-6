package racingcar.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Controller.MoveRandomNumber.inputView;
import static racingcar.View.InputViewTest.setReadLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.View.InputView;

class MoveRandomNumberTest {


    @Test
    void generateRandomGameNumberTest() {
        InputStream readLine = setReadLine("Pobi,NANa,Kane");
        System.setIn(readLine);


        List<Map<String,Integer>> actualTestResult = MoveRandomNumber.generateRandomGameNumber();
        List<Map<String,Integer>> expectTestResult = new ArrayList<>();

        Map<String,Integer> carCountMapTest = new HashMap<String,Integer>();
        carCountMapTest.put("Pobi",0);
        carCountMapTest.put("NANa",0);
        carCountMapTest.put("Kane",0);

        for (int i = 0 ; i < 5 ; i++) {
            for(String key : carCountMapTest.keySet()){
                carCountMapTest.put(key, Randoms.pickNumberInRange(0, 9));
                expectTestResult.add(carCountMapTest);
            }
        }

        assertNotEquals(expectTestResult,actualTestResult);

    }
}