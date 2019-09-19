package com.huowolf.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnowflakeApplicationTests {

	@Autowired
	private Snowflake snowflake;

	private static ExecutorService executor= new ThreadPoolExecutor(5, 10,
			60L, TimeUnit.SECONDS,
			new LinkedBlockingQueue<>());

	private Set<Long> set = ConcurrentHashMap.newKeySet();
	//private CopyOnWriteArraySet set = new CopyOnWriteArraySet();

	@Test
	public void contextLoads() throws InterruptedException {

		for (int i = 0; i < 2000; i++) {
			executor.execute(() -> {
				long id = snowflake.nextId();
				set.add(id);
			});

		}
		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(set.size());
	}

}
