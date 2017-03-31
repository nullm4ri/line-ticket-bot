package com.suhyunkim.ticket.interpark;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * InterparkSeatClient
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Repository
public class InterparkSeatClient {
	@Autowired
	private RestTemplate restTemplate;

	// ticket.interpark.com/Ticket/Goods/GoodsInfoJSON.asp?Flag=RemainSeat&GoodsCode=17003607&PlaceCode=14000135&PlaySeq=001&Callback=fnPlaySeqChangeCallBack
	public String get(String goodsCode, String placeCode) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("Flag", "RemainSeat");
		params.add("goodsCode", goodsCode);
		params.add("placeCode", placeCode);
		params.add("PlaySeq", "001");
		params.add("Callback", "fnPlaySeqChangeCallBack");

		HttpHeaders headers = new HttpHeaders();
		headers.setConnection("keep-alive");
		headers.set("User-Agent",
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
		headers.set("Accept", "*/*");
		String referer = "http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=" + goodsCode;
		headers.set("Referer", referer);

		HttpEntity entity = new HttpEntity(headers);

		URI uri = UriComponentsBuilder.fromHttpUrl("ticket.interpark.com/Ticket/Goods/GoodsInfoJSON.asp").queryParams(
			params).build().toUri();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		return response.getBody();
	}
}