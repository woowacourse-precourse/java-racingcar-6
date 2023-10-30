package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> participants = new ArrayList<>();

    public void createCar(List<String> cars){
        for(String car : cars){
            addParticipant(new Car(car, 0));
        }
    }
    
    public void addParticipant(Car car) {
        participants.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

}
