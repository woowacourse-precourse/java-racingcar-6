package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        ArrayList<String> car = new ArrayList<String>(List.of(input.split(",")));
        ArrayList<Integer> goTime = new ArrayList<Integer>();
        for(int i=0; i< car.size(); i++){
            goTime.add(0);
        }
        Integer runTime = Integer.parseInt(readLine());

        for(int i=0; i<runTime; i++){
            for(int j=0; j< car.size(); j++){
                goTime.set(i,randGo(goTime.get(i)));
            }
        }
    }
    public static Integer randGo(Integer go){
        Integer num = pickNumberInRange(0,9);
        if(num >= 4){
            go ++;
        }
        return go;
    }
    public static void printCar(){

    }
}
