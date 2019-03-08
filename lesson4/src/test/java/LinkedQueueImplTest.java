import linkedlist.twoside.LinkedQueueImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueImplTest {
    @Test
    public void test_insert_size_isEmpty(){
        LinkedQueueImpl<Integer> linkedQueue = new LinkedQueueImpl<>();
        Assert.assertTrue(linkedQueue.isEmpty());
        linkedQueue.insert(10);
        linkedQueue.insert(20);
        linkedQueue.insert(30);
        Assert.assertThat(linkedQueue.size(), Is.is(3));
        Assert.assertThat(linkedQueue.peek(), Is.is(10));
        Assert.assertThat(linkedQueue.remove(), Is.is(10));
        Assert.assertThat(linkedQueue.size(), Is.is(2));
        Assert.assertThat(linkedQueue.peek(), Is.is(20));
    }
}
