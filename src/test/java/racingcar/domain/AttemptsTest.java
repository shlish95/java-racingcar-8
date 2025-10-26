package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttemptsTest {

    @Test
    void 정상값은_생성된다() {
        assertEquals(1, new Attempts("1").value());
        assertEquals(5, new Attempts("5").value());
    }

    @Test
    void 빈값_혹은_공백만이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Attempts(""));
        assertThrows(IllegalArgumentException.class, () -> new Attempts("   "));
        assertThrows(IllegalArgumentException.class, () -> new Attempts(null));
    }

    @Test
    void 숫자가_아니면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Attempts("abc"));
        assertThrows(IllegalArgumentException.class, () -> new Attempts("1a"));
    }

    @Test
    void 영_혹은_음수면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Attempts("0"));
        assertThrows(IllegalArgumentException.class, () -> new Attempts("-3"));
    }
}