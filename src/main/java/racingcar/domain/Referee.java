package racingcar.domain;

import java.util.List;

public class Referee{

    public List<String> determineWinners(Cars cars){
        return cars.getMaxForwardCountCarNames();
    }

    public void announceWinners(List<String> winners){
        String announcement = "최종 우승자 : " + String.join(", ",winners);
        System.out.println(announcement);
    }

}
