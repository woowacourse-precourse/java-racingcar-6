package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RacingOutput {
    private BufferedWriter bw;

    RacingOutput()
    {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private void putNameInputStatement() throws IOException
    {
        bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }
}
