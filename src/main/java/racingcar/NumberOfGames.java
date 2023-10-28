package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfGames {
    public int  numOfGames() { //게임 진행 횟수 설정
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return validation(input);
    }
    private int validation(String input){
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
        if (num < 1) {
            throw new IllegalArgumentException("1 이상의 정수를 입력하세요.");
        }
        return num;
    }
}
