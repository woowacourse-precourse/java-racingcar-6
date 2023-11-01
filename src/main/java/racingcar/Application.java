package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        // 1. 자동차이름입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[]carNames = Console.readLine().split(",");
        for(String carName: carNames){
            if(carName.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        // 1-1. 자동차 이동거리 배열 초기화
        int[] carDistances = new int[carNames.length];
        for(int i=0;i<carNames.length;i++){
            carDistances[i]=0;
        }

        // 2. 시도할횟수입력
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber=Integer.parseInt(Console.readLine());
        if(tryNumber<1){
            throw new IllegalArgumentException("시도할 회수는 1이상이어야 합니다.");
        }

        // 3. 경주 진행
        System.out.println("실행결과");
        for(int i=0;i<tryNumber;i++){
            raceOneCycle(carNames,carDistances);
        }

        // 4. 우승자 출력
        printWinner(carNames,carDistances);


    }
    // 3-1. 무작위 값을 뽑고 자동차 이동거리를 바꾸는 메소드
    static void moveCarRandomly(int[] carDistances, int carIndex) {
        int dice = Randoms.pickNumberInRange(0, 9);
        if(dice>=4){
            carDistances[carIndex]++;
        }
    }

    // 3-2. 자동차들의 이동거리를 출력
    static void printCarDistance(String[] carNames, int[] carDistances) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            System.out.print("-".repeat(carDistances[i]));
            System.out.println();
        }
        System.out.println();
    }

    // 3-3. 경주 1 사이클
    static void raceOneCycle(String[] carNames, int[] carDistances) {
        for (int i = 0; i < carNames.length; i++) {
            moveCarRandomly(carDistances, i);
        }
        printCarDistance(carNames, carDistances);
    }

    // 4-1. 자동차들의 이동거리 배열에서 최대값 구하기
    static int getMaxDistance(int[] carDistances) {
        int maxDistance = 0;
        for (int i = 0; i < carDistances.length; i++) {
            if (carDistances[i] > maxDistance) {
                maxDistance = carDistances[i];
            }
        }
        return maxDistance;
    }

    // 4-2. 최대 이동거리인 자동차들의 이름 동적배열을 구하기
    static ArrayList<String> getWinnerNames(String[] carNames, int[] carDistances) {
        int theLongestDistance = getMaxDistance(carDistances);
        ArrayList<String> winnerNames = new ArrayList<String>();

        for (int i = 0; i < carNames.length; i++) {
            if (carDistances[i] == theLongestDistance) {
                winnerNames.add(carNames[i]);
            }
        }
        return winnerNames;
    }

    // 4-3. 우승자 출력하기
    static void printWinner(String[] carNames, int[] carDistances) {
        ArrayList<String> winnerNames = getWinnerNames(carNames,carDistances);
        System.out.println("최종 우승자 : " + String.join(",",winnerNames));
    }
}