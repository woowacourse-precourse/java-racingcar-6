package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"ab", "cde", "fghi"})
    public void 중간_길이_이름_테스트(String validName) {
        // When
        Name name = Name.from(validName);

        // Then
        assertEquals(validName, name.toString());
    }

    @Test
    public void 최소_길이_이름_테스트() {
        // Given
        String validName = "a";

        // When
        Name name = Name.from(validName);

        // Then
        assertEquals(validName, name.toString());
    }

    @Test
    public void 최대_길이_이름_테스트() {
        // Given
        String validName = "David";

        // When
        Name name = Name.from(validName);

        // Then
        assertEquals(validName, name.toString());
    }

    @Test
    public void 잘못된_짧은_이름_예외_처리() {
        // Given
        String invalidName = "";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> Name.from(invalidName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Adolph", "Wolverine", "Christopher"}) // 여러 정책에 대해 테스트
    public void 잘못된_긴_이름_예외_처리(String invalidName) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> Name.from(invalidName));
    }
}