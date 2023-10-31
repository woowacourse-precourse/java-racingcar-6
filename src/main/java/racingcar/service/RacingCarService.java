package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.Exception.Exception;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Exception exception = new Exception();


    public List<String> InputCarName() {

        inputView.carInput();

        String s1 = Console.readLine();

        List<String> carName = List.of(s1.split(","));
        Set<String> carNameSet = new HashSet<>(carName);

        exception.validateCarName(carName);
        exception.validateDuplicates(carName.size(),carNameSet.size());

        return carName;
    }

    public int getGameAttemptCount() {

        inputView.roundInput();

        String count = Console.readLine();

        exception.validateNonDigitCharacter(count);

        int cnt = Integer.parseInt(count);

        exception.validateMinimumValue(cnt);

        return cnt;
    }

    public int[] playGame(int num, List<String> carList) {

        int[] move = new int[carList.size()];

        outputView.result();
        for (int i = 0; i < num; i++) {

            int[] score = score(carList, move);

            result(score, carList);
        }
        return move;
    }

    private int[] score(List<String> name , int[] move){
        for (int i = 0; i < name.size(); i++) {
            int N = Randoms.pickNumberInRange(1, 9);
            if(N>3){
                move[i] += 1;
            }
        }
        return move;
    }

    private void result(int[] score, List<String> carList){
        for (int i = 0; i < carList.size(); i++) {
            outputView.carNameOutView(carList.get(i));

            for (int j = 0; j < score[i]; j++) {
                outputView.score();
            }
            outputView.newLine();
        }
        outputView.newLine();
    }

    public void winner(List<String> name, int[] arr) {
        Set<String> list;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < name.size(); i++) {
            hashMap.put(name.get(i), arr[i]);
        }
        int max = Collections.max(hashMap.values());

        list = hashMap.values().stream()
                .filter(value -> value >= max)
                .flatMap(value -> hashMap.keySet().stream())
                .filter(s -> hashMap.get(s).equals(max))
                .collect(Collectors.toSet());

        outputView.winnerOutView(list);

    }

}
