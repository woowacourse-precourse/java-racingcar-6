package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.model.TestHelper.generateRandomString;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Name;

public class NameTest {
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 5;

    @Test
    @DisplayName("유효한 이름 길이일 경우 Name은 생성된다.")
    public void 유효한_이름_길이일_경우_Name은_생성된다() {
        //given
        String randomName = generateRandomString(MIN_NAME_LENGTH);

        //when
        Name name = Name.from(randomName);

        //then
        assertThat(name.name()).isEqualTo(randomName);
    }

    @Test
    @DisplayName("이름 길이가 최소 길이 미만일 경우 IllegalArgumentException 발생한다.")
    public void 이름_길이가_최소_길이_미만일_경우_IllegalArgumentException_발생한다() {
        //given
        String randomName = generateRandomString(MIN_NAME_LENGTH - 1);

        //when & then
        assertThatThrownBy(() -> Name.from(randomName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 길이가 최대 길이 초과일 경우 IllegalArgumentException 발생한다.")
    public void 이름_길이가_최대_길이_초과일_경우_IllegalArgumentException_발생한다() {
        //given
        String randomName = generateRandomString(MAX_NAME_LENGTH + 1);

        //when & then
        assertThatThrownBy(() -> Name.from(randomName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
