    package racingcar;

    import camp.nextstep.edu.missionutils.Randoms;
    import java.util.*;

    public class Game { //게임의 전체 진행을 맡고 있는 클래스
        private static IO io;
        private static Sorting sorting;
        private static CheckForm checkForm;
        private List<String> RunnerMap = new ArrayList<>();
        private LinkedHashMap<String, String> GameInfoMap = new LinkedHashMap<>();
        //순서가 보장되고, key-value를 이용해야 했기에 해당 자료구조를 선택했습니다.

        public Game(IO io, Sorting sorting, CheckForm checkForm) {
            this.io = io;
            this.sorting = sorting;
            this.checkForm = checkForm;
        }

        public void setting() {

            createRunnerMap();
            int count = count();

            io.printNull();
            System.out.println("실행 결과");

            while (count != 0) {
                run();
                printRunResult();
                io.printNull();
                count--;
            }

            RunnerMap.clear();
            RunnerMap = sorting.Winner(GameInfoMap);
            printWinners();
        }

        private void createRunnerMap() {

            String runnerInput = io.start();
            StringTokenizer tokenizer = new StringTokenizer(runnerInput, ",");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                checkForm.RunnerSize(token);
                RunnerMap.add(token);
            }

            for (String key : RunnerMap) {
                GameInfoMap.put(key, "");
            }
        }

        private int count() {
            int count = Integer.parseInt(io.count());
            return count;
        }

        private void run() { //게임 진행

            for (String key : RunnerMap) {
                String value = GameInfoMap.get(key);

                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    GameInfoMap.put(key, value + "-");
                }
            }
        }

        private void printRunResult() {

            for (Map.Entry<String, String> entry : GameInfoMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " : " + value);
            }
        }

        private void printWinners () {
            if (RunnerMap.size() > 1) {
                System.out.println("최종 우승자 : " + String.join(", ", RunnerMap));
            }
            if (RunnerMap.size() == 1) {
                System.out.println("최종 우승자 : " + RunnerMap.get(0));
            }
        }

    }

