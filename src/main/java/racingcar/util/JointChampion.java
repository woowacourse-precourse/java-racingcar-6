package racingcar.util;

import java.util.List;

public class JointChampion implements Champion{
    @Override
    public void finalWinnerOutput(List<String> winnerInformation) {
        System.out.println("두명이상우승");
        System.out.println(winnerInformation);


    }
}
