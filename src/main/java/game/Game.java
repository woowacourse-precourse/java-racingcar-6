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
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < frequency; i++){
            moveCarsForward(participants);
            printCarsDistance(participants);
        }

        int maxDistance = getMaxDistance(participants);

        for (Car participant : participants) {
            if (participant.getDistance() >= maxDistance){
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

    public void printCarsDistance(List<Car> participants) {
        for (Car car : participants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public int getMaxDistance(List<Car> participants) {
        int maxDistance = 0;

        for (Car car : participants) {
            int distance = car.getDistance();
            if (distance > maxDistance){
                maxDistance = distance;
            }
        }
        return maxDistance;
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
