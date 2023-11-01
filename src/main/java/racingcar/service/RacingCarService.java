package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.Exception.RacingCarException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarException exception = new RacingCarException();


    public List<String> InputCarName() {

        inputView.carInput();

        List<String> carName = List.of(Console.readLine().split(","));

        exception.validateCarName(carName);

        return carName;
    }

    public int getGameAttemptCount() {

        inputView.roundInput();

        String count = Console.readLine();

        exception.validateGameCount(count);

        return Integer.parseInt(count);
    }

    public int[] playGame(int num, List<String> carList) {

        int[] move = new int[carList.size()];

        outputView.result();

        IntStream.range(0, num).mapToObj(i ->
                score(carList, move))
                .forEach(score -> result(score, carList));
        return move;
    }

    private int[] score(List<String> name , int[] move){
        IntStream.range(0, name.size()).forEach(i -> {
            int N = Randoms.pickNumberInRange(1, 9);
            if (N > 3) {
                move[i] += 1;
            }
        });
        return move;
    }

    private void result(int[] score, List<String> carList){
        IntStream.range(0, carList.size()).forEach(i -> {
            outputView.carNameOutView(carList.get(i));
            IntStream.range(0, score[i]).forEach(j -> outputView.score());
            outputView.newLine();
        });
        outputView.newLine();
    }

    public void winner(List<String> name, int[] arr) {
        int maxScore = Arrays.stream(arr).max().orElse(0);

        Set<String> winners = IntStream.range(0, name.size())
                .filter(i -> arr[i] == maxScore)
                .mapToObj(name::get)
                .collect(Collectors.toSet());

        outputView.winnerOutView(winners);

    }

}
