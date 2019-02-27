import Iterator.LinkInterator;
import Iterator.LinkedList;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkIteratorTest {
    @Test
    public void test_reset_nextLink_atEnd(){
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Sergey2", 30);
        itr.reset();
        Assert.assertThat(itr.getCurrent().name, Is.is("Sergey2"));
        itr.nextLink();
        Assert.assertThat(itr.getCurrent().name, Is.is("Sergey"));
        itr.nextLink();
        Assert.assertThat(itr.getCurrent().name, Is.is("Artem"));
        Assert.assertTrue(itr.atEnd());
        itr.reset();
        Assert.assertThat(itr.deleteCurrent(), Is.is("Sergey2"));


    }
}
