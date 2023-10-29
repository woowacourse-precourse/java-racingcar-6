package game;

import car.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Car> participants;
    public int frequency;

    public Game(String participants, String frequency) {
        this.participants = stringToCarList(participants);
        this.frequency = stringToInt(frequency);
    }

    public void start(){
        int maxDistanceCar = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < frequency; i++){
            moveCarsForward(participants);

            for (Car participant : participants) {
                System.out.println(participant.getName() + " : " + "-".repeat(participant.getDistance()));
            }
            System.out.println();
        }

        for (Car participant : participants) {
            if (participant.getDistance() >= maxDistanceCar){
                winners.add(participant.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void moveCarsForward(List<Car> participants) {
        for (Car car : participants) {
            car.movingForward();
        }
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

    public int stringToInt(String data) {
        return Integer.parseInt(data);
    }

}
