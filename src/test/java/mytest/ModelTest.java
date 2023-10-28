package mytest;
import static org.assertj.core.api.Assertions. *;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingmodel.GameChanger;
import racingmodel.MainModel;

public class ModelTest {
    @Test
    void gameChangerTest()
    {
        ArrayList testList = new ArrayList<>();
        testList.add(4);
        LinkedHashMap<String, StringBuilder> testMap= new LinkedHashMap<String, StringBuilder>();
        testMap.put("pobi",new StringBuilder("---"));

        GameChanger.getInstance().changeGame(testMap,testList);
        assertThat(testMap.get("pobi").toString()).isEqualTo("----");

    }
}
