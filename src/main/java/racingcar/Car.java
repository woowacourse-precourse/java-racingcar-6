package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Car {
    String name;
    Integer advance;

    public Car(String carName) {
        this.name = carName;
        this.advance = 0;
    }

    //- 자기 자신에 대한 비즈니스 로직 --//

    public void rollDice() {
        int dice = Randoms.pickNumberInRange(0, 9);
        if (checkDiceNumber(dice)) {
            update();
        }
    }

    private boolean checkDiceNumber(int dice) {
        return dice >= 4;
    }

    private void update() {
        this.advance += 1;
    }

    public void printStatus() throws IOException { // TODO :: MVC 패턴을 적용한다면 모델에는 뷰와 관련한 코드가 있으면 안된다
        System.out.printf("%s : ", name);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        collectAdvance(bw);
        bw.flush();
    }

    private void collectAdvance(BufferedWriter bw) throws IOException {
        int count = this.advance;
        while (count-- > 0) {
            bw.write("-");
        }
        bw.write("\n");
    }
}
