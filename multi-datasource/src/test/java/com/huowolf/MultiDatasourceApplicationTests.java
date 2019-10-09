package com.huowolf;

import com.github.jsonzou.jmockdata.JMockData;
import com.huowolf.model.TOrder;
import com.huowolf.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatasourceApplicationTests {

	@Autowired
	private OrderService orderService;

	@Test
	public void insertTest() {
		for (int i = 0; i < 99; i++) {
			TOrder tOrder = JMockData.mock(TOrder.class);
			orderService.insert(tOrder);
		}

	}

	@Test
	public void insertToMasterTest() {
		for (int i = 0; i < 99; i++) {
			TOrder tOrder = JMockData.mock(TOrder.class);
			orderService.insertToMaster(tOrder);
		}

	}


	@Test
	public void insertToSlave1Test() {
		for (int i = 0; i < 99; i++) {
			TOrder tOrder = JMockData.mock(TOrder.class);
			orderService.insertToSlave1(tOrder);
		}

	}
}
