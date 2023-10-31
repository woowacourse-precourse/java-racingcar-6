package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Game {
    private static ArrayList<Car> cars;
    private static ArrayList<String> winners;
    private Integer gameRound;

    public void play() {
        readyGame();
        startGame();
        endGame();
    }

    public void readyGame() {
        String inputCarName = InputView.inputCarName();
        cars = createCars(inputCarName);
        gameRound = Integer.parseInt(InputView.inputGameRound());
        System.out.println();
    }

    public void startGame() {
        ResultView.printResult();
        while (gameRound-->0) {
            for(Car car : cars) {
                car.move();
                car.printMove();
            }
            System.out.println();
        }
    }

    public void endGame() {
        ResultView.printWinners();
        findWinner();
        printWinner();
    }

    public ArrayList<Car> createCars(String input) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        return InputView.inputCars(carNames);
    }

    public void printWinner(){
        System.out.println(String.join(", ", winners));
    }
    public void findWinner(){
        winners = new ArrayList<>();
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car2.getDistance() - car1.getDistance();
            }
        });

        int longDistance = cars.get(0).getDistance();
        for(Car car : cars){
            if(car.getDistance() == longDistance) winners.add(car.getName());
            else break;
        }
    }
}
