package mytest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import racingview.MainView;
import racingview.Viewable;

public class ViewTestTemplete {

    private ByteArrayOutputStream baos = null;

    private ByteArrayOutputStream getBaos() {
        return baos;
    }

    private PrintStream ps = null;
    private PrintStream old = System.out;

    public void setOut() {
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        System.setOut(ps);
    }

    public ByteArrayOutputStream flushAndResetoutAndGetbaos()
    {
        System.out.flush();
        System.setOut(old);
        return getBaos();

    }
}
