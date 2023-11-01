package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import controller.RandomNumber;
import input.Input;
import output.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        Input input = new Input();
        RandomNumber randomNumber = new RandomNumber();
        outputView.printInputMsg();
        List<String> carList = input.readCarName();
        outputView.printTryNumMsg();
        int n = input.readTryNum();

        int[] location = new int[carList.size()];
        outputView.printResultMsg();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < carList.size(); j++){
                outputView.printCarName(carList.get(j));
                if(randomNumber.randomNumber() >= 4)
                    location[j]++;
                outputView.printRunMsg(location[i]);
            }
        }

        int maxIndex = IntStream.range(0, location.length)
                .reduce((i, j) -> location[i] > location[j] ? i : j)
                .orElse(-1);
        int max = location[maxIndex];
        List<String> winner = new ArrayList<>();
        for(int i = 0; i < location.length; i++){
            if (location[i] == max)
                winner.add(carList.get(i));
        }

        outputView.printWinnerMsg(winner);
    }
}
