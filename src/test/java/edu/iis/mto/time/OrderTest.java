package edu.iis.mto.time;

import edu.iis.mto.time.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderTimeFactory.class)
public class OrderTest {

    @Test
    public void test() {
        mockStatic(OrderTimeFactory.class);
        OrderTime timeSource = new OrderTime();
        timeSource.getTime().plusHours(20);
        when(OrderTimeFactory.getOrderTime()).thenReturn(timeSource);
        Order order = new Order();
        order.submit();
        order.confirm();
    }
}
