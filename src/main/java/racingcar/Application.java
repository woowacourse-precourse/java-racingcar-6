package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    static String[] name;
    static int[] result;

    static String[] NameInit() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();

        String[] name = input.split(",");
        if (name.length == 0)
            throw new IllegalArgumentException("Invalid name! " + input);

        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > 5)
                throw new IllegalArgumentException("Invalid name! " + input);
        }

        return name;
    }

    static void racing(int T) {

        for (int i = 0; i < T; i++) {
            int tmp = Randoms.pickNumberInRange(0, 9);
            if (tmp >= 4) result[i]++;

            System.out.print(name[i] + " : ");
            for (int k = 0; k < result[i]; k++)
                System.out.print("-");
            System.out.println();
        }
    }

    static void printResult() {
        int MAX = -1;
        Queue<String> winner = new LinkedList<>();

        for (int i = 0; i < name.length; i++) {
            if (result[i] > MAX)
                MAX = result[i];
        }

        for (int i = 0; i < name.length; i++) {
            if (result[i] == MAX)
                winner.add(name[i]);
        }

        System.out.print("최종 우승자 : ");
        while (true) {
            String tmp = winner.poll();

            System.out.print(tmp);
            if (winner.isEmpty()) break;

            System.out.print(", ");
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        name = NameInit();

        System.out.println("시도할 회수는 몇회인가요?");
        int T = scanner.nextInt();
        if (T <= 0)
            throw new IllegalArgumentException("Invalid number!" + T);

        result = new int[name.length];
        System.out.println("수행 결과");
        for (int i = 0; i < T; i++) {
            racing(name.length);
            System.out.println();
        }
        printResult();
    }
}
