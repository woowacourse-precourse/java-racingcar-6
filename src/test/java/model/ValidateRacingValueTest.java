package model;

import static model.ValidateRacingValue.carNameInputToList;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateRacingValueTest {

    @DisplayName("쉼표로 구분된 string이 List에 저장되는가")
    @Test
    void carNameInputToListTest() {
        //given
        String carName = "pobi,nana,popo";
        //when
        List<String> listCarName = new ArrayList<>(carNameInputToList(carName));
        //then
        assertThat(listCarName).contains("pobi", "nana", "popo");
    }


}