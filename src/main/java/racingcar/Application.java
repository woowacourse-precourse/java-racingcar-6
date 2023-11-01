package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.lang.String;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // 자동차 입력받기
        String inputCars = inputCarsName();

        // 쉼표 기준으로 자르고 배열에 저장
        String[] nameArray = CarsName(inputCars);

        // Cars 타입의 배열 만들어서 객체들 저장
        Cars[] carsArray = new Cars[nameArray.length]; 

        // 자동차 객체 배열 초기화
        for (int i = 0; i < nameArray.length; i++) {
            carsArray[i] = createCar(nameArray[i]);
        }

        // 시도할 횟수 입력받기
        int tryNum = inputTryNum();

        // 경주 시작
        OutputView.startRace(carsArray, tryNum);

        // 거리 비교
        int longestDistance = findLongestDistance(carsArray);

        // 우승자 결정, 출력
        OutputView.printWinner(decideWinner(longestDistance, carsArray));

    }

    // 자동차 이름 입력받기
    public static String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return input;
    }

    // 쉼표 기준으로 스트링 자르기
    public static String[] CarsName(String str) {
        String[] array = str.split(",");
        
        // 예외처리 : 이름이 5자 이하가 아닐 경우
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 5) { 
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
        }

        return array;
    }

    // 자동차 객체 생성
    public static Cars createCar(String name) {
        return new Cars(name);
    }


    // 이동을 몇 번 시도할지 입력받기
    public static int inputTryNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryString = Console.readLine();
        int tryNum = Integer.parseInt(tryString);

        // 예외처리 : 시도횟수가 1보다 작은 수일 때
        if (tryNum < 1) {
            throw new IllegalArgumentException("1 이상의 수를 입력하세요.");
        }

        return tryNum;
    }

    // 거리 비교하기
    public static int findLongestDistance(Cars[] carsArray) {
        int longest = 0;

        for (int i = 0; i < carsArray.length; i++) {
            if (carsArray[i].distance > longest) {
                longest = carsArray[i].getDistance();
            }
        }

        return longest;
    }

    // 우승자 결정
    public static ArrayList<Cars> decideWinner(int longest, Cars[] carsArray) {
        // Cars[] winnerCars = new Cars[carsArray.length];
        ArrayList<Cars> winnerCars = new ArrayList<>();
        for (int i = 0; i < carsArray.length; i++) {
            if (longest == carsArray[i].getDistance()) {
                winnerCars.add(carsArray[i]);
            }
        }

        return winnerCars;
    }
}
