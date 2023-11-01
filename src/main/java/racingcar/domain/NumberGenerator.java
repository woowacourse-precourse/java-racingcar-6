package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int goChance(){
        String chance = Console.readLine();
        validateGameChanceNumbers(chance);
        return Integer.parseInt(chance);
    }

    private void validateGameChanceNumbers(String input){
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new IllegalArgumentException("숫자가 아닌 문자 입력");
        }
    }

    public int createRandomNumbers(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }
}
