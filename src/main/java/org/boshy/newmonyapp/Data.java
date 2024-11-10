package org.boshy.newmonyapp;

public class Data {
    private String BranchName;
    private float Total;
    private float Visa;
    private float SmartWallet;
    private float Cash;

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
        setCash();
    }

    public float getVisa() {
        return Visa;
    }

    public void setVisa(float visa) {
        Visa = visa;
        setCash();
    }

    public float getSmartWallet() {
        return SmartWallet;
    }

    public void setSmartWallet(float smartWallet) {
        SmartWallet = smartWallet;
        setCash();
    }

    public float getCash() {
        return Cash;
    }

    public void setCash() {
        Cash = Total - Visa - SmartWallet;
    }

    @Override
    public String toString() {
    String dataToTxt = new String("\n اسم الفرع : " + this.BranchName);
    if (this.Total == 0 ){
        dataToTxt += "\n للاسف لا يوجد ايراد لهذا الفرع اليوم";
        return dataToTxt ;
    }else {
        dataToTxt += "\n الدخل اليومي = " + this.Total;
    }
    if (this.Visa != 0){
        dataToTxt += "\n الفيزا = " + this.Visa;
    }
    if (this.SmartWallet != 0){
            dataToTxt += "\n المحفظه الالكترونيه = " +this.SmartWallet;
        }
        return dataToTxt + "\n الاجمالي = " + getCash() ;
    }
}
