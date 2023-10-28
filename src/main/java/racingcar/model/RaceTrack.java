package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceTrack {

    public String[] carNames;
    public int[] carStartLine;
    public int[] carRank;

    public RaceTrack(String[] carNames) {
        this.carNames = carNames;
        this.carStartLine = new int[carNames.length];
        this.carRank = new int[carNames.length];
    }

    // carNames 배열의 각 요소(자동차 이름)에 " : " 더하기
    public void printCarNames() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i] + " : ";
            carStartLine[i] = carNames[i].length();
        }
    }

    // 이제 얘를 이동 회수만큼 반복시켜야 한다
    public void rankCar() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i] + countMovement();
            carRank[i] = carNames[i].length() - carStartLine[i];
            System.out.print(carNames[i] + "\n");
        }
        System.out.println();
    }

    public void race(int count) {
        do {
            rankCar();
        } while (!checkRaceCompletion(count));
    }

//    public void printCarNames() {
//        for (String carName : carNames) {
//            String movement = countMovement();
//            System.out.println(carName + " : " + movement);
//        }
//    }

    /* while(요소들 중 어느 하나라도 작대기 길이 != count) {
    result 초기값 => "자동차 이름 : "
    result = result + countMovement()
    sout(result)
    }
    */

    // 각 자동차의 전진 여부를 랜덤하게 반환하는 메서드
    private String countMovement() {
        if (moveCar()) {
            return "-";
        }
        return "";
    }

    public static boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if(drive >= 4) {
            return true;
        }
        return false;
    }

    // carRank 배열의 요소 중 하나라도 인자 count의 값을 가지는지 확인하는 메소드
    private boolean checkRaceCompletion(int count) {
        for (int rank : carRank) {
            if (rank >= count) {
                return true; // 레이스 완료 조건 충족
            }
        }
        return false; // 레이스 완료 조건 미충족
    }
}
