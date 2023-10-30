package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.utils.Random;

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

    public Car(List<String> names, int attempt, List<Integer> mileage) {
        this.names = names;
        this.attempt = attempt;
        this.mileage = mileage;
        this.winners = new ArrayList<>();
    }


    public void forward () {
        for(int i = 0 ; i < names.size(); i++) {
            int random = Random.generate();
            setMileage(random, i);
        }
    }

    public void setMileage(int random, int i) {
        boolean isSatisfied = Random.isConditionsAdvancementMet(random);
        if(isSatisfied) {
            mileage.set(i, mileage.get(i) + 1);
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

    public List<Integer> getMileage() {
        return mileage;
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
