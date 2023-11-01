package racingcar.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;

public class ReceiveController {
    public ArrayList<String> carNames() {
        /* Get car names */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        /* Parse input (car names) into Arraylist */
        StringTokenizer st1 = new StringTokenizer(input, ",");
        ArrayList<String> carNames = new ArrayList<String>();
        while(st1.hasMoreTokens()) carNames.add(st1.nextToken());

        return carNames;
    }

    public int moveNum() {
        /* Get number of moves */
        System.out.println("시도할 회수는 몇회인가요?");
        int moves = Integer.parseInt(Console.readLine());

        return moves;
    }
}
