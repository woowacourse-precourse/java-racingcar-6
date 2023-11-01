package racingcar;

import racingcar.IO.Input;
import racingcar.IO.ManageException;
import racingcar.IO.Output;
import racingcar.domain.GameLogic;
import racingcar.domain.Judgement;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        GameLogic gameLogic = new GameLogic();
        Judgement judgement = new Judgement();

        //입력
        String[] names = input.getName(); //자동차 이름 입력
        int times = input.getTimes(); // 시도 횟수 입력

        //결과 저장
        int length = names.length;
        int[] result = new int[length]; // 결과 저장할 어레이 생성


        //레이싱
        System.out.println("\n실행 결과");

        for (int i = 0; i < times; i ++){
            gameLogic.executeGame(names, result);
            output.showResult(names, result);
            System.out.println("\n");
        }

        //우승자 판별
        List<Integer> winners = judgement.findWinner(result);

        output.showWinners(names, winners);

    }
}
