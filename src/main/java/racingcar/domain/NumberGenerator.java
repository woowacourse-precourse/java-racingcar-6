package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int goChance(){
        String chance = Console.readLine();
        return Integer.parseInt(chance);
    }

    public int createRandomNumbers(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }
}
