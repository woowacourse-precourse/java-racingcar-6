package racingcar;
import java.util.*;

public class Application {
    public static class Car{
        private final String name;
        private int position = 0;
        public Car(String name){
            this.name = name;
        }

        public void tryMove(int randomNumber){
            if(randomNumber>=4){
                this.position++;
            }
        }

        public int getPosition(){
            return this.position;
        }
        public String getName(){
            return this.name;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List <Car> makeCars(){

        List<Car> cars = new ArrayList<>();

        return cars;
    }

    public static int getAtteptsNum(){
        int attemptsNum = 0;

        return attemptsNum;
    }

    public static void runningRace(List<Car> cars, int attemptsNum){

    }

    public static void printRoundResult(Car car){

    }

    public static List<Car> getWinners(List<Car> cars){
        List<Car> winners = new ArrayList<>();

        return winners;
    }

    public static int getMaxPosition(List<Car> cars){
        int maxPosition = 0;

        return maxPosition;
    }

    public static void printWinners(List<Car> winners){

    }
}
