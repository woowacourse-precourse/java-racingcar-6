package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.generator.DashStringGenerator;
import racingcar.generator.ListLengthGenerator;
import racingcar.generator.WinArrayGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.generator.ListLengthGenerator.count;

class GeneratorTest {
    @Test
    void testInitializeWinArray() {
        WinArrayGenerator winArrayGenerator = new WinArrayGenerator();

        int size = 5; // 특정 크기로 초기화

        winArrayGenerator.initializeWinArray(size);

        int[] win = WinArrayGenerator.win;

        assertNotNull(win); // win 배열이 null이 아닌지 확인

        // win 배열의 크기와 값이 예상한 대로인지 확인
        assertEquals(size, win.length);
        for (int i = 0; i < size; i++) {
            assertEquals(0, win[i]); // 초기 값은 0
        }
    }

    @Test
    void testInitializeWinArrayWithExistingArray() {
        WinArrayGenerator winArrayGenerator = new WinArrayGenerator();

        int size = 5; // 특정 크기로 초기화
        WinArrayGenerator.win = new int[size]; // 이미 초기화된 배열

        winArrayGenerator.initializeWinArray(size);

        int[] win = WinArrayGenerator.win;

        // 기존 배열이 그대로 유지되는지 확인
        assertNotNull(win);
        assertEquals(5, win.length);
    }
    @Test
    void testcount(){
        int size=3;
        List<String> participantes = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };
        assertEquals(size,count(participantes));
    }
    @Test
    void testDashStringGenerator(){
            // 테스트할 대시 문자열 배열
        int[] winArray = {3, 2, 4, 1, 5};

            // 유효한 인덱스를 사용하여 대시 문자열 생성
        String result1 = DashStringGenerator.DashStringGenerator(2, winArray);
        assertEquals("----", result1); // 예상 결과와 비교

            // 유효하지 않은 인덱스를 사용한 경우 빈 문자열 반환
        String result2 = DashStringGenerator.DashStringGenerator(5, winArray);
        assertEquals("", result2);
    }
}