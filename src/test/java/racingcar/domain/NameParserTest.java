package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameParserTest {

    @Test
    void 쉼표로_구분해_Name_리스트를_만든다() {
        List<Name> names = NameParser.parse("pobi,woni,jun");
        assertEquals(3, names.size());
        assertEquals("pobi", names.get(0).value());
        assertEquals("woni", names.get(1).value());
        assertEquals("jun", names.get(2).value());
    }

    @Test
    void 각_토큰은_trim_되어야_한다() {
        List<Name> names = NameParser.parse("pobi, woni ,  jun");
        assertEquals(3, names.size());
        assertEquals("pobi", names.get(0).value());
        assertEquals("woni", names.get(1).value());
        assertEquals("jun", names.get(2).value());
    }

    @Test
    void 빈문자열_혹은_공백만_입력이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse(""));
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse("   "));
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse(null));
    }

    @Test
    void 비어있는_토큰이_있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse("pobi,,jun"));
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse("pobi,  ,jun"));
    }

    @Test
    void 각_이름은_Name의_검증을_따른다_길이초과시_예외() {
        assertThrows(IllegalArgumentException.class, () -> NameParser.parse("abcdef,woni"));
    }
}