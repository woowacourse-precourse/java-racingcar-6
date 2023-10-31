package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int MIN_RANDOM_VALUE = 4;
    public static void main(String[] args) {

        HashMap<String, String> participants = InputView.inputParticipants();
        int round = InputView.inputRound();

        startRace(participants, round);
        OutputView.showFinalResultOf(participants);
    }

    private static void startRace(HashMap<String, String> participants, int round) {
        while (isRoundLeft(round)) {
            for (String car : participants.keySet()) {
                int i = Randoms.pickNumberInRange(0, 9);
                if (i >= MIN_RANDOM_VALUE) {
                    plusOneStep(participants, car);
                }
            }
            OutputView.showEachRoundResultOf(participants);
            round -= 1;
        }
    }

    private static void plusOneStep(HashMap<String, String> participants, String car) {
        String beforeRecord = participants.get(car);

        StringBuilder st = new StringBuilder();
        st.append(beforeRecord).append("-");

        participants.put(car, st.toString());
    }

    private static HashMap<String, String> convertStringToHashMap(String[] carList) {
        HashMap<String, String> participants = new HashMap<>();
        for (String car : carList)
            participants.put(car, "");
        return participants;
    }

    public static boolean isRoundLeft(int round) {
        return round > 0;
    }

    public static class OutputView {
        public static void showEachRoundResultOf(HashMap<String, String> participants) {
            for (String car : participants.keySet()) {
                String recordOfCar = participants.get(car);

                StringBuilder sb = new StringBuilder();
                sb.append(car).append(" : ").append(recordOfCar);

                String eachResultOfCar = sb.toString();
                System.out.println(eachResultOfCar);
            }
            System.out.println();
        }

        public static void showFinalResultOf(HashMap<String, String> participants) {


            Collection<String> values = participants.values();
            Integer max = Collections.max(values.stream().map(h -> h.length()).toList());

            String finalWinner = getFinalWinner(participants, max);
            System.out.println("최종 우승자 : " + finalWinner);
        }

        private static String getFinalWinner(HashMap<String, String> participants, Integer max) {
            StringJoiner stringJoiner = new StringJoiner(",");
            for (String car : participants.keySet()) {
                if (participants.get(car).length() == max) {
                    stringJoiner.add(car);
                }
            }
            return stringJoiner.toString();
        }
    }

    public static class InputView {
        private static final int MAX_LENGTH = 4;
        private static HashMap<String, String> inputParticipants() {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String[] carList = readLine().split(",");
            if(Arrays.stream(carList).anyMatch(c -> c.length() > MAX_LENGTH))
                throw new IllegalArgumentException();

            HashMap<String, String> participants = convertStringToHashMap(carList);

            return participants;
        }
        private static int inputRound() {
            System.out.println("시도할 회수는 몇회인가요");
            int count = Integer.parseInt(readLine());
            return count;
        }
    }
}
