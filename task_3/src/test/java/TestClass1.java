
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestClass1 extends CommonConditions{

    @Test
    void test1() {
        assertThat(true, is(true));
    }
    @Test
    void test2() {
        assertThat(false, is(true));
    }
    @Test
    void test3() {
        assertThat(true, is(true));
    }
    @Test
    void test4() {
        assertThat(true, is(true));
    }
    @Test
    void testBlabla5() {
        assertThat(false, is(true));
    }
    @Test
    void test6() {
        assertThat(true, is(true));
    }
    @Test
    void test7() {
        assertThat(false, is(true));
    }
    @Test
    void test8() {
        assertThat(true, is(true));
    }
    @Test
    void testBlabla9() {
        assertThat(true, is(true));
    }
    @Test
    void test10() {
        assertThat(true, is(true));
    }

}
