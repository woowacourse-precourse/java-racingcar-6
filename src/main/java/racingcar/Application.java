package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String[] carList = InputView.inputParticipants();

        System.out.println("시도할 회수는 몇회인가요");
        int count = Integer.parseInt(readLine());

        HashMap<String, String> participants = new HashMap<>();
        for (String car : carList) participants.put(car, "");

        while (count > 0) {
            for (String car : carList) {
                int i = Randoms.pickNumberInRange(0, 9);
                if (i >= 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String s = participants.get(car);
                    stringBuilder.append(s).append("-");
                    String string = stringBuilder.toString();
                    participants.put(car, string);
                }
            }
            OutputView.showEachRoundResultOf(participants);
            count -= 1;
        }

        OutputView.showFinalResultOf(participants);
    }



    public static class OutputView {
        public static void showEachRoundResultOf(HashMap<String, String> participants) {
            for (String car : participants.keySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(car);
                stringBuilder.append(" : ");
                stringBuilder.append(participants.get(car));
                String eachCarResult = stringBuilder.toString();
                System.out.println(eachCarResult);
            }
            System.out.println();
        }

        public static void showFinalResultOf(HashMap<String, String> participants) {
            StringJoiner stringJoiner = new StringJoiner(",");

            Collection<String> values = participants.values();
            Integer max = Collections.max(values.stream().map(h -> h.length()).toList());

            for (String car : participants.keySet()) {
                if (participants.get(car).length() == max) {
                    stringJoiner.add(car);
                }
            }
            System.out.println("최종 우승자 : " + stringJoiner.toString());
        }
    }

    public static class InputView {
        private static String[] inputParticipants() {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String[] carList = readLine().split(",");
            if(Arrays.stream(carList).anyMatch(c -> c.length() > 5))
                throw new IllegalArgumentException();

            return carList;
        }
    }



}
