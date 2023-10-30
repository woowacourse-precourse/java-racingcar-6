package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import javax.naming.directory.SchemaViolationException;
import racingcar.NumberGenerator;
import racingcar.NameMap;
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
		ArrayList<String> names = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carName = sc.nextLine();
        String[] carNames = carName.split(",");
        ArrayList<String> carNamesList = new ArrayList<>();
        for (String name : carNames) {
            carNamesList.add(name);
        }
        //System.out.println(carName);
		System.out.println("시도할 횟수는 몇회인가요?");
		replay = sc.nextInt();
		//System.out.println(replay);

        NumberGenerator numberGenerator = new NumberGenerator(carNames.length);
        ArrayList<Integer> numbers = numberGenerator.getNumbers();
		System.out.println(carNamesList);
        
        NameMap nameMap = new NameMap(carNamesList, numbers);
        HashMap<Integer, String> getNamMap = nameMap.getNameMap();
        System.out.println(getNamMap);
    }
}
