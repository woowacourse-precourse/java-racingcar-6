package racingcar.domain;

import java.util.List;

public class Referee {

    public Referee() {
    }

    public String declareWinner(List<Car> carsAfterRace){
        Judgment judgment = new Judgment();
        List<String> winners = judgment.compare(carsAfterRace);
        return String.join(", ",winners);
    }


}
