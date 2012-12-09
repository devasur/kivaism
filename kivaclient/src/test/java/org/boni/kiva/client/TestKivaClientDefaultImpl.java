package org.boni.kiva.client;

import org.junit.Test;
import org.kiva.service.ApiLevel;
import org.kiva.service.KivaClient;
import org.kiva.service.impl.KivaClientFactory;
import org.kiva.service.impl.UnSupportedAPilevelException;

public class TestKivaClientDefaultImpl {

	@Test
	public void testKivaClient() throws Exception{
		KivaClient client = KivaClientFactory.getKivaClient(ApiLevel.V1);
	}
}
