package org.boni.kiva.client;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestKivaDataFetch {
	private static final Log logger = LogFactory.getLog(TestKivaDataFetch.class);
	@Test
	public void testGetLatestLendersJson() throws Exception{
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.getForEntity("http://api.kivaws.org/v1/lenders/newest.json", String.class, new HashMap<String, String>());
		assertNotNull(response);
		logger.info(response.getBody());
		JsonFactory factory = new MappingJsonFactory();
		JsonParser parser = factory.createJsonParser(response.getBody());
	}
}
