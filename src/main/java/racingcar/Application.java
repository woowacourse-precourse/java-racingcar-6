package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        String[] cars = Application.carName();
        int tryNum = Application.moveCount();

        System.out.println("실행 결과");
        for (int j = 0; j < tryNum; j ++){
            for (int i = 0; i < cars.length; i++) {
                if (i == 0) {
                    int randomNumber = Randoms.pickNumberInRange(0, 9);
                    if (randomNumber < 4) {
                        System.out.println(cars[0] + " : " + "-".repeat(count1));
                    } else {
                        count1 += 1;
                        System.out.println(cars[0] + " : " + "-".repeat(count1));
                    }
                } else if (i == 1) {
                    int randomNumber = Randoms.pickNumberInRange(0, 9);
                    if (randomNumber < 4) {
                        System.out.println(cars[1] + " : " + "-".repeat(count2));
                    } else {
                        count2 += 1;
                        System.out.println(cars[1] + " : " + "-".repeat(count2));
                    }
                } else if (i == 2) {
                    int randomNumber = Randoms.pickNumberInRange(0, 9);
                    if (randomNumber < 4) {
                        System.out.println(cars[2] + " : " + "-".repeat(count3));
                    } else {
                        count3 += 1;
                        System.out.println(cars[2] + " : " + "-".repeat(count3));
                    }
                }
            }
        }
    }
}
