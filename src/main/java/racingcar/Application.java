package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carNames; // carNames 변수 선언
        
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
            // 입력 
            String input = reader.readLine();
            carNames = input.split(",");
            
            // 자동차 이름 출력
            System.out.print("입력된 자동차 이름: ");
            for (String carName : carNames) {
                System.out.print(carName.trim() + ", "); // trim으로 공백 제거
            }
            System.out.println(""); // 줄 바꿈
            
            // 시도할 회수 입력
            System.out.println("시도할 회수는 몇회인가요?");
            int count = 0;
            try {
                // 입력값 정수값으로 변환
                count = Integer.parseInt(reader.readLine());
                // 횟수만큼 반복하여 랜덤한 값을 생성하고 출력
                for (int i = 0; i < count; i++) {
                    // 랜덤한 정수 생성
                    int randomNumber = Randoms.pickNumberInRange(0, 9);
                    // 현재 순환 중인 자동차 이름과 랜덤한 숫자 출력
                    for (String carName : carNames) {
                        System.out.println(carName.trim() + ": " + convertToSymbol(randomNumber));
                        System.out.println("");
                    }
                }
            } catch (Exception e2) {
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다. 프로그램을 종료합니다.");
            System.exit(0);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 숫자를 기호로 변환하는 메서드
    private static String convertToSymbol(int number) {
        if (number == 0) {
            return "-";
        } else {
            return String.valueOf(number); // 숫자 그대로 반환
        }
    }
}
