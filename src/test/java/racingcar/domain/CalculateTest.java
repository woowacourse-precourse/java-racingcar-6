package racingcar.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    void mappingNameAndCar() {
        Calculate cal = new Calculate();
        //value에 0으로 채워진 HashMap 형식으로 반환하는가
        List<String> racers = new ArrayList<String>() {{
            add("pobi");
            add("woni");
            add("jun");
        }};
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("pobi", 0);
            put("woni", 0);
            put("jun", 0);
        }};

        HashMap<String, Integer> result = cal.MappingNameAndCar(racers);
        assertThat(result).isEqualTo(hashMap);
    }


    @Test
    void setCarPosition() {
        Calculate cal = new Calculate();
        //Hashmap의 value가 1 증가했는가
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("pobi", 1);
            put("woni", 1);
            put("jun", 1);
        }};
        HashMap<String, Integer> result =  cal.setCarPosition();
        assertThat(result).isEqualTo(hashMap);
    }
}