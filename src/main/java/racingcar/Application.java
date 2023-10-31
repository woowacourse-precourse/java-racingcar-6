package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] inputs = inputCarName();
        int count = inputCount();
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
}
