package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

public class myTest {
    @DisplayName("입력 -> 자동차 리스트")
    @Test
    public void 자동차이름_세팅(){
        //given
        CarName carName = new CarName();
        String input = ("pobi,woni,jun");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<String>() {{
            add("pobi");
            add("woni");
            add("jun");
        }};
        //when
        carName.carNamesToList(input);
        carName.setClearCarList();
        result = carName.getClearCarList();
        //then
        for(int i = 0; i < answer.size(); i++){
            assertEquals(result.get(i), answer.get(i));
        }
    }
}


