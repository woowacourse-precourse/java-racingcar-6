package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Race {
    public static Integer numberOfGameRound(){
        System.out.println("시도할 횟수는 몇회인가요?");
        Integer countOfGame = Integer.valueOf(Console.readLine());
        return countOfGame;
    }

}
