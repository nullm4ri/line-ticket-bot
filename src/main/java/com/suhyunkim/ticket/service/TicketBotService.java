/**
 * @(#) TicketBotService.class $version 2017. 03. 29
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suhyunkim.ticket.service;

import com.linecorp.bot.client.exception.LineMessagingException;
import com.linecorp.bot.model.message.Message;

/**
 * TicketBotService
 *
 * @author Suhyun Kim (k.i.m@navercorp.com)
 */
public interface TicketBotService {
	void listen(Message message) throws LineMessagingException;
}