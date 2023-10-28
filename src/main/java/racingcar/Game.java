package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Game {
    Message message = new Message();
    private static ArrayList<Car> cars;
    private static ArrayList<String> winners;
    private Integer gameRound;

    public void play() {
        readyGame();
        startGame();
        endGame();
    }

    public void readyGame() {
        String inputCarName = message.inputCarName();
        gameRound = Integer.parseInt(message.inputGameRound());
        cars = createCars(inputCarName);
    }

    public ArrayList<Car> createCars(String input) {
        ArrayList<Car> cars = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()){
            cars.add(new Car(st.nextToken(), 0));
        }
        return cars;
    }

    public void startGame() {
        while (gameRound-->0) {
            message.printResult();
            for(Car car : cars) {
                car.move();
                car.printMove();
            }
            System.out.println();
        }
    }

    public void endGame() {
        message.printWinners();
        findWinner();
        printWinner();
    }

    public void printCarMove(){
        for(Car car : cars) {
            car.printMove();
        }
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
