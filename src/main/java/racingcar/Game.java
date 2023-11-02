package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
    GameException gameException = new GameException();

    public void PlayGame() {
        ArrayList<String> carNames = InputCarName();
        int round = InputRound();

        System.out.println("실행 결과");
        PlayRound(carNames, round);
    }

    public ArrayList<String> InputCarName() {
        ArrayList<String> carNames = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputName = Console.readLine().split(",");

        for (int i = 0; i < inputName.length; i++) {
            carNames.add(inputName[i]);
            gameException.NameCount(inputName[i]);
        }
        gameException.NameNull(carNames);
        return carNames;
    }

    public int InputRound() {
        int inputRound;

        System.out.println("시도할 회수는 몇회인가요?");
        inputRound = Integer.parseInt(Console.readLine());
        gameException.ZeroRound(inputRound);

        return inputRound;
    }

    public void PlayRound(ArrayList<String> carNames, int round) {
        int carMax = carNames.size();
        int[] goCounts = new int[carMax];

        for (int i = 0; round > i; i++) { //1depth
            for (int j = 0; carMax > j; j++) { //2depth
                goCounts[j] = GoCount(carNames, goCounts[j], j);
            }
            System.out.println("");
        }
        Winner(carNames, goCounts);
    }

    public int GoCount(ArrayList<String> carNames, int count, int round) {
        int minNumber = 0;
        int maxNumber = 9;

        int random = Randoms.pickNumberInRange(minNumber, maxNumber);
        if (random >= 4) {
            count++;
            ResultText(carNames.get(round), count);
        } else {
            ResultText(carNames.get(round), count);
        }

        return count;
    }

    public void ResultText(String carName, int count) {
        String result = "";

        for (int i = 0; count > i; i++) {
            result += "-";
        }
        System.out.println(carName + " : " + result);
    }
    public void Winner(ArrayList<String> carNames, int[] count) {
        ArrayList<String> winner = new ArrayList<>();

        int winCount = 0;

        for (int i = 0; count.length > i; i++) {
            if (winCount < count[i]) {
                winCount = count[i];
            }
        }

        for (int i = 0; count.length > i; i++) {
            if (winCount == count[i]) {
                winner.add(carNames.get(i));
            }
        }

        if (winner.size() > 1) {
            String allWinner = String.join(",", winner);
            System.out.print("최종 우승자 : " + allWinner);
        } else {
            System.out.print("최종 우승자 : " + winner.get(0));
        }
    }
}
