package racingcar.generator;

import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class WinArrayGenerator {
    // 전역 배열로 선언
    public static int[] win;

    public int[] initializeWinArray(int size) {
        win = new int[size];
        for (int i = 0; i < size; i++) {
            win[i] = 0;
        }
        return win;
    }
}