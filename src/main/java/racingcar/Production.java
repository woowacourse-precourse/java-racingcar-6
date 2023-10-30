package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Production {

    static List<String> makeRacingCar() {
        // 자동차 이름 입력 받아 리스트 만들기 (5자 이하여야 하며, 쉼표로 구분)
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carName = Console.readLine();
        List<String> racingCars = Arrays.asList(carName.split(","));

        printCars(racingCars);
        return racingCars;
    }

    static void printCars(List<String> racingCars) {
        // 차 이름들 출력
        for (int i = 0; i < racingCars.size(); i++) {
            System.out.print(racingCars.get(i));
            if (i != racingCars.size() - 1) System.out.print(",");
        }
    }

    static int trialNumber() {
        // 시도 횟수 입력 (자연수)
        int trialNum = 0;
        System.out.println("\n시도할 회수는 몇회인가요?");

        try {
            trialNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도할 횟수는 정수여야 합니다.");
        }
        if (trialNum < 0) throw new IllegalArgumentException("시도할 횟수는 자연수여야 합니다.");

        return trialNum;
    }

    static int makeRandomNum() {
        // 랜덤 숫자 생성
        return Randoms.pickNumberInRange(0,9);
    }

    static List<Integer> implementMakeRandomNum(List<String> carList) {
        // 자동차마다 랜덤 숫자 생성 (자동차 수만큼 makeRandomNum 호출)
        List<Integer> RandomNumForCars = new ArrayList<Integer>();

        for (int i=0; i < carList.size(); i++) {
            int RandomNumForIthCar = makeRandomNum();
            RandomNumForCars.add(RandomNumForIthCar);
        }

        return RandomNumForCars;
    }

    static List<String> makeEmptyList(int length) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<length; i++) {
            list.add("");
        }
        return list;
    }
}
