package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //자동차 이름 입력 받기
        List<String> cars = List.of(br.readLine().split(","));
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
        }

        //시도 횟수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        String input = br.readLine();
        int cnt = Integer.parseInt(input);

        //전진 횟수 기록할 리스트 생성
        List<Integer> toGo = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            toGo.add(0);
        }

        //반복해서 전진 및 출력
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    toGo.set(j, toGo.get(j) + 1);
                }
            }

            for (int k = 0; k < cars.size(); k++) {
                System.out.print(cars.get(k) + " : ");
                for (int l = 0; l < toGo.get(k); l++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("최종 우승자 : ");

        
    }
}
