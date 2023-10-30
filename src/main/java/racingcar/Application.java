package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.SchemaViolationException;
class Car {
    private String name;

    public Car(String name) {
        if (name.length() <= 5 && name.contains(",")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이고 쉼표(,)를 포함해야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
public class Application {
    private String name;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carName;
		int replay;
		ArrayList name = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carName = sc.nextLine();
        String[] carNames = carName.split(",");
        System.out.println(carNames[0]);
        System.out.println(carName);
		System.out.println("시도할 횟수는 몇회인가요?");
		replay = sc.nextInt();
		System.out.println(replay);
		
    }
}
