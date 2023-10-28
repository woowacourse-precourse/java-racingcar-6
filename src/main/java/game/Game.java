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
        // 게임이 시작되면 frequency 만큼 반복문을 돌게된다.
        int maxDistanceCar = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < frequency; i++){
            for (Car car : participants) {
                car.movingForward();
                int distance = car.getDistance();
                if (maxDistanceCar < distance) {
                    maxDistanceCar = distance;
                }
            }

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
