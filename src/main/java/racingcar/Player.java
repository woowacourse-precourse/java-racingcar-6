package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Player implements Comparable<Player>{
    private String name;
    private String result;
    private int count;
    Player(String name){
        setCount(0);
        setResult("");
        setName(name);
    }

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result = result;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void move(){
        int score = Randoms.pickNumberInRange(0,9);
        if(score>=4){
            setResult(getResult()+"-");
            setCount(getCount()+1);
        }
    }

    public void print(){
        System.out.println(getName()+" : "+getResult());
    }

    @Override
    public int compareTo(Player o) {
        return o.count-count;
    }
}
