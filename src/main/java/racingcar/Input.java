package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private static int n;
    private static String carGroup;
    public static List<String> carNames = new ArrayList<>();

    public Input() {
    }

    public static void inputN() {
        try {
            n = Integer.parseInt(Console.readLine());
            if(n <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int getN() {
        return n;
    }

    public void inputCarNames() {
        carGroup = Console.readLine();
        //쉼표 포함해서 다 받음

        carNames = List.of(carGroup.split(","));
        //carNames 에 분할, size() 구해
        //그 전 기록이 남아있을 확률은 없나? -> 그전 배열이 더 길어서 생기는 문제
    }

    public static String getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(String carGroup) {
        this.carGroup = carGroup;
    }
}
