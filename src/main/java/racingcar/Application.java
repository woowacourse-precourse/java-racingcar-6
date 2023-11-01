package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import javax.naming.directory.SchemaViolationException;
import racingcar.NumberGenerator;
import racingcar.NameMap;
import racingcar.CompareNumber;
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
      //시도횟수 받기
		System.out.println("시도할 횟수는 몇회인가요?");
		replay = sc.nextInt();
	
        for(int i=0; i<replay; i++){
            // n개의 숫자 생성    
            NumberGenerator numberGenerator = new NumberGenerator(carNames.length);
            ArrayList<Integer> numbers = numberGenerator.getNumbers();
		    
            // NameMap을 이용해 차 이름과 숫자 매핑
            NameMap nameMap = new NameMap(carNamesList, numbers);
            HashMap<Integer, String> getNamMap = nameMap.getNameMap();
            

            // CompareNumber를 사용하여 가장 큰 이름 찾기
            CompareNumber compareNumber = new CompareNumber(getNamMap);
            compareNumber.compare();
            ArrayList<String> maxNames = compareNumber.getMaxNames();
            //결과 출력하기
            for (int j = 0; j < carNamesList.size(); j++) {
                String car = carNamesList.get(j);
                int score = numbers.get(j);

                System.out.print(car + ": ");
                for (int k = 0; k < score; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println("최종 우승자 :"+maxNames);
        }
    }
}
