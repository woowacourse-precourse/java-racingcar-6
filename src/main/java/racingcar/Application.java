package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" );
        String[] carNames = getCarNames(sc.nextLine());
    }
    public static String[] getCarNames(String names) {
        String[] nameSplit = names.split(",");
        for (int i = 0; i < nameSplit.length; i++) {
            if (nameSplit[i].length() > 5) {
                throw new IllegalArgumentException("5자 이하만 가능합니다.");
            }
        }
        return nameSplit;
    }
}
