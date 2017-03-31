package com.suhyunkim.ticket;

import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suhyunkim.ticket.interpark.InterparkSeatResponse;

/**
 * com.suhyunkim.ticket.InterparkSeatTest
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InterparkSeatTest {
	//	@Autowired
	//	private TestRestTemplate testRestTemplate;

	private TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	public void testSeatBo() throws IOException {
		String body = get("17003607", "14000135");

		String jsonString = getMatchedResponse(body);

		ObjectMapper mapper = new ObjectMapper();
		InterparkSeatResponse seat = mapper.readValue(jsonString, InterparkSeatResponse.class);
	}

	private String getMatchedResponse(String body) {
		Pattern pattern = Pattern.compile("\\((.*?)\\)");
		Matcher m = pattern.matcher(body);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	// ticket.interpark.com/Ticket/Goods/GoodsInfoJSON.asp?Flag=RemainSeat&GoodsCode=17003607&PlaceCode=14000135&PlaySeq=001&Callback=fnPlaySeqChangeCallBack
	private String get(String goodsCode, String placeCode) {
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

		URI uri = UriComponentsBuilder.fromHttpUrl(
			"http://ticket.interpark.com/Ticket/Goods/GoodsInfoJSON.asp").queryParams(params).build().toUri();

		ResponseEntity<String> response = testRestTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		return response.getBody();
	}
}