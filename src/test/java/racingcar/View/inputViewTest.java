package racingcar.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.StringToList.stringToList;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class inputViewTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";

        List<Car> ans = new ArrayList<>();
        ans.add(new Car("1"));
        ans.add(new Car("2"));

        List<Car> result = stringToList(input);
        assertThat(result).hasSameClassAs(ans);
    }

}
