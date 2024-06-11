package racingcar;

public class Winner {
    // 우승자 String[] 받아서 출력
    public void showWinner(String[] car, String[] drive) {
        System.out.print("최종 우승자 : ");
        String[] winner = winner(car, drive);
        for (int i = 0; i < winner.length; i++) {
            if (i == winner.length - 1) { // 마지막으로 나오는 값은 ,없게
                System.out.print(winner[i]);
            } else {
                System.out.print(winner[i] + ", ");
            }
        }
    }

    // 우승자 명단
    private String[] winner(String[] car, String[] drive) {
        int distance = pick(drive);
        String[] winner = new String[count(drive)]; // 우승자 이름 저장하기 위한 winner string[]
        int index = 0;

        for (int i = 0; i < drive.length; i++) {
            if (drive[i].length() == distance) {
                winner[index++] = car[i];
            }
        }
        return winner;
    }

    // 우승자 수 세기
    private int count(String[] drive) {
        int distance = pick(drive);
        int count = 0;

        for (int i = 0; i < drive.length; i++) {
            if (drive[i].length() == distance) {
                count++;
            }
        }
        return count;
    }

    // 제일 긴 주행거리 구하기
    private int pick(String[] drive) {
        int length = 0;
        for (int i = 0; i < drive.length; i++) {
            if (drive[i].length() > length) {
                length = drive[i].length();
            }
        }
        return length;
    }
}
