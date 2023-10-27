package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameTest {


    @Test
    void 이름의_길이가_5보다_크면_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CarName("123456"));
    }

    @Test
    void 이름의_길이가_5보다_작으면_정상생성() {
        CarName carName = new CarName("12345");
        Assertions.assertNotNull(carName);
    }

}