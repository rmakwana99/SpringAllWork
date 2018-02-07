
package com.rahul.phmc.om.billing.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author rahul
 * 
 * It contains all PHMC OM billing database fields and its setter and getter method
 */
@XmlRootElement
@Entity
@Table(name="PHMC_OM_BILLING")
@DynamicInsert
@DynamicUpdate
public class PHMC_OM_BILLING {
	
	
	
	private transient Long PHMC_OM_BillingID;
	@Id
	private Long PHMC_OM_PCOID;
	private String PHMC_PATH_JAN;
	private String PHMC_PATH_FEB;
	private String PHMC_PATH_MAR;
	private String PHMC_PATH_APR;
	private String PHMC_PATH_MAY;
	private String PHMC_PATH_JUN;
	private String PHMC_PATH_JUL;
	private String PHMC_PATH_AUG;
	private String PHMC_PATH_SEP;
	private String PHMC_PATH_OCT;
	private String PHMC_PATH_NOV;
	private String PHMC_PATH_DEC;
	private String PHMC_PDF_JAN;
	private String PHMC_PDF_FEB;
	private String PHMC_PDF_MAR;
	private String PHMC_PDF_APR;
	private String PHMC_PDF_MAY;
	private String PHMC_PDF_JUN;
	private String PHMC_PDF_JUL;
	private String PHMC_PDF_AUG;
	private String PHMC_PDF_SEP;
	private String PHMC_PDF_OCT;
	private String PHMC_PDF_NOV;
	private String PHMC_PDF_DEC;
	private Integer PHMC_IsStatementSent;
	private Date PHMC_BillingRecycleDate;
	private Date PHMC_LastBilledDate;
	private String PHMC_PATH_CurrentBill;
	private String PHMC_PDF_CurrentBill;
	

	public Long getPHMC_OM_BillingID() {
		return PHMC_OM_BillingID;
	}

	public void setPHMC_OM_BillingID(Long pHMC_OM_BillingID) {
		PHMC_OM_BillingID = pHMC_OM_BillingID;
	}

	public Long getPHMC_OM_PCOID() {
		return PHMC_OM_PCOID;
	}

	public void setPHMC_OM_PCOID(Long pHMC_OM_PCOID) {
		PHMC_OM_PCOID = pHMC_OM_PCOID;
	}

	public String getPHMC_PATH_JAN() {
		return PHMC_PATH_JAN;
	}

	public void setPHMC_PATH_JAN(String pHMC_PATH_JAN) {
		PHMC_PATH_JAN = pHMC_PATH_JAN;
	}

	public String getPHMC_PATH_FEB() {
		return PHMC_PATH_FEB;
	}

	public void setPHMC_PATH_FEB(String pHMC_PATH_FEB) {
		PHMC_PATH_FEB = pHMC_PATH_FEB;
	}

	public String getPHMC_PATH_MAR() {
		return PHMC_PATH_MAR;
	}

	public void setPHMC_PATH_MAR(String pHMC_PATH_MAR) {
		PHMC_PATH_MAR = pHMC_PATH_MAR;
	}

	public String getPHMC_PATH_APR() {
		return PHMC_PATH_APR;
	}

	public void setPHMC_PATH_APR(String pHMC_PATH_APR) {
		PHMC_PATH_APR = pHMC_PATH_APR;
	}

	public String getPHMC_PATH_MAY() {
		return PHMC_PATH_MAY;
	}

	public void setPHMC_PATH_MAY(String pHMC_PATH_MAY) {
		PHMC_PATH_MAY = pHMC_PATH_MAY;
	}

	public String getPHMC_PATH_JUN() {
		return PHMC_PATH_JUN;
	}

	public void setPHMC_PATH_JUN(String pHMC_PATH_JUN) {
		PHMC_PATH_JUN = pHMC_PATH_JUN;
	}

	public String getPHMC_PATH_JUL() {
		return PHMC_PATH_JUL;
	}

	public void setPHMC_PATH_JUL(String pHMC_PATH_JUL) {
		PHMC_PATH_JUL = pHMC_PATH_JUL;
	}

	public String getPHMC_PATH_AUG() {
		return PHMC_PATH_AUG;
	}

	public void setPHMC_PATH_AUG(String pHMC_PATH_AUG) {
		PHMC_PATH_AUG = pHMC_PATH_AUG;
	}

	public String getPHMC_PATH_SEP() {
		return PHMC_PATH_SEP;
	}

	public void setPHMC_PATH_SEP(String pHMC_PATH_SEP) {
		PHMC_PATH_SEP = pHMC_PATH_SEP;
	}

	public String getPHMC_PATH_OCT() {
		return PHMC_PATH_OCT;
	}

	public void setPHMC_PATH_OCT(String pHMC_PATH_OCT) {
		PHMC_PATH_OCT = pHMC_PATH_OCT;
	}

	public String getPHMC_PATH_NOV() {
		return PHMC_PATH_NOV;
	}

