package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

class UserTest {
    private String name;
    private String distance = "";
    private int count = 0;

    public UserTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance += distance;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }


}

public class Application {
    public static void main(String[] args) {
        ArrayList<UserTest> userArray = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] carNameArray = carName.split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());
        System.out.println();
        System.out.println("실행 결과");

        for (int j = 0; j < carNameArray.length; j++) {
            UserTest user = new UserTest(carNameArray[j]);
            userArray.add(user);
        }

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < carNameArray.length; j++) {
                int dice = Randoms.pickNumberInRange(0, 9);
                if (dice > 3) {
                    userArray.get(j).setDistance("-");
                    userArray.get(j).setCount();
                }
                System.out.println(userArray.get(j).getName() + " : " + userArray.get(j).getDistance());
            }
            System.out.println();
        }

        ArrayList<Integer> countArray = new ArrayList<>();
        for (int i = 0; i < carNameArray.length; i++) { // 갯수를 [1,2,3] 이런식으로 넣는 부분
            countArray.add(userArray.get(i).getCount());
        }
        int maxNumber = 0;
        for (int i = 0; i < carNameArray.length; i++) { // 그 중 가장 큰값을 정하는 부분 = 3
            maxNumber = Math.max(countArray.get(i), maxNumber);
        }

        List<Integer> result = new ArrayList<>();
        // 배열을 순회하면서 가장 큰 숫자를 가지는 인덱스를 찾습니다.
        for (int i = 0; i < carNameArray.length; i++) { // 가장 큰 값이 있는 index의 위치를 아는 부분 (여러개일 수도 있음) [0,2]
            if (countArray.get(i) == maxNumber) {
                result.add(i);
            }
        }

        ArrayList<String> finalWinner = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) { // finalWinner = []
            finalWinner.add(userArray.get(result.get(i)).getName());
        }

        String lastString = String.join(", ", finalWinner);

        System.out.println("최종 우승자 : " + lastString);

    }
}
