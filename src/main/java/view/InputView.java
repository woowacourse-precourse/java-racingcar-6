package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    public ArrayList createCar(){
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        return new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
    }

    public int setLaps(){
        System.out.printf("시도할 회수는 몇회인가요?\n");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }
}
