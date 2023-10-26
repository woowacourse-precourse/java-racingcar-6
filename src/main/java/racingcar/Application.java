package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        List<String> carNames = new ArrayList<>();
        List<Integer> steps = new ArrayList<>();
        for (String name : inputNames.split(",")) {
            if(name.equals("") || name.length() > 5) throw new IllegalArgumentException("");
            carNames.add(name);
            steps.add(0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            List<Integer> randomNumbers = createRandomNumbers(carNames.size());
            List<Integer> goingSteps = judge(randomNumbers);
            moveForward(goingSteps, steps);
            printProcess(carNames, steps);
        }

        String winners = String.join(",", pickWinner(carNames, steps));
        System.out.println("최종 우승자 : " + winners);
    }

    //랜덤 숫자 생성
    public static List<Integer> createRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return randomNumbers;
    }

    //상태 update
    public static void moveForward(List<Integer> goingSteps, List<Integer> steps) {
        for (int i = 0; i < steps.size(); i++) {
            steps.set(i, steps.get(i) + goingSteps.get(i));
        }
    }

    //전진 or 정지 판단
    public static List<Integer> judge(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) < 4)
                randomNumbers.set(i, 0);
        }
        return randomNumbers;
    }

    //실행 결과 출력
    public static void printProcess(List<String> carNames, List<Integer> steps) {
        String str = "";
        for (int i = 0; i < carNames.size(); i++) {
            str += carNames.get(i) + " : ";
            for (int j = 0; j < steps.get(i); j++) {
                str += "-";
            }
            str += "\n";
        }
        System.out.println(str);
    }

    public static List<String> pickWinner(List<String> carNames, List<Integer> steps) {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (steps.get(i).equals(Collections.max(steps)))
                winners.add(carNames.get(i));
        }

        return winners;
    }


}
