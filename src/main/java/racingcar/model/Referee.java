package racingcar.model;

import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Referee {
    private int[] distanceCount;
    private int[] maxIndexArray;

    public Referee(int[] distanceCount) {
        this.distanceCount = distanceCount;
        this.maxIndexArray = getIndexOfMaxDistanceOfCars();
    }

    public int[] getIndexOfMaxDistanceOfCars() {
        int max = Arrays.stream(distanceCount).max().getAsInt();
        int[] maxIndexArray = IntStream.range(0, distanceCount.length).filter(i -> distanceCount[i] == max).toArray();

        return maxIndexArray;
    }

}
