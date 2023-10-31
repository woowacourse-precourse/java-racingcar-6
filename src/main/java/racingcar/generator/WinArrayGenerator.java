package racingcar.generator;

import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class WinArrayGenerator {
    // 전역 배열로 선언
    public static int[] win;

    public static int[] initializeWinArray() {
        List<String> participantes = InputParticipantes();
        win = new int[participantes.size()]; // 전역 배열 초기화
        return win;
    }
}
