import linkedlist.LinkedList;
import linkedlist.SimpleLinkedListImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class SimpleLinkedListImplTest {

    @Test
    public void test_insert_isEmpty(){
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        Assert.assertTrue(list.isEmpty());
        list.insert(10);
        list.insert(20);
        list.insert(30);
        Assert.assertThat(list.getSize(), Is.is(3));
        Assert.assertFalse(list.isEmpty());

    }
    @Test
    public void test_remove_getFirst_find(){
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        Assert.assertThat(list.remove(), Is.is(30));
        Assert.assertThat(list.getFirstElement(), Is.is(20));
        Assert.assertTrue(list.find(10));
        Assert.assertFalse(list.find(101));

    }
}
