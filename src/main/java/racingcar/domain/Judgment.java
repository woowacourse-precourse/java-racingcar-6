package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgment {
    public Judgment() {
    }

    public void horseMove(List<Integer> randomNumber, List<Car> carList) { //Application에서 호출하도록 변경
        NumberGenerator numberGenerator = new NumberGenerator();
        Progress progress = new Progress();
        int i=0;
        for (int number : randomNumber) {
            if (number>=4){
                carList.get(i).addProgress();
                carList.get(i).addViewProgress();
            }
            progress.moveProgressPrint(carList.get(i));
            i++;
        }

    }

}
