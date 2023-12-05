package com.beta.replyservice;

import com.beta.replyservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {

	private ReplyService replyService;
	@Autowired
	public ReplyController(ReplyService replyService)
	{
		this.replyService = replyService;
	}
	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}

	@GetMapping("/v2/reply/{message}")
	public ReplyMessage getReplyV2(@PathVariable String message)
	{
		return new ReplyMessage(replyService.processStringV2(message));
	}
}