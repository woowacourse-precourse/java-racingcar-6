package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public Integer numberOfMoves(){
        System.out.println("시도할 횟수는 몇회인가요?");
        String inputValue = Console.readLine();

        if(inputValue.length()==0){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        int num = Integer.parseInt(inputValue);



        return num;
    }


}
