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
    public String carRaceWinner(List<Car> carList) {
        int max = carList.get(0).getProgressNumber();
        String winner = carList.get(0).getName();
        for(int i=1; i<carList.size(); i++) {
            if(carList.get(i).getProgressNumber()>max) {
                max=carList.get(i).getProgressNumber();
                winner = carList.get(i).getName();
            }
            else if (carList.get(i).getProgressNumber() == max){
                winner+=(", "+carList.get(i).getName());
            }
        }
        return winner;
    }
}
