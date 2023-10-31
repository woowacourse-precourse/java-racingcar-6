package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();

        StringTokenizer st = new StringTokenizer(line,",");

        int size = st.countTokens();
        String[] names = new String[size];
        String[] run = new String[size];

        for(int i = 0; i < size; i++) {
            String name = st.nextToken();
            if(name.length() >= 5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            names[i] = name;
            run[i] = "";
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int N = 0;
        try {
            N = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }

        StringBuilder ans = new StringBuilder();
        ans.append("실행 결과").append("\n");
        for(int i = 0; i < N; i++) {
            go(run);
            check(ans, names, run);
        }
        whoWin(ans, names, run);

        System.out.println(ans);
    }

    private static void whoWin(StringBuilder ans, String[] names, String[] run) {
        int size = run.length;
        List<String> winnerList = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < size; i++) {
            int length = run[i].length();
            if(length > max) {
                winnerList = new ArrayList<>();
                winnerList.add(names[i]);
                max = length;
            }
            else if(length == max) {
                winnerList.add(", " + names[i]);
            }
        }

        ans.append("최종 우승자 : ");
        for(String winner : winnerList) {
            ans.append(winner);
        }
    }


    private static void check(StringBuilder ans, String[] names, String[] run) {
        int size = run.length;

        for(int i = 0; i < size; i++) {
            ans.append(names[i]).append(" : ").append(run[i]).append("\n");
        }
        ans.append("\n");
    }

    private static void go(String[] run) {
        int size = run.length;

        for(int i = 0; i < size; i++) {
            int number = Randoms.pickNumberInRange(0,9);

            if(number >= 4) {
                run[i] += "-";
            }
        }
    }
}
