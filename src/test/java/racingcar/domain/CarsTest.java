package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CarsTest {
    @Test
    void 리스트_요소가_중복되면_IllegalArgumentException_에러를_던진다() {
        List<String> carNames = new ArrayList<>();

        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("pobi");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(carNames);
        });
    }

    @Test
    void 리스트_요소가_중복되면_메소드명_checkDuplicateCarName_에서_에러를_던진다() {
        List<String> carNames = new ArrayList<>();

        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("pobi");

        String methodName = "checkDuplicateCarName";

        try{
            new Cars(carNames);
        }catch (IllegalArgumentException e){
            String throwsFromMethod = e.getStackTrace()[0].getMethodName();
            assertEquals(throwsFromMethod, methodName);
        }
    }


}