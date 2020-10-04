package com.saptco.tr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Repository;

import com.saptco.common.hbm.CRMContactsBean;
import com.saptco.common.hbm.CRMTicketsBean;
import com.saptco.tr.dao.TRDao;
import com.saptco.tr.dto.response.CRMCustomersResponse;
import com.saptco.tr.dto.response.CRMTicketsResponse;
import com.saptco.tr.dto.response.MobileSystemConfigDto;

@Repository("tRDao")
public class TRDaoImpl implements TRDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public MobileSystemConfigDto getMobileSystemConfig() throws Exception {
		MobileSystemConfigDto systemConfigurationDto = new MobileSystemConfigDto();
		StoredProcedureQuery query = entityManager
		    .createStoredProcedureQuery("XX_SAPTCO_LOOKUPS.GET_ONLINE_SYS_CONFIG")
		    .registerStoredProcedureParameter(1, String.class, 
		         ParameterMode.OUT)
		    .registerStoredProcedureParameter(2, String.class, 
		         ParameterMode.OUT)
		    .registerStoredProcedureParameter(3, String.class, 
			         ParameterMode.OUT);

		query.execute();
		systemConfigurationDto.setDisplaySearchPopup(
				BooleanUtils.toBoolean(Integer.parseInt((String) query.getOutputParameterValue(1))));
		systemConfigurationDto.setKioskLogOut(Integer.parseInt((String) query.getOutputParameterValue(2)));
		systemConfigurationDto.setAllowSellerOTP(
				BooleanUtils.toBoolean(Integer.parseInt((String) query.getOutputParameterValue(3))));
		return systemConfigurationDto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CRMTicketsResponse getCRMTRData(String saptcoPNR, String ticketNumber) throws Exception {
		List<CRMTicketsBean> responseList = new ArrayList<CRMTicketsBean>();
		StoredProcedureQuery query = entityManager
		    .createStoredProcedureQuery("TR_INTEG_USER.XX_CRM_DATA.GET_PNR_DETAILS",CRMTicketsBean.class)
		    .registerStoredProcedureParameter("P_SAPTCO_PNR", String.class, 
		         ParameterMode.IN)
		    .registerStoredProcedureParameter("P_TICKET_NUMBER", String.class, 
		         ParameterMode.IN)
		    .registerStoredProcedureParameter("P_RESULT", Void.class, 
			         ParameterMode.REF_CURSOR)
		    .registerStoredProcedureParameter("P_RTRN_CD", String.class, 
			         ParameterMode.OUT)
		    .registerStoredProcedureParameter("P_RTRN_DESC", String.class, 
			         ParameterMode.OUT)
		    .setParameter("P_SAPTCO_PNR", saptcoPNR)
		    .setParameter("P_TICKET_NUMBER", ticketNumber);
		query.execute();
		responseList = query.getResultList();
//		if(resultCur != null && !resultCur.isEmpty()) {
//			resultCur.forEach(row -> {
//				CRMTicketsBean responseObj = new CRMTicketsBean();
//				responseObj.setSaptcoPNR((String) row[1]);
//				responseObj.setTicketNumber((String) row[1]);
//				responseObj.setTripCode((String) row[2]);
//				responseObj.setTripTypeAr((String) row[3]);
//				responseObj.setTripTypeEn((String) row[4]);
//				responseObj.setFromStationAr((String) row[5]);
//				responseObj.setFromStationEn((String) row[6]);
//				responseObj.setToStationAr((String) row[7]);
//				responseObj.setToStationEn((String) row[8]);
//				responseObj.setCustomerName((String) row[9]);
//				responseObj.setTicketFare((BigDecimal) row[10]);
//				responseObj.setTaxAmount((BigDecimal) row[11]);
//				responseObj.setTicketStatusAr((String) row[12]);
//				responseObj.setTicketStatusEn((String) row[13]);
//				responseObj.setPaymentMethodAr((String) row[14]);
//				responseObj.setPaymentMethodEn((String) row[15]);
//				responseObj.setIssueDate((String) row[16]);
//				responseObj.setTripDate((String) row[17]);
//				responseObj.setIdTypeAr((String) row[18]);
//				responseObj.setIdTypeEn((String) row[19]);
//				responseObj.setPoiNumber((String) row[20]);
//				responseObj.setNationalityAr((String) row[21]);
//				responseObj.setNationalityEn((String) row[22]);
//				responseObj.setDateOfBirth((String) row[23]);
//				responseObj.setMobileNumber((String) row[24]);
//				responseObj.setEmail((String) row[25]);
//				responseObj.setBusNumber((String) row[26]);
//				responseObj.setBusLocation((String) row[27]);
//				responseObj.setDriver1Number((String) row[28]);
//				responseObj.setDriver1Name((String) row[29]);
//				responseObj.setDriver1NationalityAr((String) row[30]);
//				responseObj.setDriver1NationalityEn((String) row[31]);
//				responseObj.setDriver2Number((String) row[32]);
//				responseObj.setDriver2Name((String) row[33]);
//				responseObj.setDriver2NationalityAr((String) row[34]);
//				responseObj.setDriver2NationalityEn((String) row[35]);
//				responseObj.setSdpAr((String) row[36]);
//				responseObj.setSdpEn((String) row[37]);
//				responseObj.setSdpTypeAr((String) row[38]);
//				responseObj.setSdpTypeEn((String) row[39]);
//				responseObj.setUserNumber((String) row[40]);
//				responseObj.setUpdatedDate((String) row[41]);
//				responseObj.setUpdatedUserName((String) row[42]);
//				responseList.add(responseObj);
//			});
//		}
		CRMTicketsResponse ticketsResponse = new CRMTicketsResponse();
		ticketsResponse.setTicketsList(responseList);
		ticketsResponse.setErrorCode((String) query.getOutputParameterValue("P_RTRN_CD"));
		ticketsResponse.setErrorCode((String) query.getOutputParameterValue("P_RTRN_DESC"));
		return ticketsResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CRMCustomersResponse getCRMTRCustomers(String fromDate, String toDate) throws Exception {
		List<CRMContactsBean> responseList = new ArrayList<CRMContactsBean>();
		StoredProcedureQuery query = entityManager
		    .createStoredProcedureQuery("TR_INTEG_USER.XX_CRM_DATA.GET_CUSTOMER_DETAILS",CRMContactsBean.class)
		    .registerStoredProcedureParameter("P_FROM_DATE", String.class, 
		         ParameterMode.IN)
		    .registerStoredProcedureParameter("P_TO_DATE", String.class, 
		         ParameterMode.IN)
		    .registerStoredProcedureParameter("P_RESULT", Void.class, 
			         ParameterMode.REF_CURSOR)
		    .registerStoredProcedureParameter("P_RTRN_CD", String.class, 
			         ParameterMode.OUT)
		    .registerStoredProcedureParameter("P_RTRN_DESC", String.class, 
			         ParameterMode.OUT)
		    .setParameter("P_FROM_DATE", fromDate)
		    .setParameter("P_TO_DATE", toDate);
		query.execute();
		responseList = query.getResultList();
		CRMCustomersResponse customersResponse = new CRMCustomersResponse();
		customersResponse.setCustomersList(responseList);
		customersResponse.setErrorCode((String) query.getOutputParameterValue("P_RTRN_CD"));
		customersResponse.setErrorCode((String) query.getOutputParameterValue("P_RTRN_DESC"));
		return customersResponse;
	}
}
