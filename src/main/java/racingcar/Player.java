package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Player implements Comparable<Player>{

    private final String name;
    public int step;

    public Player(String name){ this.name = name; }

    public void move(){
        if(movable()){
            this.step+=1;
        }
    }

    public boolean movable(){
        if (Randoms.pickNumberInRange(0,9)> RacingGame.MOVE_FORWARD_COND){
            return true;
        }
        return false;
    }
    public String makeRoad(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.step; i++){
            sb.append("-");
        }
        return sb.toString();
    }
    public void print(){
        System.out.println(String.format("%s : %s", name, makeRoad()));
    }
    public String getName() { return name; }

    @Override
    public int compareTo(Player p) { return Integer.compare(this.step, p.step); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
