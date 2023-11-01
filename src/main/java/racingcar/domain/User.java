package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int totalGameCount;
    public String inputTryCount(){
        return Console.readLine();
    }

    public String inputCarName(){
        return Console.readLine();
    }

    public void updateTotalGameCount(int count){
        this.totalGameCount = count;
    }

    public int getTotalGameCount() {
        return totalGameCount;
    }
}
