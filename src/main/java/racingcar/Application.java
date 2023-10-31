package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] inputs = inputCarName();
        Map<String, Integer> map = new LinkedHashMap<>();
        // 순서대로 key값 넣기
        for(String i : inputs){
            map.put(i, map.getOrDefault(i, 0));
        }

        // 횟수 입력
        int count = inputCount();

        int i=0;

        while (i < count){
            for (String input : inputs) {
                int num = createRandom();;

                if (num >= 4) {
                    map.put(input, map.getOrDefault(input,0)+1);
                }
            }
            print(map);
            i++;
        }
    }

    public static String[] inputCarName() {
        String[] name = new String[0];
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            name = input.split(",");

            if (!checkLength(name)) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            } else if (!duplicateName(name)) {
                throw new IllegalArgumentException("이미 이름이 존재합니다.");
            } else if (!isNumberic(name)) {
                throw new IllegalArgumentException("문자만 입력하세요");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return name;
    }

    private static boolean checkLength(String[] arr) {
        boolean flag = true;

        for (String s : arr) {
            if (s.length() > 5) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean duplicateName(String[] arr) {
        boolean flag = true;
        List<String> list = new ArrayList<>();

        for (String s : arr) {
            if (list.contains(s)) flag = false;
            else {
                list.add(s);
            }
        }

        return flag;
    }

    private static boolean isNumberic(String[] arr) {
        boolean flag = true;

        for (String s : arr) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public static int inputCount() {
        int num = 0;
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = Console.readLine();

            if (!checkisDigit(input)) {
                throw new IllegalArgumentException("숫자만 입력하세요");
            } else if (!checkNegative(input)) {
                throw new IllegalArgumentException("양수만 입력하세요");
            }
            num = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return num;
    }

    private static boolean checkisDigit(String s) {
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                flag = false;
            }
        }

        return flag;
    }

    private static boolean checkNegative(String s) {
        boolean flag = true;
        int result = Integer.parseInt(s);

        if (result < 0) flag = false;

        return flag;
    }

    public static int createRandom(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void print(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.println(key + " : " + "-".repeat(Math.max(0, value)));
        }
        System.out.println();
    }

}
