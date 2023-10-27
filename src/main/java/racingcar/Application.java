package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int times;
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(readLine().split(","));

        List<List<String>> namesOfCars = new ArrayList<>();
        for(int i=0;i<names.size();i++){
            namesOfCars.add(Arrays.asList(names.get(i),""));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.valueOf(readLine());
    }
}
