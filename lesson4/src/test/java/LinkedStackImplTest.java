import linkedlist.LinkedList;
import linkedlist.LinkedStackImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedStackImplTest {
    @Test
    public void test_insert_getSize_isEmpty_peek_pop(){
        LinkedStackImpl<Integer> list = new LinkedStackImpl<>();
        Assert.assertTrue(list.isEmpty());
        list.push(10);
        list.push(20);
        list.push(30);
        Assert.assertFalse(list.isEmpty());
        Assert.assertThat(list.size(), Is.is(3));
        Assert.assertThat(list.peek(), Is.is(30));
        Assert.assertThat(list.pop(), Is.is(30));
        Assert.assertThat(list.pop(), Is.is(20));
        Assert.assertThat(list.size(), Is.is(1));
    }


}
