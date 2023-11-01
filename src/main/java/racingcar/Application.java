package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetName getName = new GetName();
        Racing race = new Racing();
        PrintProgress printProgress = new PrintProgress();
        ComputeFinish computeFinish = new ComputeFinish();
        InitializeResult initializeResult = new InitializeResult();
        List<Integer> result = new ArrayList<>();
        List<String> name = getName.person();

        initializeResult.initialize(name.size(),result);
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int cycle = Integer.parseInt(input);
        for(int i = 0 ; i < cycle ; i ++){
            result = race.racing(name.size(), result);
            printProgress.printResult(name,result);
        }
        computeFinish.printFinish(name,result);
    }
}
