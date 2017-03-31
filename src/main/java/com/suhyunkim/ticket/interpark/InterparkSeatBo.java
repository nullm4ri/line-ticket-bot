package com.suhyunkim.ticket.interpark;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * InterparkSeatBo
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Service
public class InterparkSeatBo {
	@Autowired
	private InterparkSeatClient client;

	public List<InterparkSeat> getRemainSeat(String goodsCode, String placeCode) throws IOException {
		//		String body = client.get("17003607", "14000135");
		String body = client.get(goodsCode, placeCode);
		return getRemainSeat(body);
	}

	private List<InterparkSeat> getRemainSeat(String body) throws IOException {
		String jsonString = getMatchedResponse(body);
		ObjectMapper mapper = new ObjectMapper();
		InterparkSeatResponse seat = mapper.readValue(jsonString, InterparkSeatResponse.class);
		return seat.getSeatList();
	}

	private String getMatchedResponse(String body) {
		Pattern pattern = Pattern.compile("\\((.*?)\\)");
		Matcher m = pattern.matcher(body);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}
}