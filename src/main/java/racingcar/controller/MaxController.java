package racingcar.controller;

public class MaxController {
    public int findMax(int max, int num){
        if(max<num){
            return num;
        }
        return max;
    }
}
