package racingcar;

public class Car {
    /**
     * 자동차의 이름입니다.
     */
    private String name;
    /**
     * 자동차의 전진 횟수입니다.
     */
    private Integer score = 0;

    public Car(String name) {
        this.name = name;
    }

    /** 자동차의 전진 횟수를 1증가시킵니다 */
    public void upScore() {
        score += 1;
    }

    /**
     * 자동차의 점수 현황을 출력합니다.
     * '-'는 전진 횟수입니다.
     * */
    @Override
    public String toString() {

        String scoreBoard = "";

        for(int i=0; i<score; i++) {
            scoreBoard += "-";
        }

        return name + " : " + scoreBoard;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
