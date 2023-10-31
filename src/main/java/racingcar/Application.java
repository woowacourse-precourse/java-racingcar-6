package racingcar;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int gameCnt = Integer.parseInt(Console.readLine());

        String[] carNameArray  = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : carNameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            carNames.add(name);
        }

        List<Integer> carProgress = new ArrayList<>();
        for (int i=0; i<carNames.size(); i++){
            carProgress.add(0);
        }

    }
}
