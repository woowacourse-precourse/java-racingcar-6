package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    public RacingScoreBoard carName() {
        System.out.println(Message.START);
        String input = Console.readLine();
        return new RacingScoreBoard(input);
    }

    public int moveNumber() {
        System.out.println(Message.COUNT);
        String input = Console.readLine();
        //예외 처리 클래스 추가
        int moveNumber = Integer.parseInt(input);
        return moveNumber;
    }

}
