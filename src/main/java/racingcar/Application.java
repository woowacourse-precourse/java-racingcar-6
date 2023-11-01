package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Application.game();

    }

    public static String[] carName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        String[] carArr = cars.split(",");
        for (int i = 0; i < carArr.length; i++) {
            if (carArr[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return carArr;
    }

    public static int moveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = readLine();
        try {
            int moveNum = Integer.parseInt(inputNum);
            return moveNum;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static void game(){
        String[] cars = Application.carName();
        int tryNum = Application.moveCount();

        // 자동차의 수에 따라 count 배열을 초기화
        int[] counts = new int[cars.length];

        System.out.println("실행 결과");
        for (int j = 0; j < tryNum; j++){
            moveCars(cars, counts);
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++){
            if (counts[i] == maxCount){
                winners.add(cars[i]);
            }
        }
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    public static void moveCars(String[] cars, int[] counts){
        for (int i = 0; i < cars.length; i++){
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber < 4) {
                System.out.println(cars[i] + " : " + "-".repeat(counts[i]));
            } else {
                counts[i] += 1;
                System.out.println(cars[i] + " : " + "-".repeat(counts[i]));
            }
        }
        System.out.println();
    }
}
