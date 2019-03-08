import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class RaiseAPowerTest {

    @Test
    public void test_raise_a_power(){
        Assert.assertThat(RaiseAPower.power(2,2), Is.is(Math.pow(2,2)));
        Assert.assertThat(RaiseAPower.power(2,5), Is.is(Math.pow(2,5)));
        Assert.assertThat(RaiseAPower.power(3,2), Is.is(Math.pow(3,2)));
        Assert.assertThat(RaiseAPower.power(-3,2), Is.is(Math.pow(-3,2)));
        Assert.assertThat(RaiseAPower.power(-3,3), Is.is(Math.pow(-3,3)));
        Assert.assertThat(RaiseAPower.power(3,-2), Is.is(Math.pow(3,-2)));
        Assert.assertThat(RaiseAPower.power(3,0), Is.is(Math.pow(3,0)));
    }
}
