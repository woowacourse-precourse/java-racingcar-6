package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SystemOutputTest {
    @DisplayName("출력형태확인")
    @Test
    void 출력형태_확인(){
        Map<String, Integer> numMoveMap = new HashMap();
        SystemOutput systemOutput = new SystemOutput();

        numMoveMap.put("사카", 1);
        numMoveMap.put("라이스", 0);
        numMoveMap.put("외데고르", 1);

        systemOutput.printMoveResult(numMoveMap);
    }

    @Test
    void 출력결과_확인(){

    }


}