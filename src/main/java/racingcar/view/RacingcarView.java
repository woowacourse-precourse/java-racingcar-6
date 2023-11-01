package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingcarView {

    public String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void startRacing() {
        System.out.println("실행 결과");
    }

    public void racingResult(String name, int distance) {
        System.out.print(name + " : ");

        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void announceChampion(List<String> championName) {
        System.out.print("최종 우승자 : ");
        int count = 1;

        for (String champion : championName) {
            System.out.print(champion);

            if (count < championName.size()) {
                System.out.print(", ");
            }
            count++;
        }
    }
}
