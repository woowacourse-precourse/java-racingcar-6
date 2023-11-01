package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.StringTo.stringToCarCntInteger;
import static racingcar.util.StringTo.stringToCarModelList;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.CarModel;

public class StringToTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";

        List<CarModel> ans = new ArrayList<>();
        ans.add(new CarModel("1"));
        ans.add(new CarModel("2"));

        List<CarModel> result = stringToCarModelList(input);
        assertThat(result).hasSameClassAs(ans);
    }

    @Test
    void 이름에_대한_예외_처리() {
        String input = "pobi,javaji";

        try {
            stringToCarModelList(input);
        }
        catch (IllegalArgumentException e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 사용자에게_이동_값_받기(){
        String input = "5";
        assertThat(stringToCarCntInteger(input)).isEqualTo(5);
    }
}
