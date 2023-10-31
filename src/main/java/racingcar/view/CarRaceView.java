package racingcar.view;

import java.util.List;

public class CarRaceView {
    public void print(String message) {
        System.out.println(message);
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
