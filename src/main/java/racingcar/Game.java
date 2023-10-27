package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Game {
    Car[] cars;
    int roundNumber;
    Map<Car, Integer> positions;
    int winnerPosition;

    public Game(String[] carNames, int roundNumber){
        makeCars(carNames);
        initPosition();
        winnerPosition = 0;
        this.roundNumber = roundNumber;
    }

    public void play(){
        System.out.println("실행 결과");
        for(int round = 0; round < roundNumber; round++){
            playRound();
        }
        printWinner();
    }

    private void initPosition() {
        positions = new HashMap<>();
        for(Car car : cars){
            positions.put(car, 0);
        }
    }

    private void makeCars(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .toArray(Car[]::new);
    }

    public void playRound(){
        for(Car car : cars){
            moveCar(car);
            System.out.println(car.getRoundResult());
        }
        System.out.println();
    }

    private void moveCar(Car car) {
        if(!car.isMove()) {
            return;
        }

        int nextPosition = positions.get(car) + 1;
        positions.put(car, nextPosition);
        if(winnerPosition < nextPosition){
            winnerPosition = nextPosition;
        }
    }

    public void printWinner(){
        String winner = positions.entrySet().stream()
                .filter(entry -> entry.getValue() == winnerPosition)
                .map(Entry::getKey)
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println("최종 우승자 : " + winner);
    }
}
