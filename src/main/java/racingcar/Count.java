package racingcar;

import camp.nextstep.edu.missionutils.Console;

import racingcar.constants.Constants;
import racingcar.validation.Validation;

public class Count {

    int val;

    private int strToInt(String s){
        int lenS = s.length();

        if (lenS > 1) {
            char c = s.charAt(lenS - 1);
            return (strToInt(s.substring(0, lenS - 1)) * 10
                    + (c - '0'));
        }
        return s.charAt(0) - '0';
    }

    private int initCount(){
        System.out.println(Constants.countStr);
        String count = Console.readLine();
        Validation.validCount(count);

        return strToInt(count);
    }

    Count(){
        this.val = initCount();
    }
}
