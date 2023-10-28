package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

class RandomNumberTest {

    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    public static void beforeAll() {
        randoms = Mockito.mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    void isMovable_4_이상이면_참() {
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(7);

        RandomNumber randomNumber = RandomNumber.createRandomNumber();

        assertTrue(randomNumber.isMovable());
    }

    @Test
    void isMovable_4_미만이면_거짓() {
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(3);

        RandomNumber randomNumber = RandomNumber.createRandomNumber();

        assertFalse(randomNumber.isMovable());
    }

}