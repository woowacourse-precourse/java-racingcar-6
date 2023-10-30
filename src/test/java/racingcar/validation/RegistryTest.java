package racingcar.validation;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistryTest {
    @DisplayName("중복된 이름")
    @Test
    void duplicateNameTest() {
        //given
        List<String> duplicateName = Arrays.asList("배달이", "배달이", "동준이");
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Registry.isValid(duplicateName));
    }

    @DisplayName("무입력")
    @Test
    void emptyInputValueTest() {
        //given
        List<String> EmptyInput = List.of("");
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Registry.isValid(EmptyInput));
    }

    @DisplayName("최대치를 초과한 이름 길이")
    @Test
    void maximumLengthTest() {
        //given
        List<String> MaximumLength = Arrays.asList("너무나긴이름", "배달이", "동준이");
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Registry.isValid(MaximumLength));
    }

    @DisplayName("최소치에 미달한 이름 길이")
    @Test
    void minimumLengthTest() {
        //given
        List<String> MinimumLength = Arrays.asList("배달이", "", "동준이");
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Registry.isValid(MinimumLength));
    }

    @DisplayName("최소 인원")
    @Test
    void minimumPlayerTest() {
        //given
        List<String> OnlyPlayer = List.of("배달이");
        //when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Registry.isValid(OnlyPlayer));
    }
}