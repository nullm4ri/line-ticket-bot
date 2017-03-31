package com.suhyunkim.ticket.interpark;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suhyunkim.ticket.BaseModel;

import lombok.Data;

/**
 * InterparkSeatResponse
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Data
public class InterparkSeatResponse extends BaseModel {
	private static final long serialVersionUID = 3845967801727777557L;

	@JsonProperty("JSON")
	private List<InterparkSeat> seatList;
}