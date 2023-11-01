package model;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static int tryCount;

    /**
     * 가장 많이 움직인 전진 수
     *
     * @param carList 경주한 자동차들의 결과를 담은 List
     * @return 경주한 자동차 중 가장 많이 움직인 전진 수 리턴
     */
    public int getMaxStepCount(List<Car> carList){
        int[] stepCountArray = carList.stream()
                .mapToInt(Car::getStepCount)
                .toArray();

        int maxStepCount = Arrays.stream(stepCountArray)
                .max()
                .orElse(0);
        return maxStepCount;
    }




}

