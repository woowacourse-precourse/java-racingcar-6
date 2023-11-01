package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.domain.RandomGenerator;

public class PlayerTest {

    private Player player;
    // System.out 값을 테스트할 객체
    private OutputStream output;

    @BeforeEach
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    public void run_메서드_4이상일_때_전진() {
        // Given: 랜덤 객체 생성 객체의 반환 값을 4로 고정
        RandomGenerator randoms = mock(RandomGenerator.class);
        when(randoms.randomNumberInRange(0, 9)).thenReturn(4);

        // When: Player 객체 run 매서드 실행
        player = new Player("test", randoms);
        player.run();

        // Then: runCount 값이 증가하는지 확인
        assertEquals(1, player.getRunCount());
    }

    @Test
    public void run_메서드_4미만일_때_정지() {
        // Given: 랜덤 객체 생성 객체의 반환 값을 3으로 고정
        RandomGenerator randoms = mock(RandomGenerator.class);
        when(randoms.randomNumberInRange(0, 9)).thenReturn(3);

        // When: Player 객체 run 매서드 실행
        player = new Player("test", randoms);
        player.run();

        // Then: runCount 값이 증가하지 않는지 확인
        assertEquals(0, player.getRunCount());
    }

    @Test
    public void print_메서드_테스트_3회_전진() {
        // Given
        // runCount = 3 설정
        player = new Player("test", new RandomGenerator());
        player.setRunCount(3);

        // runCount가 3일 때, 예상 결과값
        StringBuilder expected = new StringBuilder();
        expected.append("test : ---");

        System.setOut(new PrintStream(output));

        // When: print 실행
        player.print();

        assertTrue(output.toString().trim().contains(expected));
    }
}
