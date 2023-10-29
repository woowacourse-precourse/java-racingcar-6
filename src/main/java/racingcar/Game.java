package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
    GameException gameException = new GameException();

    public void playGame() {

        ArrayList<String> carName = InputCarName();
        int round = InputRound();

        System.out.println("실행 결과");
        RandomResult(carName, round);
    }

    private ArrayList<String> InputCarName() {
        ArrayList<String> carName = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputName = Console.readLine().split(",");

        for (int i = 0; i < inputName.length; i++) {
            carName.add(inputName[i]);
            gameException.NameCount(inputName[i]);
        }
        return carName;
    }

    private int InputRound() {
        int inputRound;

        System.out.println("시도할 회수는 몇회인가요?");
        inputRound = Integer.parseInt(Console.readLine());

        return inputRound;
    }

    private void RandomResult(ArrayList<String> carName, int round) {
        int minNumber = 0;
        int maxNumber = 9;

        for (int i = 0; round >= i; i++) { //0depth
            for (int j = 0; carName.size() > j; j++) { //1depth
                int random = Randoms.pickNumberInRange(minNumber, maxNumber);
                if (random >= 4) { //2depth
                    System.out.println(carName.get(j) + ":");
                } else {
                    System.out.println(carName.get(j) + ":");
                }
            }
            System.out.println("");
        }
    }
}
