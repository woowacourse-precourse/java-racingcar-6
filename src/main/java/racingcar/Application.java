package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        System.out.println(input);
        String[] car = input.split(",");
        List<String> cars = new ArrayList<>(List.of(car));
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).length()>5){
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 회수는 몇회인가요");
        int numOfAttempt = Integer.parseInt(readLine());
        int [] distanceOfCar = new int [cars.size()];
        Arrays.fill(distanceOfCar,0);
        System.out.println("실행결과");
        while(numOfAttempt>0){
            for(int i=0;i< cars.size();i++){
                if(pickNumberInRange(0,9)>=4){
                    distanceOfCar[i]++;
                }
            }

            for(int i=0;i<cars.size();i++){
                System.out.printf("%s : ",cars.get(i));
                for(int j=0;j<distanceOfCar[i];j++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
            numOfAttempt--;
        }
        int maxDistance = Arrays.stream(distanceOfCar).max().getAsInt();

        List<Integer> winner = new ArrayList<>();

        for(int i=0;i<distanceOfCar.length;i++){
            if(maxDistance == distanceOfCar[i]){
                winner.add(i);
            }
        }

        System.out.print("최종 우승자 : ");

        for(int i=0;i<winner.size();i++){
            System.out.print(cars.get(winner.get(i)));
            if(i>0){
                System.out.print(", "+cars.get(winner.get(i)));
            }
        }


    }
}
