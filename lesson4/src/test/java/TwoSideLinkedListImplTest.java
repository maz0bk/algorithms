import linkedlist.LinkedList;
import linkedlist.SimpleLinkedListImpl;
import linkedlist.twoside.TwoSideLinkedListImpl;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TwoSideLinkedListImplTest {
    @Test
    public void test_insert_isEmpty(){
        TwoSideLinkedListImpl<Integer> list = new TwoSideLinkedListImpl<>();
        list.insertLeft(10);
        list.insertLeft(20);
        list.insertLeft(30);
        list.insertRight(100);
        list.insertRight(200);
        list.insertRight(300);

        Assert.assertThat(list.removeLeft(), Is.is(30));
        Assert.assertThat(list.removeLeft(), Is.is(20));
        Assert.assertFalse(list.remove(30));
        Assert.assertTrue(list.remove(300));

    }
}
