package racingcar;

import java.util.List;

public class TurnRunner {
    private List<CarRunner> carRunnerList;
    public TurnRunner(List<CarRunner> carRunnerList){
        this.carRunnerList = carRunnerList;
    }
    public void run(){
        for(CarRunner carRunner: carRunnerList){
            carRunner.run();
        }
    }
}
