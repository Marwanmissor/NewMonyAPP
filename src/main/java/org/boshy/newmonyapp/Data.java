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
    Data(String branchName){
        this.BranchName = branchName;
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
//    public String toString() {
//    String dataToTxt = new String("\n اسم الفرع : " + this.BranchName);
//    if (this.Total == 0 ){
//        dataToTxt += "\n للاسف لا يوجد ايراد لهذا الفرع اليوم";
//        return dataToTxt ;
//    }else {
//        dataToTxt += "\n الدخل اليومي = " + this.Total;
//    }
//    if (this.Visa != 0){
//        dataToTxt += "\n الفيزا = " + this.Visa;
//    }
//    if (this.SmartWallet != 0){
//            dataToTxt += "\n المحفظه الالكترونيه = " +this.SmartWallet;
//        }
//        return dataToTxt + "\n الاجمالي = " + getCash() ;
//    }
    public String toString() {
        String dataToTxt = "\n اسم الفرع : " + this.BranchName;
        if (this.Total == 0) {
            dataToTxt += "\n للاسف لا يوجد ايراد لهذا الفرع اليوم";
            return dataToTxt;
        } else {
            dataToTxt += "\n الدخل اليومي = " + formatNumber(this.Total);
        }
        if (this.Visa != 0) {
            dataToTxt += "\n الفيزا = " + formatNumber(this.Visa);
        }
        if (this.SmartWallet != 0) {
            dataToTxt += "\n المحفظه الالكترونيه = " + formatNumber(this.SmartWallet);
        }
        return dataToTxt + "\n الاجمالي = " + formatNumber(getCash());
    }

    // إضافة دالة لتنسيق الأرقام
    private String formatNumber(float number) {
        if (number == (int) number) {
            return String.valueOf((int) number); // إذا كان عدد صحيح
        } else {
            return String.valueOf(number); // إذا كان عدد عشري
        }
    }

}
