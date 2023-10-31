package racingcar.domain;

import static racingcar.config.RacingConfig.RANDOM_NUMBER_MAX;
import static racingcar.config.RacingConfig.RANDOM_NUMBER_MIN;
import static racingcar.config.RacingConfig.RANDOM_NUMBER_PASS_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.observer.Observer;
import racingcar.observer.Subject;

public class Car implements Subject {
    // 이후 확장성을 위해 옵저버를 리스트로 관리
    private final List<Observer> subscribers = new ArrayList<>();
    private final String name;
    private int moved = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.getValue(),
                RANDOM_NUMBER_MAX.getValue()) >= RANDOM_NUMBER_PASS_MIN.getValue()) {
            moved++;
        }
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public int getMoved() {
        return moved;
    }

    @Override
    public void addObserver(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : subscribers) {
            o.display(this);
        }
    }
}
