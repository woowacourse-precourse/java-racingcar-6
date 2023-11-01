package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("split 메소드를 사용 시에 쉼표(,)를 기준으로 이름이 나뉜다.")
    @Test
    void splitNamesByComma() {
        //Given
        User user = new User();
        String input = "pobi,woni,jun";

        //When
        String[] splits = user.split(input);

        //Then
        assertThat(splits.length).isEqualTo(3);
    }
}