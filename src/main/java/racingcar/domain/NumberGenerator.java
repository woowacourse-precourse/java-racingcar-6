package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingGame;

public class NumberGenerator {

    RacingGame racinggame = new RacingGame();

    public void goChance(){
        String chance = Console.readLine();
        validateGameChanceNumbers(chance);
        racinggame.setGameChance(Integer.parseInt(chance));
    }

    private void validateGameChanceNumbers(String input){
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new IllegalArgumentException("숫자가 아닌 문자 입력");
        }
    }

    public void createRandomNumbers(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        racinggame.setrandomNumber(randomNumber);
    }
}
