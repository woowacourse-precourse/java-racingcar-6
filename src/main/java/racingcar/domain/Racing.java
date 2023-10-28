package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;


public class Racing {
    //필드
    List<String> carNames;
    List<Integer> carPoints = new ArrayList<>();
    List<String> winner;
    //메소드

    public Racing() {

    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        carNames = Arrays.asList(Console.readLine().split(","));
        checkNameLength(carNames);

        return carNames;
    }

    private int checkNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException("each racing car's name must be shorter than 6");
            }
        }
        return carNames.size();
    }

    private int getRoundCount() {
        System.out.println("시도할 회수를 입력하세요");
        try {
            return parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); //예외정보 출력 (호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 콘솔화면에 출력)
            throw e;
        }

    }

    public int playRound() {
        getCarNames();
        initCarPoints();
        int roundCount = getRoundCount();
        for (int i = 0; i < roundCount; i++) {
            getRanNUM();
            displayResult();
        }
        displayWinner();
        return 0;
    }

    private List<Integer> initCarPoints() {
        for (int i = 0; i < carNames.size(); i++) {
            carPoints.add(0);
        }
        return carPoints;
    }

    private List<Integer> getRanNUM() {
        for (int i = 0; i < carNames.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                int var = carPoints.get(i);
                var++;
                carPoints.set(i, var);
            }
        }
        return carPoints;
    }

    private int displayResult() {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            for (int j = 0; j < carPoints.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
        return 0;
    }

    private List<String> displayWinner() {
        checkWinnerNum();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i+1 < winner.size()){
                System.out.print(", ");
            }
        }
        return winner;
    }

    private List<String> checkWinnerNum() {
        winner = new ArrayList<String>();
        int maxPoint = Collections.max(carPoints);
        for (int i = 0; i < carNames.size(); i++) {
            if (carPoints.get(i) == maxPoint) {
                winner.add(carNames.get(i));
            }
        }
        return winner;
    }

}
