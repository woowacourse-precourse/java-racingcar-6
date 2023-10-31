package racingcar.View;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.StringToList.stringToList;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.CarModel;

public class inputViewTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";

        List<CarModel> ans = new ArrayList<>();
        ans.add(new CarModel("1"));
        ans.add(new CarModel("2"));

        List<CarModel> result = stringToList(input);
        assertThat(result).hasSameClassAs(ans);
    }

    @Test
    void 이름에_대한_예외_처리() {
        String input = "pobi,javaji";

        try {
            stringToList(input);
        }
        catch (IllegalArgumentException e){
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
