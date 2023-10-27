package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int BOUNDARY_NUMBER = 4;

    public static int times;
    public static List<List<String>> listOfCars;

    public static void main(String[] args) {
        startGame();
        for(int i=0;i<times;i++){
            if(i==0){
                System.out.println("실행 결과");
            }
            printResult();
        }
    }

    public static void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(readLine().split(","));

        listOfCars = new ArrayList<>();
        for(int i=0;i<names.size();i++){
            listOfCars.add(Arrays.asList(names.get(i),""));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.valueOf(readLine());
    }

    public static boolean pickRandomNumber(){
        int number = pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
        if(number>=BOUNDARY_NUMBER){
            return true;
        }
        return false;
    }

    public static void printResult(){
        for(List<String> car : listOfCars){
            if(pickRandomNumber()){
                String location = car.get(1)+"-";
                car.set(1,location);
            }
            System.out.println(car.get(0)+" : "+car.get(1));
        }
        System.out.println("");
    }
}
