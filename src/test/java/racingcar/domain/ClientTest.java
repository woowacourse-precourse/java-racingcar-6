package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    @Test
    void getTotalRounds() {
        Client client = new Client("3");
        assertThat(client).isExactlyInstanceOf(Client.class);
        assertThat(client.getTotalRounds()).isEqualTo(3);
    }
}