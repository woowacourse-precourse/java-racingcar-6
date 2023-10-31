package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Race {
    private ArrayList<String> carNames;
    private ArrayList<Integer> carGoingCount;

    public void initialize(ArrayList<String> carNames) {
        this.carNames = carNames;
        /*
         * runRace() 에서 set 메서드로 접근하기 위해 실시하는 초기화
         */
        carGoingCount = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            carGoingCount.add(0);
        }
    }

    /*
     * 무작위로 숫자를 자동차 대수만큼 추출해서 4 이상이면 한칸 전진
     */
    public void runRace() {
        ArrayList<Integer> randomNumbersList = new ArrayList<>();
        for (int j = 0; j < carNames.size(); j++) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUMBER, Constants.MAX_RANDOM_NUMBER);
            randomNumbersList.add(randomNumber);
        }
        for (int j = 0; j < randomNumbersList.size(); j++) {
            if (randomNumbersList.get(j) >= Constants.FORWARD_CONDITION) {
                carGoingCount.set(j, carGoingCount.get(j) + 1);
            }
        }
    }

    public String winners() {
        int maxCount = 0;
        for (int i = 0; i < carGoingCount.size(); i++) {
            maxCount = Math.max(maxCount, carGoingCount.get(i));
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < carGoingCount.size(); i++) {
            if (maxCount == carGoingCount.get(i)) {
                joiner.add(carNames.get(i));
            }
        }
        return joiner.toString();
    }

    public ArrayList<Integer> getCarGoingCount() {
        return carGoingCount;
    }

    public ArrayList<String> getCarNames() {
        return carNames;
    }
}