package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CarValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceGameService {

    public int[] position;
    public int[] carPosition;
    public int positionValue;
    public List<Integer> allPosition = new ArrayList<>();

    public int randomMove() {
        return Randoms.pickNumberInRange(CarValue.CAR_MOVE_MINIMUM_RANGE.getValue(), CarValue.CAR_MOVE_MAXIMUM_RANGE.getValue());
    }

    public void carRace (int carNameListIndex) {
        if(randomMove() > 4) {
            forward(carNameListIndex);
        }
    }

    public int[] getPosition(int carNameListIndex){
        carPosition[carNameListIndex] = position[carNameListIndex];

        return carPosition;
    }

    public List<Integer> getAllPosition() {
        allPosition = Arrays.stream(carPosition)
                .boxed()
                .collect(Collectors.toList());
        return allPosition;
    }

    public void forward(int carNameListIndex) {
        positionValue++;
        position[carNameListIndex] = positionValue;
    }
}
