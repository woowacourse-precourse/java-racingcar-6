package racingcar.domain;

public class Player {
    private int score;
    private String name;

    public int getScore(){
        return score;
    }

    public String getName() {
        return name;
    }

    /**
     * 사용자 이름을 받는 생성자
     * @param name
     */
    public Player(String name){
        this.name = name;
        score = 0;
    }


}
