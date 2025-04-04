package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ParaApagarTest {

    private ParaApagar impl = new ParaApagar();

    @Test
    public void testName() {
        assertEquals(impl.sucessor(1), 2);
    }

    @Test
    public void testName1() {
        assertEquals(impl.sucessor(1), 0);
    }

    

}
