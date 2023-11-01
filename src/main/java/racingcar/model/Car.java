package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int score;

    public Car(String name){
        checkWord(name);
        this.name = name;
        this.score = 0;
    }
    public void setScore(){
        if (4 <= Randoms.pickNumberInRange(0,9)){
           score++;
        }
    }
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
    private static void checkWord(String name){
        if (name.length() > 5 || name.matches("[^a-zA-Z]+")) {
                throw new IllegalArgumentException("길이 5초과 혹은 영어 문자 이외 입력");
        }
    }
}
