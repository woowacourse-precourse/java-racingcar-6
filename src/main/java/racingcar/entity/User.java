package racingcar.entity;


public class User {
    private String name;
    private Integer score = 0;

    public String getName(){
        return name;
    }
    public Integer getScore(){
        return score;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setScore(Integer score){
        this.score = score;
    }

}
