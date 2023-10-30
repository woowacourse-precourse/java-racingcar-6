package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private static int count;
    private static List<Car> racingCars;
    private static Map<Car, Integer> carsPosition = new HashMap<Car, Integer>();
    public Racing(List<Car> racingCars){
        this.racingCars = racingCars;
        for(Car car : racingCars){
            carsPosition.put(car,0);
        }
    }
    public int askRacingCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        System.out.println();
        return count;
    }
    public static void applyPosition(Car racingCar){
        if(racingCar.tryMove()){
            int position = carsPosition.get(racingCar);
            carsPosition.put(racingCar, ++position);
        }
    }
    public static void printPosition(Car racingCar){
        System.out.printf("%s : ", racingCar.announceName());
        for(int i=0; i<carsPosition.get(racingCar); i++){
            System.out.print('-');
        }
        System.out.println();
    }
    public static void reportRacing(){
        for(Car racingCar : racingCars){
            applyPosition(racingCar);
            printPosition(racingCar);
        }
    }
    public static void announceWinner(){

    }
    public void doOneGame(){
        askRacingCount();
        System.out.println("실행 결과");
        for(int i=0; i<count; i++){
            reportRacing();
            System.out.println();
        }
    }
}
