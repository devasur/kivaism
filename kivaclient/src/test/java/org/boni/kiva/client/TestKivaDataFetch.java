package org.boni.kiva.client;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

public class TestKivaDataFetch {
	private static final Log logger = LogFactory.getLog(TestKivaDataFetch.class);
	@Test
	public void testGetLatestLendersJson() throws Exception{
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.getForEntity("http://api.kivaws.org/v1/lenders/newest.json", String.class, new HashMap<String, String>());
		assertNotNull(response);
		logger.info(response.getBody());
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createJsonParser(response.getBody());
	}
}
