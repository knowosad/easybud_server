package pl.easybud.server;

//import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.easybud.server.dto.OrderDTO;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests extends AbstractTest{

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void getOrdersList() throws Exception {

		createOrders(2);	//TODO wydzielić ale setUp chyba zbyt ogólnie

		String uri = "/orders/all";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
//		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		OrderDTO[] orders = super.mapFromJson(content, OrderDTO[].class);
		assertAll(
				() -> assertTrue(orders.length > 0),
				() -> assertEquals("test2", orders[1].getName())
		);
//		assertTrue(orders.length > 0);
//		assertEquals("test2", orders[1].getName());
	}

  @Test
  public void createOrderAndCheckIfExistence() throws Exception {
		String uri = "/orders";
    OrderDTO orderDTO = createOrder();
    String inputJson = super.mapToJson(orderDTO);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

  }

	private OrderDTO createOrder() {
    return new OrderDTO("test", "test");
  }

	private void createOrders(int amount) throws Exception {
		String uri = "/orders";
		for (int i = 1; i <= amount; i++ ){
			OrderDTO orderDTO = new OrderDTO("test" + i, "test" + i);
			String inputJson = super.mapToJson(orderDTO);
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).content(inputJson)
					.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		}
	}


//	@Test
//		public void shouldThrowException() {
//			Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
//				throw new UnsupportedOperationException("Not supported");
//			});
//			assertEquals(exception.getMessage(), "Not supported");
//		}

//	@Test
//	public void paramGreetingShouldReturnTailoredMessage() throws Exception {
//
//		this.mockMvc.perform(get("/orders/greeting").param("name", "Spring Community"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
//	}

}
