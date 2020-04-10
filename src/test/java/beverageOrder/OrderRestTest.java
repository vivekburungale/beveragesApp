/*
 * author : Vivek Burungale
 */

package beverageOrder;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.beverage.model.OrderDetails;

public class OrderRestTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getOrderPriceWithoutExclusion() throws Exception {
		String uri = "/order?orderDetails=Coffee";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		List<OrderDetails> order = Arrays.asList(super.mapFromJson(content, OrderDetails[].class));
		// OrderDetails[] orderlist = super.mapFromJson(content, OrderDetails[].class);
		/*
		 * for (OrderDetails obj : order) { String itemName = obj.getItemName();
		 * assertEquals("Coffee", itemName); }
		 */
		assertEquals(order.size(), 1);
	}

	@Test
	public void getOrderPriceWithExclusionItem() throws Exception {
		String uri = "/order?orderDetails=Chai,-sugar,-milk";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		// OrderDetails order = super.mapFromJson(content, OrderDetails.class);
		List<OrderDetails> order = Arrays.asList(super.mapFromJson(content, OrderDetails[].class));
		// OrderDetails[] orderlist = super.mapFromJson(content, OrderDetails[].class);
		/*
		 * String itemName = order.getItemName(); assertEquals("Chai", itemName);
		 * assertNotNull(order.getExclusionItem()); assertEquals("2.5",
		 * order.getOrderPrice());
		 */
		assertEquals(order.size(), 1);

	}

	@Test
	public void getOrderPriceWithInvalidMenuItem() throws Exception {
		String uri = "/order?orderDetails=Tea,-sugar,-milk";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		// OrderDetails order = super.mapFromJson(content, OrderDetails.class);
		List<OrderDetails> order = Arrays.asList(super.mapFromJson(content, OrderDetails[].class));
		// OrderDetails[] orderlist = super.mapFromJson(content, OrderDetails[].class);
		/*
		 * String itemName = order.getItemName(); assertEquals("Chai", itemName);
		 * assertNotNull(order.getExclusionItem()); assertEquals("2.5",
		 * order.getOrderPrice());
		 */
		for (OrderDetails obj : order) {
			assertEquals(obj.getStatus(), "Item Not Found");
		}
		
	}
	
	@Test
	public void getOrderPriceForMultipleMenuItem() throws Exception {
		String uri = "/order?orderDetails=\"Chai,-sugar\",\"Chai\",\"Coffee,-milk\"";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		// OrderDetails order = super.mapFromJson(content, OrderDetails.class);
		List<OrderDetails> order = Arrays.asList(super.mapFromJson(content, OrderDetails[].class));
		// OrderDetails[] orderlist = super.mapFromJson(content, OrderDetails[].class);
		/*
		 * String itemName = order.getItemName(); assertEquals("Chai", itemName);
		 * assertNotNull(order.getExclusionItem()); assertEquals("2.5",
		 * order.getOrderPrice());
		 */
		System.out.println("Size" + order.size());
		assertEquals(order.size(), 3);
		
	}

}