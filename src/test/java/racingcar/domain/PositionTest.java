package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("자동차 위치 초기값 계산 완료")
    void 자동차_위치_초기값_계산() throws Exception {
        //given
        Map<String, Integer> carsMap = new LinkedHashMap<>(Map.of("A", 0, "B", 0, "C", 0));
        int carsGameCount = 5;
        //when
        Position position = new Position(carsMap, carsGameCount);
        //then
        System.out.println(position.getPosition());
    }

    @Test
    @DisplayName("자동차 위치 업데이트")
    void update() throws Exception {
        //given
        Map<String, Integer> carsMap = new LinkedHashMap<>(Map.of("A", 0, "B", 0, "C", 0));
        int carsGameCount = 5;
        Position carsPosition = new Position(carsMap, carsGameCount);
        //when
        int position = carsPosition.getPosition().get("A");
        carsPosition.update("A", 1);
        int newPosition = carsPosition.getPosition().get("A");
        //then
        assertThat(newPosition).isEqualTo(position + 1);
    }
    
    @Test
    @DisplayName("Test name")
    void metodName() throws Exception {
        //given
        Map<String, Integer> a = Map.of("a", 1, "b", 2);
        Integer a1 = a.put("a", 2);
        //when
    
        //then
    }

}