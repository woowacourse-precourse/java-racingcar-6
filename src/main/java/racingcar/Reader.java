package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Reader {
        public List<String> readInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> members = new ArrayList<>();
        String input = Console.readLine();
        for(String SplitInput : input.split(",")){
            if(SplitInput.length() > 5){
                throw new IllegalArgumentException("자동차의 이름이 5글자가 넘었습니다.");
            }
            members.add(SplitInput);
        }
        return members;
    }
    public int readNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력 되었습니다.");
        }
    }
}
