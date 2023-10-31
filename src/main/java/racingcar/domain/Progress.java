package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Progress {
    public void onAir(List<String> cars, List<Integer> racingResult) {
        List<String> racingResultHyphen = new ArrayList<>();
        for (int goCount : racingResult) {
            String goCountHyphen = "";
            for (int j = 0; j < goCount; j++) {
                goCountHyphen = goCountHyphen + "-";
            }
            racingResultHyphen.add(goCountHyphen);
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i) + " : " + racingResultHyphen.get(i));
        }
        System.out.println();
    }
}
