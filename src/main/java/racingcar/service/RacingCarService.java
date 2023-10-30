package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarService {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public List<String> InputCarName() {

        inputView.carInput();
        String s1 = Console.readLine();

        List<String> carName = List.of(s1.split(","));
        Set<String> carNameSet = new HashSet<>(carName);

        for (String s : carName) {
            if(s.isEmpty()){
                throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력 해야 합니다.");
            }
        }

        for (String s : carName) {
            if((int)s.charAt(0)==32){
                throw new IllegalArgumentException("첫 글자는 공백으로 시작 할 수 없습니다.");
            }
        }

        for (String s : carName) {
            if (s.length() > 4) {
                throw new IllegalArgumentException("5자 이상의 자동차 이름은 입력 할 수 없습니다.");
            }
        }

        if(carName.size() != carNameSet.size()){
            throw new IllegalArgumentException("자동차 이름이 중복 되었습니다.");
        }

        return carName;
    }

    public int getGameAttemptCount() {
        inputView.roundInput();

        String s = Console.readLine();
        int i = Integer.parseInt(s);

        if(i<1){
            throw new IllegalArgumentException("1보다 작은 수는 입력하실 수 없습니다.");
        }

        return i;
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
