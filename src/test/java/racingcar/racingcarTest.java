package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class racingcarTest {
    @Test
    @DisplayName("자동차 이름 유효성 체크 테스")
    void checkNameValidationTest() {
        String invalidCarName = "pobidd";

        assertThatThrownBy(() -> Application.checkNameValidation(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다. 프로그램을 종료합니다.");
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    public void testPrintWinners() {
        List<String> cars = Arrays.asList("car1", "car2", "car3");
        List<Integer> carsMovedDistance = Arrays.asList(3, 4, 3);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Application.printWinners(cars, carsMovedDistance);
        System.setOut(originalOut);
        String expectedOutput = "최종 우승자 : car2";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("자동차 이동 거리 출력 테스트")
    void printCarMovedDistanceTest() {
        List<Integer> movedDistance = Arrays.asList(3, 4, 5);
        assertThat(Application.printCarMovedDistance(movedDistance, 0)).isEqualTo("---");
        assertThat(Application.printCarMovedDistance(movedDistance, 1)).isEqualTo("----");
        assertThat(Application.printCarMovedDistance(movedDistance, 2)).isEqualTo("-----");
    }

    @Test
    @DisplayName("최대 이동 거리의 인덱스 찾기 테스트")
    void findIndicesOfMaxDistanceTest() {
        List<Integer> distances = Arrays.asList(3, 4, 5, 5);
        List<Integer> expectedIndices = Arrays.asList(2, 3);

        assertThat(Application.findIndicesOfMaxDistance(distances)).isEqualTo(expectedIndices);
    }

}
