package racingcar.Model;

import java.util.Random;

public class RadomNumberGenertorImp implements RadomNumberGenerator{
    private Random random=new Random();

    @Override
    public int nextInt(int bound){
        return random.nextInt(bound);
    }
}
