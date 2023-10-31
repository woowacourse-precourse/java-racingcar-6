package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

class RacingCar{
    private final String name;
    private int distance = 0;
    RacingCar(String name){
        this.name = name;
    }
    int getDistance(){
        return distance;
    }
    String getName(){
        return name;
    }
    int move(){
        int random = Randoms.pickNumberInRange(0,9);
        if(random >= 4) distance++;
        return distance;
    }
    void printDistance(){
        System.out.print(name + " : ");
        int dis = move();
        while(dis > 0){
            System.out.print('-');
            dis--;
        }
        System.out.println();
    }
    int getMax(int [] winner){
        int max = 0;
        for (int i = 0; i < winner.length; i++) {
            if(max < winner[i]){
                max = winner[i];
            }
        }
        return max;
    }
    String getWinner(int max){
        if (distance == max) {
            return name;
            //System.out.println(name);
        }
        return null;
    }

    public static String[] delimete(String string){
        String[] st = string.split(",");
        return st;
    }

}
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        String[] cars = RacingCar.delimete(input);
        exception(cars);
        int length = cars.length;

        RacingCar[] racingCars = new RacingCar[length];


        for (int i = 0; i < cars.length; i++){
            racingCars[i] = new RacingCar(cars[i]);

        }

        System.out.println("시도할 회수는 몇회인가요?");
        int cases = Integer.parseInt(readLine());

        System.out.println("실행 결과");
        while(cases > 0){
            for (RacingCar racingCar : racingCars) {
                racingCar.printDistance();
            }
            System.out.println();
            cases--;
        }


        int max = 0;
        for (int i = 0; i < length; i++) {
            if(max < racingCars[i].getDistance()){
                max = racingCars[i].getDistance();
            }
        }

        ArrayList<String> winner = new ArrayList<>();
        for (int i = 0; i < length;i++){
            if(racingCars[i].getDistance() == max)
                winner.add(racingCars[i].getName());
        }


        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++){
            System.out.print(winner.get(i));
            if(i != winner.size() - 1)
                System.out.print(", ");
        }

    }

    static void exception(String[] input){
        for (int i = 0; i< input.length; i++){
            if(input[i].length() > 5)
                throw new IllegalArgumentException();
        }
    }
}
