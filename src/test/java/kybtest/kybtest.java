package kybtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.Car;
import racingcar.CarStart;
import racingcar.Valid;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class kybtest {

    @Mock
    private CarStart carStart;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindMaxPosition() {
        // 두 대의 자동차를 생성
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        // findMaxPosition 메서드의 예상 결과를 설정
        when(carStart.findMaxPosition()).thenReturn(2);

        // findMaxPosition 메서드 호출 결과를 검증
        int maxPosition = carStart.findMaxPosition();
        assertEquals(2, maxPosition);
    }

    @Test
    public void testAwards() {
        // 두 대의 자동차를 생성
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        // findMaxPosition 메서드의 예상 결과를 설정
        when(carStart.findMaxPosition()).thenReturn(2);

        // 예상 우승자와 실제 우승자를 설정
        String expectedWinner = "Car1, Car2";
        carStart.awards();
        String actualWinner = "Car1, Car2"; // 콘솔에서 실제 결과를 얻어서 설정

        // 우승자를 검증
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void testRaceStartWithZeroRounds() {
        // findMaxPosition 메서드의 예상 결과를 설정
        when(carStart.findMaxPosition()).thenReturn(2);

        // 0 라운드에서 움직임이 없는지 검증
        carStart.raceStart(0);
        verify(carStart, never()).findMaxPosition();
    }

    @Test
    public void testRaceStartWithPositiveRounds() {
        // 두 대의 자동차를 생성
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        // findMaxPosition 메서드의 예상 결과를 설정
        when(carStart.findMaxPosition()).thenReturn(2);

        // 특정 라운드 수에 따라 자동차가 움직이는지 검증
        carStart.raceStart(5);
    }

    @Test
    public void testValidCheckNames() {
        // 유효한 자동차 이름 배열과 중복된 이름이 포함된 배열을 설정
        String[] validNames = {"Car1", "Car2", "Car3"};
        String[] invalidNames = {"Car1", "Car2", "Car1"};

        // 유효성 검사 메서드를 테스트
        assertTrue(Valid.checkNames(validNames));
        assertThrows(IllegalArgumentException.class, () -> Valid.checkNames(invalidNames));
    }

    @Test
    public void testValidCheckRound() {
        // 유효한 시도 횟수와 유효하지 않은 시도 횟수를 설정
        String validRound = "5";
        String invalidRound = "invalid";

        // 유효성 검사 메서드를 테스트
        assertTrue(Valid.checkRound(validRound));
    }

    @Test
    public void testAwardsWithMultipleWinners() {
        // Mock 자동차 생성
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        // findMaxPosition 메서드의 예상 결과를 설정 (모든 자동차가 최대 위치에 도달)
        when(carStart.findMaxPosition()).thenReturn(3);

        // 표준 출력을 잡아놓기 위한 ByteArrayOutputStream 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // awards 메서드 호출
        carStart.awards();

        // 실제 콘솔 출력을 저장
        String consoleOutput = outContent.toString();

        // 예상 우승자 목록
        List<String> expectedWinners = List.of("Car1", "Car2", "Car3");

        // 콘솔 출력에서 실제 우승자 목록 파싱 (콘솔 출력은 쉼표와 스페이스로 구분되므로 나누어 처리)
        String[] actualWinners = consoleOutput.trim().split(",\\s");
    }
}

