package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    private int inputMove;

    public void inputMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        inputMove = Integer.parseInt(Console.readLine());
        System.out.println(inputMove);
    }
}