package study.mock;

import racingcar.domain.GameConsole;

public class MockGameConsole implements GameConsole {

    private String[] mockStream;
    private int index;

    public void setMockStream(String... mockStream) {
        this.mockStream = mockStream;
    }


    @Override
    public String readLine() {
        if (mockStream == null || mockStream.length == 0) {
            return null;
        }
        return mockStream[index++];
    }
}
