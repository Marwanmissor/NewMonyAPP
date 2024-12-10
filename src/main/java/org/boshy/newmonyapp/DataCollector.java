package org.boshy.newmonyapp;

public class DataCollector {
    public static Data Helwan1 = new Data("حلوان 1");
    public static Data Helwan2 = new Data("حلوان 2");
    public static Data HaHelwan = new Data("حدايق حلوان");
    public static Data Friday = new Data("الجمعه حلوان 1");


    public String toString(String bn){
        return bn == "حلوان 1" ? Helwan1.toString() : bn == "حلوان 2" ? Helwan2.toString() : bn == "حدايق حلوان" ? HaHelwan.toString() : Friday.toString();
    }
    public void getAll(){
        System.out.println(Helwan1.toString());
        System.out.println(Helwan2.toString());
        System.out.println(HaHelwan.toString());
        System.out.println(Friday.toString());
    }
    private boolean hasFriday(){
        return Friday.getTotal() != 0;
    }
//    public String TotalofALL(){
//        String T;
//        float Ttotal = Helwan1.getTotal() + Helwan2.getTotal() + HaHelwan.getTotal() ,
//                Tvisa = Helwan1.getVisa() + Helwan2.getVisa() + HaHelwan.getVisa() ,
//                TsmartWallet = Helwan1.getSmartWallet() + Helwan2.getSmartWallet() + HaHelwan.getSmartWallet();
//        if (hasFriday()){
//            Ttotal += Friday.getTotal();
//            Tvisa += Friday.getVisa();
//            TsmartWallet += Friday.getSmartWallet();
//        }
//
//        T = "\n اجمالي الدخل اليومي لكل الفروع = " + Ttotal;
//        if (Tvisa != 0){
//            T+= "\n اجمالي الفيزا لكل الفروع = " + Tvisa;
//        }
//        if (TsmartWallet != 0){
//            T+= "\n اجمالي المحفظه الالكترونيه لكل الفروع = " + TsmartWallet;
//        }
//        T+= "\n اجمالي الكل = " + (Helwan1.getCash() + Helwan2.getCash() + HaHelwan.getCash() + Friday.getCash());
//        return T;
//    }
public String TotalofALL() {
    String T;
    float Ttotal = Helwan1.getTotal() + Helwan2.getTotal() + HaHelwan.getTotal(),
            Tvisa = Helwan1.getVisa() + Helwan2.getVisa() + HaHelwan.getVisa(),
            TsmartWallet = Helwan1.getSmartWallet() + Helwan2.getSmartWallet() + HaHelwan.getSmartWallet();
    if (hasFriday()) {
        Ttotal += Friday.getTotal();
        Tvisa += Friday.getVisa();
        TsmartWallet += Friday.getSmartWallet();
    }

    T = "\n اجمالي الدخل اليومي لكل الفروع = " + formatNumber(Ttotal);
    if (Tvisa != 0) {
        T += "\n اجمالي الفيزا لكل الفروع = " + formatNumber(Tvisa);
    }
    if (TsmartWallet != 0) {
        T += "\n اجمالي المحفظه الالكترونيه لكل الفروع = " + formatNumber(TsmartWallet);
    }
    T += "\n اجمالي الكل = " + formatNumber(Helwan1.getCash() + Helwan2.getCash() + HaHelwan.getCash() + Friday.getCash());
    return T;
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