package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        ArrayList<String> car = new ArrayList<String>(List.of(input.split(",")));
        ArrayList<Integer> goTime = new ArrayList<Integer>();
        // 자동차의 전진 횟수
        for(int i=0; i< car.size(); i++){
            goTime.add(0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        Integer runTime = Integer.parseInt(readLine());
        System.out.println();
        System.out.println("실행 결과");
        for(int i=0; i<runTime; i++){
            for(int j=0; j< car.size(); j++){
                goTime.set(i,randGo(goTime.get(i)));
            }
            printCar(car,goTime);
        }
    }
    public static Integer randGo(Integer go){
        Integer num = pickNumberInRange(0,9);
        if(num >= 4){
            go ++;
        }
        return go;
    }
    public static void printCar(ArrayList<String> car, ArrayList<Integer> goTime){
        //모든 종류 한번만 출력하면 됨
        for(int i=0; i<car.size(); i++){
            System.out.print(car.get(i)+": ");
            for(int j=0; j<goTime.get(i); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