	public void setPHMC_PATH_NOV(String pHMC_PATH_NOV) {
		PHMC_PATH_NOV = pHMC_PATH_NOV;
	}

	public String getPHMC_PATH_DEC() {
		return PHMC_PATH_DEC;
	}

	public void setPHMC_PATH_DEC(String pHMC_PATH_DEC) {
		PHMC_PATH_DEC = pHMC_PATH_DEC;
	}

	public String getPHMC_PDF_JAN() {
		return PHMC_PDF_JAN;
	}

	public void setPHMC_PDF_JAN(String pHMC_PDF_JAN) {
		PHMC_PDF_JAN = pHMC_PDF_JAN;
	}

	public String getPHMC_PDF_FEB() {
		return PHMC_PDF_FEB;
	}

	public void setPHMC_PDF_FEB(String pHMC_PDF_FEB) {
		PHMC_PDF_FEB = pHMC_PDF_FEB;
	}

	public String getPHMC_PDF_MAR() {
		return PHMC_PDF_MAR;
	}

	public void setPHMC_PDF_MAR(String pHMC_PDF_MAR) {
		PHMC_PDF_MAR = pHMC_PDF_MAR;
	}

	public String getPHMC_PDF_APR() {
		return PHMC_PDF_APR;
	}

	public void setPHMC_PDF_APR(String pHMC_PDF_APR) {
		PHMC_PDF_APR = pHMC_PDF_APR;
	}

	public String getPHMC_PDF_MAY() {
		return PHMC_PDF_MAY;
	}

	public void setPHMC_PDF_MAY(String pHMC_PDF_MAY) {
		PHMC_PDF_MAY = pHMC_PDF_MAY;
	}

	public String getPHMC_PDF_JUN() {
		return PHMC_PDF_JUN;
	}

	public void setPHMC_PDF_JUN(String pHMC_PDF_JUN) {
		PHMC_PDF_JUN = pHMC_PDF_JUN;
	}

	public String getPHMC_PDF_JUL() {
		return PHMC_PDF_JUL;
	}

	public void setPHMC_PDF_JUL(String pHMC_PDF_JUL) {
		PHMC_PDF_JUL = pHMC_PDF_JUL;
	}

	public String getPHMC_PDF_AUG() {
		return PHMC_PDF_AUG;
	}

	public void setPHMC_PDF_AUG(String pHMC_PDF_AUG) {
		PHMC_PDF_AUG = pHMC_PDF_AUG;
	}

	public String getPHMC_PDF_SEP() {
		return PHMC_PDF_SEP;
	}

	public void setPHMC_PDF_SEP(String pHMC_PDF_SEP) {
		PHMC_PDF_SEP = pHMC_PDF_SEP;
	}

	public String getPHMC_PDF_OCT() {
		return PHMC_PDF_OCT;
	}

	public void setPHMC_PDF_OCT(String pHMC_PDF_OCT) {
		PHMC_PDF_OCT = pHMC_PDF_OCT;
	}

	public String getPHMC_PDF_NOV() {
		return PHMC_PDF_NOV;
	}

	public void setPHMC_PDF_NOV(String pHMC_PDF_NOV) {
		PHMC_PDF_NOV = pHMC_PDF_NOV;
	}

	public String getPHMC_PDF_DEC() {
		return PHMC_PDF_DEC;
	}

	public void setPHMC_PDF_DEC(String pHMC_PDF_DEC) {
		PHMC_PDF_DEC = pHMC_PDF_DEC;
	}

	public Integer getPHMC_IsStatementSent() {
		return PHMC_IsStatementSent;
	}

	public void setPHMC_IsStatementSent(Integer pHMC_IsStatementSent) {
		PHMC_IsStatementSent = pHMC_IsStatementSent;
	}

	public Date getPHMC_BillingRecycleDate() {
		return PHMC_BillingRecycleDate;
	}

	public void setPHMC_BillingRecycleDate(Date pHMC_BillingRecycleDate) {
		PHMC_BillingRecycleDate = pHMC_BillingRecycleDate;
	}

	public Date getPHMC_LastBilledDate() {
		return PHMC_LastBilledDate;
	}

	public void setPHMC_LastBilledDate(Date pHMC_LastBilledDate) {
		PHMC_LastBilledDate = pHMC_LastBilledDate;
	}

	public String getPHMC_PATH_CurrentBill() {
		return PHMC_PATH_CurrentBill;
	}

	public void setPHMC_PATH_CurrentBill(String pHMC_PATH_CurrentBill) {
		PHMC_PATH_CurrentBill = pHMC_PATH_CurrentBill;
	}

	public String getPHMC_PDF_CurrentBill() {
		return PHMC_PDF_CurrentBill;
	}

	public void setPHMC_PDF_CurrentBill(String pHMC_PDF_CurrentBill) {
		PHMC_PDF_CurrentBill = pHMC_PDF_CurrentBill;
	}

	
	
	
	
	

}
