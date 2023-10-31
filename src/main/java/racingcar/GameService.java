package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private List<String> racingCarList = new ArrayList<>();
    private int tryCount;
    private ResultView view = new ResultView();

    private void setUpGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCarList = splitCarNames(Console.readLine());
        System.out.print("시도할 회수는 몇회인가요?");
        tryCount = Integer.parseInt(Console.readLine());
        System.out.println("");
        System.out.println("실행결과");
    }

    public List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
