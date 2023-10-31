package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

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
        if(count<=0){
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
        int first=0;
        List<String> winners = new ArrayList<>();
        for(Car racingCar : racingCars){
            if(carsPosition.get(racingCar)==first){
                winners.add(racingCar.announceName());
            }
            if(carsPosition.get(racingCar)>first){
                first = carsPosition.get(racingCar);
                winners.clear();
                winners.add(racingCar.announceName());
            }
        }
        if(winners.size()>1){
            System.out.print("최종 우승자 : " + String.join(",", winners));
            return;
        }
        System.out.print("최종 우승자 : " + winners.get(0));
    }
    public void doOneGame(){
        askRacingCount();
        System.out.println("실행 결과");
        for(int i=0; i<count; i++){
            reportRacing();
            System.out.println();
        }
        announceWinner();
    }
}
