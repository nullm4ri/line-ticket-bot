package com.suhyunkim.ticket.interpark;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.suhyunkim.ticket.BaseModel;

import lombok.Data;

/**
 * InterparkSeat
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterparkSeat extends BaseModel {
	private static final long serialVersionUID = -3356993738509508921L;

	@JsonProperty("SeatGrade")
	private String seatGrade;
	@JsonProperty("SeatGradeName")
	private String seatGradeName;
	@JsonProperty("RemainCnt")
	private String remainCnt;
	@JsonProperty("SalesPrice")
	private String salesPrice;
}