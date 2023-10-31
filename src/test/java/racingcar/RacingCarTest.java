package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomGenerator;

public class RacingCarTest {

    private RacingCar racingCar;
    // System.out 값을 테스트할 객체
    private OutputStream output;

    @BeforeEach
    public void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    public void run_메서드_테스트() {
        // Given: 랜덤 객체 생성 객체의 반환 값을 4로 고정
        RandomGenerator randoms = mock(RandomGenerator.class);
        when(randoms.randomNumberInRange(0, 9)).thenReturn(4);

        // test1 플레이어는 항상 전진하도록 설정
        Player player1 = new Player("test1");
        player1.setRandomGenerator(randoms);
        
        // test2 플레이어는 전진하거나 멈출 수 있음
        Player player2 = new Player("test2");

        // RacingCar 객체 초기 설정
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        racingCar = new RacingCar(playerList);

        // When: Player 객체 run 매서드 5회 실행
        final int N = 5;
        for (int i = 0; i < 5; i++) {
            racingCar.run();
        }

        // Then: 최고 전진 수의 예상 값은 항상 전진하는 test1 플레이어에 의해 5
        assertEquals(5, racingCar.getMaxCount());
    }

    @Test
    public void printWinner_메서드_최종_우승자_1명() {
        // Given: 랜덤 객체 생성 객체의 반환 값을 4로 고정
        // test1 플레이어는 항상 전진하도록 설정
        RandomGenerator randomsRun = mock(RandomGenerator.class);
        when(randomsRun.randomNumberInRange(0, 9)).thenReturn(4);
        
        Player player1 = new Player("test1");
        player1.setRandomGenerator(randomsRun);

        // test2 플레이어는 항상 멈추도록 설정
        RandomGenerator randomsStop = mock(RandomGenerator.class);
        when(randomsStop.randomNumberInRange(0, 9)).thenReturn(3);

        Player player2 = new Player("test2");
        player2.setRandomGenerator(randomsStop);

        // RacingCar 객체 초기 설정
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        racingCar = new RacingCar(playerList);

        // 최종 우승자 예상 결과값
        StringBuilder expected = new StringBuilder();
        expected.append("최종 우승자 : test1");

        System.setOut(new PrintStream(output));

        // When: Player 객체 run 매서드 5회 실행
        final int N = 5;
        for (int i = 0; i < 5; i++) {
            racingCar.run();
        }

        racingCar.printWinner();

        // Then: 최고 전진 수의 예상 값은 항상 전진하는 test1 플레이어에 의해 5
        assertTrue(output.toString().trim().contains(expected));
    }

    @Test
    public void printWinner_메서드_최종_우승자_여러명() {
        // Given: 랜덤 객체 생성 객체의 반환 값을 4로 고정
        // test1 플레이어는 항상 전진하도록 설정
        RandomGenerator randomsRun = mock(RandomGenerator.class);
        when(randomsRun.randomNumberInRange(0, 9)).thenReturn(4);

        Player player1 = new Player("test1");
        player1.setRandomGenerator(randomsRun);

        // test2 플레이어는 항상 전진하도록 설정
        RandomGenerator randomsStop = mock(RandomGenerator.class);
        when(randomsStop.randomNumberInRange(0, 9)).thenReturn(4);

        Player player2 = new Player("test2");
        player2.setRandomGenerator(randomsStop);

        // RacingCar 객체 초기 설정
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        racingCar = new RacingCar(playerList);

        // 최종 우승자 예상 결과값
        StringBuilder expected = new StringBuilder();
        expected.append("최종 우승자 : test1, test2");

        System.setOut(new PrintStream(output));

        // When: Player 객체 run 매서드 5회 실행
        final int N = 5;
        for (int i = 0; i < 5; i++) {
            racingCar.run();
        }

        racingCar.printWinner();

        // Then: 최고 전진 수의 예상 값은 항상 전진하는 test1 플레이어에 의해 5
        assertTrue(output.toString().trim().contains(expected));
    }
}
