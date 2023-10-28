package game;

import car.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Car> participants;
    public int frequency;

    public Game(String participants, String frequency) {
        this.participants = stringToCarList(participants);
    }

    public List<Car> stringToCarList(String data) {
        List<Car> res = new ArrayList<>();
        String[] splitData = data.split(",");

        for(String name: splitData) {
            Car car = new Car(name);
            res.add(car);
        }
        return res;
    }
}
