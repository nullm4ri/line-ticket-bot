/**
 * @(#) TicketBotApplication.class $version 2017. 03. 29
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suhyunkim.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TicketBotApplication
 *
 * @author Suhyun Kim (k.i.m@navercorp.com)
 */
@SpringBootApplication
public class TicketBotApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketBotApplication.class, args);
	}
}