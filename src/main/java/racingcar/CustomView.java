package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CustomView {
    private static final String startAnnouncement = "게임을 시작합니다.";
    private static final String startRoundInput = "시도할 횟수는 몇회 인가요?";
    private static final String startCarInput = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String roundResult = "실행결과";
    private static final String gameResult = "최종 우승자 : ";

    public List<String> strSplit(String input) {
        String[] temp = input.split(",");
        List<String> players = new ArrayList<>();
        for (String tmp : temp) {
            players.add(tmp.trim());
        }
        return players;
    }

    public StringBuilder intToStr(int count) {
        StringBuilder bar = new StringBuilder();
        bar.append("-".repeat(Math.max(0, count)));
        return bar;
    }

    public void printStart() {
        System.out.println(startAnnouncement);
        System.out.println(startCarInput);
    }

    public void printStartRound() {
        System.out.println(startRoundInput);
    }

    public void printRoundResult() {
        System.out.println(roundResult);
    }

    public void printEachRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + intToStr(car.getCount()));
        }
        System.out.println();
        System.out.println();
    }

    public void printGameResult(List<String> winners) {
        System.out.print(gameResult);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i >= winners.size()) {
                System.out.print(", ");
            }
        }
    }

}
