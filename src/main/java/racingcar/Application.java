package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> members = Arrays.asList(input.split(","));
        for (String str : members) {
            if (str.length() > 5) throw new IllegalArgumentException("이름은 5글자 이하만 정할 수 있습니다");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int try_num = Integer.parseInt(Console.readLine());
        int[] advance = new int[members.size()];

        System.out.println("\n실행 결과");
        while (!Advance_num(advance, try_num)) {
           for (int i = 0; i < members.size(); ++i) {
               System.out.print(members.get(i) + " : ");
               Advance_print(advance[i]);
           }
            System.out.println();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < members.size(); ++i) {
            if (advance[i] == try_num) {
                Output_ans(stringBuilder, members.get(i));
            }
        }
        System.out.println("최종 우승자 : " + stringBuilder.toString());
    }

    public static void Advance_print(int advance) {
        for (int i = 0; i < advance; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static boolean Advance_num(int[] arr, int try_num) {
        for (int j : arr) {
            if (j == try_num) return true;
        }
        for (int i = 0 ; i < arr.length; ++i) {
            int rand = Randoms.pickNumberInRange(0,9);
            if (rand >= 4) arr[i] += 1;
        }
        return false;
    }

    public static void Output_ans(StringBuilder stringBuilder, String members)   {
        if (stringBuilder.isEmpty()) stringBuilder.append(members);
        else stringBuilder.append(", ").append(members);
    }
}


