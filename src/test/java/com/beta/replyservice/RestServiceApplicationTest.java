package com.beta.replyservice;

import com.beta.replyservice.exception.InvalidArgumentException;
import com.beta.replyservice.service.ReplyService;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RestServiceApplicationTest {

	private final ReplyService replyService = new ReplyService();
	@Test
	public void contextLoads() {
	}
	@Test
	public void testProcessStringV2()
	{
		assertEquals("kbzw9ru",replyService.processStringV2("11-kbzw9ru"));
		assertEquals("5a8973b3b1fafaeaadf10e195c6e1dd4",replyService.processStringV2("12-kbzw9ru"));
		assertEquals("e8501e64cf0a9fa45e3c25aa9e77ffd5",replyService.processStringV2("22-kbzw9ru"));
	}

	@Test
	public void testInvalidInput()
	{
		InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
				()->replyService.processStringV2("13-kbzw9ru"));
		assertEquals("Invalid input",exception.getMessage());
	}
}
