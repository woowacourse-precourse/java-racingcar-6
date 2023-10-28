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

    // 입력 횟수만큼 먼저 도달한 자동차 나올 때까지 반복
    public void race(int count) {
        do {
            rankCar();
        } while (!checkRaceCompletion(count));
    }

    // 각 자동차의 전진 여부를 랜덤하게 반환하는 메서드
    private String countMovement() {
        if (moveCar()) {
            return "-";
        }
        return "";
    }

    public static boolean moveCar() {
        int drive = Randoms.pickNumberInRange(0,9);
        if (drive >= 4) {
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

    // 우승 관련 메소드
    public void winRace(int count) {
        StringBuilder win = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (carRank[i] == count) {
                String modifiedName = carNames[i].substring(0, carNames[i].length() - (count + 3));
                win.append(modifiedName).append(", ");
            }
        }

        if (win.length() >= 2) {
            win.delete(win.length() - 2, win.length());
        }

        String result = win.toString();
        System.out.println("최종 우승자 : " + result);
    }
}
