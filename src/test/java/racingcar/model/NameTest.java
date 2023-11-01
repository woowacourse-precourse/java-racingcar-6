package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
    @DisplayName("이름이 객체에 잘 담기는지 확인.")
    @Test
    void createTest_생성_테스트() {
        String input = "tName";
        Name name = new Name(input);

        assertThat(name.getName()).isEqualTo(input);
    }
}
