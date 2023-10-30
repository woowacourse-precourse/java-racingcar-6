package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        //Console.readLine() 메서드를 이용해서 자동차 이름 받기
        String inputCarName = Console.readLine();
        String[] tokens = inputCarName.split(",");

        //String이 기본 적용된 readLine() 메서드를 사용하기 위해 int로 변경
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = Console.readLine();
        int number = Integer.parseInt(tryNumber);
        //토큰마다 : 추가
        for (int i = 0; i < tokens.length; i++){
            tokens[i] += " : ";
        }

        for (int i = 0; i < number; i++) {
            //각 토큰마다 랜덤하게 - 를 추가
            for (int j = 0; j < tokens.length; j++) {
                tokens[j] += getRandomNumber();
                System.out.println(tokens[j]);
            }
            System.out.println();
        }

    }

    //랜덤 넘버에 따라 -를 반환할지 빈값을 반환할지 선택
    static String getRandomNumber() {
        int setNumber = Randoms.pickNumberInRange(0, 9);
        String goCar = "-";
        String stopCar = "";
        if (setNumber >= 4){
            return goCar;
        }
        else{
            return stopCar;
        }
    }
}
