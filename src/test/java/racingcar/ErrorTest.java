package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ErrorTest {
    private Verify verify;

    @BeforeEach
    void setUp() {
        verify = new Verify();
    }

    @Test
    void 차_이름_중복시_에러가_발생한다() {
        String wrongString = "John,lexi,John,kids";
        String[] splitCarNameList = wrongString.split(",", -1);
        IllegalArgumentException illegalException = 
            Assertions.assertThrows(IllegalArgumentException.class,
                () -> verify.checkDuplicateCarName(splitCarNameList));
        Assertions.assertEquals("중복된 이름이 존재합니다.", illegalException.getMessage());
    }
}
