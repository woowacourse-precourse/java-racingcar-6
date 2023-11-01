package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] inputs = inputCarName();

        int count = inputCount();

        int i = 0;

        while (i < count) {
            getMap(inputs);
            print(map);
            i++;
        }
        output(map);
    }

    public static void getMap(String[] inputs) {
        for (String input : inputs) {
            map.put(input, map.getOrDefault(input, Number.MIN.getValue()));
            int num = createRandom();

            if (num >= Number.RANDOM_VALUE.getValue()) {
                if (map.containsKey(input)) {
                    map.put(input, map.get(input) + 1);
                }
            }
        }
    }

    public static String[] inputCarName() {
        String[] name = new String[0];
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            if (!checkExpression(input)) {
                throw new IllegalArgumentException("자동차 이름은 쉼표(,) 기준으로 구분합니다. 쉼표(,)를 넣어주세요.");
            } else {
                name = input.split(",");
            }

            if (!checkLength(name)) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            } else if (!duplicateName(name)) {
                throw new IllegalArgumentException("이미 이름이 존재합니다.");
            } else if (!isNumberic(name)) {
                throw new IllegalArgumentException("문자만 입력하세요");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(Number.MIN.getValue());
        }

        return name;
    }

    private static boolean checkExpression(String input) {
        boolean flag = true;

        if (!input.contains(",")) {
            flag = false;
        }

        return flag;
    }

    private static boolean checkLength(String[] arr) {
        boolean flag = true;

        for (String s : arr) {
            if (s.length() > Number.NAME_LENGTH.getValue()) {
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

            if (!checkIsDigit(input)) {
                throw new IllegalArgumentException("숫자만 입력하세요");
            } else if (!checkNegative(input)) {
                throw new IllegalArgumentException("양수만 입력하세요");
            }
            num = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(Number.MIN.getValue());
        }

        return num;
    }

    private static boolean checkIsDigit(String s) {
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

        if (result < Number.MIN.getValue()) flag = false;

        return flag;
    }

    public static int createRandom() {
        return Randoms.pickNumberInRange(Number.MIN.getValue(), Number.MAX.getValue());
    }

    public static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.println(key + " : " + "-".repeat(Math.max(Number.MIN.getValue(), value)));
        }
        System.out.println();
    }

    public static void output(Map<String, Integer> map) {
        int max = getMax(map);
        ArrayList<String> list = addList(max, map);
        out(list);
    }

    public static int getMax(Map<String, Integer> map) {
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }

        return max;
    }

    public static ArrayList<String> addList(int max, Map<String, Integer> map) {
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    public static void out(ArrayList<String> list) {
        System.out.print("최종 우승자 : ");

        if (list.size() >= Number.TWO.getValue()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else if (list.size() == 1) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

}
