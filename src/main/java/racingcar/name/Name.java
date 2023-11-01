package racingcar.name;

import java.util.Scanner;

public class Name {
    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carname = scanner.next().trim();
        scanner.close();
        return String.valueOf(carname);

    }
    public String[] NameList(String wow) throws IllegalArgumentException{
        String[] now = wow.split(",");

        try {
            validateStringLength(now);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        public static void validateStringLength(int number) {
            if (number == 0) {
                throw new IllegalArgumentException("문자열의 길이는 0일 수 없습니다.");
            }
        }
//        if (now.length == 0) {
//            throw new IllegalArgumentException("자통차 이름들을 잘못 입력하셨습니다.");
//        }
        return now;
    }
}
