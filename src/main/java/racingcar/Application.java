package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        
    }


}
