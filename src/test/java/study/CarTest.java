package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void split_메서드로_주어진_값을_쉼표_기준으로_구분하고_리스트형태로_변환(){
        String userInput = "pobi,woni,jun";
        List<String> car = Arrays.stream(userInput.split(",")).toList();

        assertThat(car).contains("pobi", "jun", "woni");  //포함돼있으면 성공(순서X,중복O)
        assertThat(car).containsExactly("pobi", "woni", "jun");   //순서와 중복까지 체크
    }
    @Test
    void initHashMap_메서드로_주어진_리스트를_키로_갖고_값을_0으로_설정() {
        HashMap<String, Integer> carDist = new HashMap<>();
        List<String> cars = Arrays.asList("pobi", "woni", "jun");

        for (String element : cars){
            carDist.put(element, 0);
        }


        assertThat(carDist).isNotEmpty();   //비어있지않은지 확인
        assertThat(carDist).hasSize(cars.size());   //주어진 리스트와 사이즈가 같은지 확인.
        assertThat(carDist).containsKeys("pobi", "woni", "jun");    //리스트 목록이 키로 설정돼있나 체크
        assertThat(carDist).containsValues(0, 0, 0);    //값이 0으로 초기화 돼있나 체크
    }
    @Test
    void plus_메서드로_주어진_키로_값에_1더하기() {
        HashMap<String, Integer> carDist = new HashMap<>();
        carDist.put("pobi",0);
        String name = "pobi";

        carDist.put(name, carDist.get(name)+1);


        assertThat(carDist).containsEntry("pobi", 1);   //값이 1 늘어났는지 체크
    }

}
