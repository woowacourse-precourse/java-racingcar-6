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
                throw new IllegalArgumentException("5글자 넘었습니다.");
            }
        }
        return carArr;
    }

    public static int moveCount() {
        System.out.println("시도 휫수 입력");
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
        int randomNumber = Randoms.pickNumberInRange(0,9);
        int count = 1;
        String[] cars = Application.carName();
        int tryNum = Application.moveCount();
        for (int i = 0; i < cars.length; i++){
            System.out.println(cars[i]);
        }
        for (int i = 0; i < tryNum; i ++){
            System.out.println("-".repeat(count));
            count += 1;
        }
        System.out.println(randomNumber);
        /*for (int i = 1; i <= tryNum; i++){
            for (int j = 0; j <= cars.length; j++){
                if (randomNumber < 4) {
                    System.out.println(cars[j] + " : " + "-".repeat(count));
                } else {
                    count += 1;
                    System.out.println(cars[j] + " : " + "-".repeat(count));
                }
            }


        }/*
        /*
        System.out.println("tryNum");
        System.out.println(tryNum);
        System.out.println("randomNumber");
        System.out.println(randomNumber);
        if (randomNumber<4){

        } else {

        }

         */
    }

    /*public static void Counter(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        int count = 0;
        if (randomNumber<4){

        } else {

        }
    }

     */
}
