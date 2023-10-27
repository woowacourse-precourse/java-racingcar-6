package study;

import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class MockitoTest {
    private static MockedStatic<Randoms> random;

    @BeforeAll
    public static void beforeAll() {
        random = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        random.close();
    }

    @Test
    void 랜덤숫자테스트() {
        random.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(9);
        RandomTest test = new RandomTest();
        test.randomPrint(); // 9
        test.randomPrint(); // 9
        test.randomPrint(); // 9
    }

    @Test
    void 랜덤숫자_여러개_테스트() {
        random.when(() -> Randoms.pickNumberInRange(1, 9))
                .thenReturn(9)
                .thenReturn(1);
        RandomTest test = new RandomTest();
        test.randomPrint(); // 9
        test.randomPrint(); // 1
        test.randomPrint(); // 1
        test.randomPrint(); // 1
    }

    @Test
    void 안되는케이스() {
        // 실제 사용되는 범위와 다르게 적용되면, 원하는 값이 나오지 않게된다.
        random.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(9);

        RandomTest test = new RandomTest();
        test.randomPrint(); // 0
    }

    public static class RandomTest {
        public void randomPrint() {
            int num = Randoms.pickNumberInRange(1, 9);
            System.out.println("num = " + num);
        }
    }
}
