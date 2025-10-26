package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 유효한_이름은_생성된다() {
        assertEquals("pobi", new Name("pobi").value());
        assertEquals("a", new Name("a").value());
        assertEquals("abcde", new Name("abcde").value());
    }

    @Test
    void 빈값과_공백만으로는_생성할_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new Name(""));
        assertThrows(IllegalArgumentException.class, () -> new Name("   "));
    }

    @Test
    void 길이_제한_초과시_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Name("abcdef"));
    }

    @Test
    void null_이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Name(null));
    }
}