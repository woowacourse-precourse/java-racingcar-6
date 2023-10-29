package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private final List<String> names;
    private final int attempt;
    private final List<Integer> mileage;
    private final List<String> winners;

    public Car(List<String> names, int attempt) {
        this.names = names;
        this.attempt = attempt;
        this.mileage = new ArrayList<>(Collections.nCopies(names.size(), 0));
        this.winners = new ArrayList<>();
    }

    public void forward () {
        for(int i = 0 ; i < names.size(); i++) {
            int number = Randoms.pickNumberInRange(0,9);
            if(number >= 4) {
                mileage.set(i, mileage.get(i) + 1);
            }
        }
    }

    public int getAttempt() {
        return attempt;
    }

    public List<String> getNames() {
        return names;
    }

    public String getNameByIndex(int idx) {
        return names.get(idx);
    }

    public int getMileageByIndex(int idx) {
        return mileage.get(idx);
    }

    public void initWinners() {
        int maxNum = mileage.stream().max(Comparator.naturalOrder()).orElse(0);
        for (int i = 0; i < mileage.size(); i++) {
            if(mileage.get(i) == maxNum){
                winners.add(names.get(i));
            }
        }
    }

    public int getWinnersSize() {
        return winners.size();
    }

    public String getWinnersByIndex(int idx) {
        return winners.get(idx);
    }
}
