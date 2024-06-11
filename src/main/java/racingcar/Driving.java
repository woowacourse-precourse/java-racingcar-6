package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Driving {
    public void showResult(String[] car, String[] drive, int game) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < game; i++) { // 입력받은 횟수만큼 게임을 진행
            driving(car, drive);
            System.out.println();
        }

        Winner winner = new Winner();
        winner.showWinner(car, drive);
    }

    // 난수 1~9까지 발생시켜 4 이상일 때 전진 - 한번, 아니라면 정지
    private void driving(String[] car, String[] drive) {
        String move = "-";
        for (int i = 0; i < drive.length; i++) {
            // 난수 발생시켜서 car[] length 만큼 크기를 지정하고, 그 배열에 stirng - 발생시켜서 저장하도록 하기
            int random = Randoms.pickNumberInRange(1, 9); // 난수를 매번 발생시킴
            if (random >= 4) {
                drive[i] += move;
            }
            System.out.println(car[i] + " : " + drive[i]);
        }
    }
}
