package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            //Console.readLine() 메서드를 이용해서 자동차 이름 받기
            String inputCarName = Console.readLine();
            //이름만 가지고 있는 배열
            String[] carName = inputCarName.split(",");
            //이름과 움직인 거리를 가질 배열
            String[] tokens = inputCarName.split(",");


            //String이 기본 적용된 readLine() 메서드를 사용하기 위해 int로 변경
            System.out.println("시도할 회수는 몇회인가요?");
            String tryNumber = Console.readLine();
            int number = Integer.parseInt(tryNumber);
            //토큰마다 : 추가
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] += " : ";
            }
            //Car에 distance 추가
            for (int i = 0; i < number; i++) {
                //각 토큰마다 랜덤하게 - 를 추가
                for (int j = 0; j < tokens.length; j++) {
                    tokens[j] += getRandomNumber();
                    System.out.println(tokens[j].trim());
                }
                System.out.println();
            }
            //distance가 가장 긴 차가 우승
            int[] count = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                for (char ch : tokens[i].toCharArray()) {
                    if (ch == '-') {
                        count[i]++;
                    }
                }
            }
            //우승자가 담길 List를 만들어줌
            List<String> winners = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (max < count[i]) {
                    max = count[i];
                }
            }
            for (int i = 0; i < tokens.length; i++) {
                if (count[i] == max) {
                    winners.add(carName[i]);
                }
            }
            System.out.print("최종 우승자 : ");
            String result = String.join(",", winners);
            System.out.println(result);
        }  catch (IllegalArgumentException e) {
            System.err.println("입력값이 잘못되었습니다. 애플리케이션을 종료합니다.");
            throw new RuntimeException(e); // 예외 던지기
        }
    }

    //랜덤 넘버에 따라 -를 반환할지 빈값을 반환할지 선택
    static String getRandomNumber() {
        int setNumber = Randoms.pickNumberInRange(0, 9);
        String goCar = "-";
        String stopCar = "";
        if (setNumber >= 4) {
            return goCar;
        } else {
            return stopCar;
        }
    }
}
