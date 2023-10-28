package racingcar;

import java.util.*;



public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Implement input
        // 경주 할 자동차 이름 입력
        String racerNames = scanner.nextLine();
        // ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
        String[] racerArray = racerNames.split(",");
        // racer들의 이름을 List<Stirng>에 저장
        List<String> racerList = new ArrayList<>();
        for (int i = 0; i < racerArray.length; i++) {
            racerList.add(racerArray[i]);
        }
        // 시도할 횟수 입력
        int num = scanner.nextInt();


    }
}
