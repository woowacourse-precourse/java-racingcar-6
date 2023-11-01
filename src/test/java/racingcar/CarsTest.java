package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {
    private Cars cars;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    @BeforeEach
    void before(){
        cars = new Cars();
    }
    @DisplayName("차량생성테스트")
    @ParameterizedTest
    @CsvSource({"a,b,c","감자,고구마,호박","pobi,woni,jun","app,leba,na,na,javajigi"})
    public void 차량만들기(String str) {
        Map<String,Integer> carMap = cars.createCar(str);
        Map<String,Integer> testMap = new LinkedHashMap<>();

        for(String strarr:str.split(",")){
            testMap.put(strarr,0);
        }
        assertThat(carMap).isEqualTo(testMap);
    }


}