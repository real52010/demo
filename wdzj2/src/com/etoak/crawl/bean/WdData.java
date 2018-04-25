package com.etoak.crawl.bean;


public class WdData {
    
    int index;
    /**
     * 平台
     */
    String platName;
    /**
     * 成交量
     */
    String amount;
    
    /**
     * 平均参考收益率(%)
     */
    String incomeRate;
    
    /**
     *  平均借款期限(月)
     */
    String loanPeriod;
    /**
     * 待还余额(万元)
     */
    String stayStillOfTotal;
    
    
    /**
     * Returns this index object.
     * @return this index
     */
    public int getIndex() {
        return index;
    }

    
    /**
     * Sets this index.
     * @param index this index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns this platName object.
     * @return this platName
     */
    public String getPlatName() {
        return platName;
    }
    
    /**
     * Sets this platName.
     * @param platName this platName to set
     */
    public void setPlatName(String platName) {
        this.platName = platName;
    }
    
    /**
     * Returns this amount object.
     * @return this amount
     */
    public String getAmount() {
        return amount;
    }
    
    /**
     * Sets this amount.
     * @param amount this amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    /**
     * Returns this incomeRate object.
     * @return this incomeRate
     */
    public String getIncomeRate() {
        return incomeRate;
    }
    
    /**
     * Sets this incomeRate.
     * @param incomeRate this incomeRate to set
     */
    public void setIncomeRate(String incomeRate) {
        this.incomeRate = incomeRate;
    }
    
    /**
     * Returns this loanPeriod object.
     * @return this loanPeriod
     */
    public String getLoanPeriod() {
        return loanPeriod;
    }
    
    /**
     * Sets this loanPeriod.
     * @param loanPeriod this loanPeriod to set
     */
    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
    
    /**
     * Returns this stayStillOfTotal object.
     * @return this stayStillOfTotal
     */
    public String getStayStillOfTotal() {
        return stayStillOfTotal;
    }
    
    /**
     * Sets this stayStillOfTotal.
     * @param stayStillOfTotal this stayStillOfTotal to set
     */
    public void setStayStillOfTotal(String stayStillOfTotal) {
        this.stayStillOfTotal = stayStillOfTotal;
    }
    
    
    
}
