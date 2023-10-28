package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsGameResultTest {

    @Test
    @DisplayName("경주 결과 생성 및 저장 완료")
    void 경주_결과_저장() throws Exception {
        //given
        Map<String, Integer> carsMap = new LinkedHashMap<>(Map.of("A", 0, "B", 0, "C", 0));
        int carsGameCount = 5;
        //when
        CarsGameResult carsGameResult = new CarsGameResult(carsMap, carsGameCount);
        //then
        System.out.println(carsGameResult.getResult());
    }

}