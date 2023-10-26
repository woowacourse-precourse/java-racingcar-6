package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void split_메서드로_주어진_값을_구분() {
        final User user = new User();
        final String input = "pobi,woni,jun";

        final String[] carsNameArray = user.splitCarsName(input);

        assertThat(carsNameArray).contains("pobi", "woni", "jun");
    }
}