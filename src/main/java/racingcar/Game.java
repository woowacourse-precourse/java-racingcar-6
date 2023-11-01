package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static constant.ConstantText.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> carList = new ArrayList<>();
    int round;

    public void run(){
        try {
            makeCarList();
            inputRound();
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        play();
        printChampion(getChampion());
    }

    private void makeCarList() {
        System.out.println(inputCar);
        String[] cars = Console.readLine().split(",");
        for(String car : cars) {
            if(car.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            Car newCar = new Car(car);
            carList.add(newCar);
        }
    }

    private void inputRound() {
        System.out.println(inputTryingNumber);
        String roundNumber = Console.readLine();
        for(int i = 0; i < roundNumber.length(); i++) {
            if(roundNumber.charAt(i) < '0' || roundNumber.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        round = Integer.parseInt(roundNumber);
    }

    private void play() {
        System.out.println("실행결과");
        for(int i = 0; i < round; i++) {
            playOnce();
            System.out.println();
        }
    }

    private void playOnce() {
        for(Car car : carList) {
            car.goOrStop();
        }
    }

    private List<String> getChampion() {
        int maxDistance = 0;
        List<String> championName = new ArrayList<>();
        for (Car car : carList) {
            if(car.getDistance() == maxDistance){
                championName.add(car.getName());
            }
            if(car.getDistance() > maxDistance){
                maxDistance = car.getDistance();
                championName.clear();
                championName.add(car.getName());
            }
        }
        return championName;
    }

    private void printChampion(List<String> championName){
        System.out.print("최종 우승자 : ");
        int size = championName.size();
        for (int i = 0; i < size; i++) {
            System.out.print(championName.get(i));
            if(i < size - 1)
                System.out.print(", ");
        }
    }
}
