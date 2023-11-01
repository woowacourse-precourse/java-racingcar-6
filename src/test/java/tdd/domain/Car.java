package tdd.domain;

import java.util.ArrayList;
import java.util.List;
import tdd.observer.Observer;
import tdd.observer.Subject;

public class Car implements Subject {
    // 이후 확장성을 위해 옵저버를 리스트로 관리
    private final List<Observer> subscribers = new ArrayList<>();
    private final String name;
    private int moved = 0;

    public Car(String name) {
        this.name = name;
    }

    //TODO : 메인 코드로 옮길 때 인자 변경
    public void moveCar(int randomNumber) {
        if(randomNumber >= 4) {
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

    public List<Observer> getSubscribers() {
        return subscribers;
    }

    @Override
    public void addObserver(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        subscribers.remove(o);
    }

    //TODO : 메인 코드로 옮길 때 notifyObservers() 삭제
    @Override
    public void notifyObservers() {
        for (Observer o : subscribers) {
            o.display(this);
        }
    }
}
