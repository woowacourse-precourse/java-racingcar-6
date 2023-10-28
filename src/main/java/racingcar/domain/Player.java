package racingcar.domain;

public class Player {
    private String name;
    private int runCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunCount() {
        return runCount;
    }

    public void setRunCount(int runCount) {
        this.runCount = runCount;
    }

    public Player(String name){
        this.name = name;
        this.runCount = 0;
    }

    public void run(){
        // 0 ~ 9 사이의 랜덤 숫자 생성
        int randomNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);

        // 랜덤 값이 4 이상이면 전진
        if(randomNum >= 4){
            this.runCount++;
        }
    }

    // 조건에 맞게 전진 횟수 출력
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");

        for (int i = 0; i < this.runCount; i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }
}
