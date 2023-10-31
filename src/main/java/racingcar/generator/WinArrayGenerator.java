package racingcar.generator;

public class WinArrayGenerator {
    // 전역 배열로 선언
    public static int[] win;

    public void initializeWinArray(int size) {
        if(win==null){
            win = new int[size];
            for (int i = 0; i < size; i++) {
                win[i] = 0;
            }
        }
    }
}