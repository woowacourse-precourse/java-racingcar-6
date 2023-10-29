package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputInterface {

    String[] getNames() {
        String input = Console.readLine();
        if("".equals(input))
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        return input.split(",");
    }

    int getTrial(){
        String input = Console.readLine();
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("유효한 숫자 값이 아닙니다.");
        }
    }

    void close(){
        Console.close();
    }


}
