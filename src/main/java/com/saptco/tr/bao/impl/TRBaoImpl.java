package com.saptco.tr.bao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saptco.tr.bao.TRBao;
import com.saptco.tr.dao.TRDao;
import com.saptco.tr.dto.response.CRMCustomersResponse;
import com.saptco.tr.dto.response.CRMTicketsResponse;
import com.saptco.tr.dto.response.MobileSystemConfigDto;


@Service("tRBao")
public class TRBaoImpl implements TRBao{

	@Autowired
	private TRDao tRDao;

	public TRDao gettRDao() {
		return tRDao;
	}

	public void settRDao(TRDao tRDao) {
		this.tRDao = tRDao;
	}

	@Override
	public MobileSystemConfigDto getMobileSystemConfig() throws Exception {
		return tRDao.getMobileSystemConfig();
	}

	@Override
	public CRMTicketsResponse getCRMTRData(String saptcoPNR, String ticketNumber) throws Exception {
		return tRDao.getCRMTRData(saptcoPNR,ticketNumber);
	}

	@Override
	public CRMCustomersResponse getCRMTRCustomers(String fromDate, String toDate) throws Exception {
		return tRDao.getCRMTRCustomers(fromDate, toDate);
	}
	
}
