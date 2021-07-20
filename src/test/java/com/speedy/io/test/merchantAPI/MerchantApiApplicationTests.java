package com.speedy.io.test.merchantAPI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles(resolver = JunitProfileResolver.class)
class MerchantApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
