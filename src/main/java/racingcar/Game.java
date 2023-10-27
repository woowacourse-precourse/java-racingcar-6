package racingcar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Game {
    Message message = new Message();
    private static ArrayList<Car> cars;
    private Integer gameRound;

    public void play() {
        readyGame();
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

    }

    public void endGame() {

    }

    public void printCarMove(){

    }

    public void printWinner(){

    }
    public ArrayList<String> findWinner(){
        ArrayList<String> winners = new ArrayList<>();
        return winners;
    }
}
