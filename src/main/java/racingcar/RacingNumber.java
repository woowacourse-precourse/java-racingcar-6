package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class RacingNumber {
    private String racingNum;

    RacingNumber(){
        this.racingNum = "";
    }

    public void setRacingNum(){
        this.racingNum = Console.readLine();
    }

    public boolean isPositiveInteger(){
        return this.racingNum.matches("\\d+");
    }

    public Integer getRacingNum(){
        return Integer.parseInt(this.racingNum);
    }
}
