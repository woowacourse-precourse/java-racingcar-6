package racingcar.vo;

import java.util.List;

public class Car {
    private final String name;
    private final List<Boolean> movementFlags;
    private final int totalForward;
    private int completedMoves;

    public Car(String name, List<Boolean> movementFlags){
        this.name=name;
        this.movementFlags = movementFlags;
        this.completedMoves = 0;
        this.totalForward = calculateTotalForward(movementFlags);
    }

    private int calculateTotalForward(List<Boolean> movementFlags){
        return (int) movementFlags.stream()
                .filter(flag->flag)
                .count();
    }

    public int getTotalForward(){
        return totalForward;
    }

    public void incrementMoveCount(){
        this.completedMoves++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for(int step = 0; step< completedMoves; step++) {
            if(movementFlags.get(step)) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
