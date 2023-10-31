package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.within;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user = new User();

    @Test
    void createCarNames_경주할_자동차_리스트가_만들어지는지_확인() {
        String input = "pobi,jong,안종혁,jun";
        Assertions.assertThat(user.createCarNames(input)).isEqualTo(Arrays.asList("pobi","jong","안종혁","jun"));
    }

    @Test
    void createMovingNumber_시도횟수가_만들어지는지_확인() {
        String input = "3";
        Assertions.assertThat(user.createMovingNumber(input)).isEqualTo(3);
    }
}
