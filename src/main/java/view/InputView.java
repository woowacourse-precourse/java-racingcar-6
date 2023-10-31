package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    public ArrayList registerRace(){
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        ArrayList<String> cars = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        return cars;
    }

    public int createRace(){
        System.out.printf("시도할 회수는 몇회인가요?\n");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }
}
