package com.smc.service;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.smc.vo.IpoPlanVO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
class IpoPlannedServiceTest {
	@Autowired
	IpoPlannedService ipoPlannedService;

	@Test
	void testAddIpoPlanned() throws Exception {
		IpoPlanVO ipoPlanVO = new IpoPlanVO();
		ipoPlanVO.setCompId("24a1b8a0-a72d-4dba-8b66-b8c0c2935466");
		ipoPlanVO.setExchangeId("8e5f4075-7994-4c07-b2d6-f0e26fbf05cc");
		ipoPlanVO.setOpenDate(new Date(2020, 06, 22));
		ipoPlanVO.setPricePerShare(new BigDecimal(170.33));
		ipoPlanVO.setTotalShare(new BigDecimal(1000000));
		ipoPlanVO.setRemarks("test remakrs");
		this.ipoPlannedService.addIpoPlanned(ipoPlanVO);
	}


}
