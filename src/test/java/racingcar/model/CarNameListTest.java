package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameListTest {

    @Test
    void Name_Size_Exceeded_Check() {
        String[] testCarNameList = {"asd","sfegge"};
        CarNameList carNameList = new CarNameList(testCarNameList);
        assertThatThrownBy(()->carNameList.NameSizeExceededCheck())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Name_Size_Value_Check(){
        String[] testCarNameList = {"asd","s e"};
        CarNameList carNameList = new CarNameList(testCarNameList);
        assertThatThrownBy(()->carNameList.NameValueCheck())
                .isInstanceOf(IllegalArgumentException.class);

    }
}