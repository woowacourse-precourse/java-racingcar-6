package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

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

    private void putTryInputStatement() throws IOException
    {
        bw.write("시도할 회수는 몇회인가요?");
    }

    private void putResultOfEachCar(int cnt) throws IOException
    {
        for (int i = 0 ; i<cnt; i++)
        {
            bw.write("-");
        }
    }


}
