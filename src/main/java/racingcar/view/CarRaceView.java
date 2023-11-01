package racingcar.view;

import java.util.List;

public class CarRaceView {

    public void printWelcome() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGame() {
        System.out.println("\n실행결과");
    }


    public void printResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public List<String> splitCarNames(String input) {
        String[] carNamesArray = input.split(",");
        validateCarNames(carNamesArray);
        return List.of(carNamesArray);
    }

    private void validateCarNames(String[] carNamesArray) {
        for (String name : carNamesArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 공동 우승자 : " + String.join(", ", winners));
        }
    }
}
