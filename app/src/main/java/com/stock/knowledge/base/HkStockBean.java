package com.stock.knowledge.base;

import java.util.List;

public class HkStockBean {

    /**
     * error_code : 0
     * reason : SUCCESSED!
     * result : {"totalCount":"318","page":"1","num":"20","data":[{"symbol":"00001","name":"长和","engname":"CHEUNG KONG","tradetype":"EQTY","lasttrade":"51.200","prevclose":"49.800","open":"49.050","high":"51.350","low":"49.050","volume":"8842157","currentvolume":"25500","amount":"447686834","ticktime":"2020-07-02 15:32:21","buy":"51.100","sell":"51.250","high_52week":"78.850","low_52week":"45.050","eps":"10.330","dividend":"0.000","stocks_sum":"3856240500","pricechange":"1.400","changepercent":"2.8112450"},{"symbol":"00002","name":"中电控股","engname":"CLP HOLDINGS","tradetype":"EQTY","lasttrade":"77.100","prevclose":"76.000","open":"75.050","high":"77.200","low":"75.050","volume":"2982419","currentvolume":"2000","amount":"228121561","ticktime":"2020-07-02 15:32:37","buy":"77.050","sell":"77.100","high_52week":"88.750","low_52week":"65.000","eps":"1.840","dividend":null,"stocks_sum":"2526450570","pricechange":"1.100","changepercent":"1.4473684"},{"symbol":"00003","name":"香港中华煤气","engname":"HK & CHINA GAS","tradetype":"EQTY","lasttrade":"12.060","prevclose":"12.000","open":"12.200","high":"12.220","low":"11.960","volume":"15710454","currentvolume":"1000","amount":"189464002","ticktime":"2020-07-02 15:32:37","buy":"12.060","sell":"12.080","high_52week":"18.000","low_52week":"11.740","eps":"0.412","dividend":null,"stocks_sum":"17771304856","pricechange":"0.060","changepercent":"0.5000000"},{"symbol":"00004","name":"九龙仓集团","engname":"WHARF HOLDINGS","tradetype":"EQTY","lasttrade":"15.640","prevclose":"15.760","open":"15.860","high":"15.920","low":"15.500","volume":"3014172","currentvolume":"1000","amount":"47123276","ticktime":"2020-07-02 15:29:12","buy":"15.620","sell":"15.640","high_52week":"22.350","low_52week":"12.040","eps":"0.994","dividend":null,"stocks_sum":"3049427327","pricechange":"-0.120","changepercent":"-0.7614213"},{"symbol":"00005","name":"汇丰控股","engname":"HSBC HOLDINGS","tradetype":"EQTY","lasttrade":"37.150","prevclose":"36.200","open":"37.000","high":"37.200","low":"36.350","volume":"32255422","currentvolume":"400","amount":"1184839659","ticktime":"2020-07-02 15:32:36","buy":"37.100","sell":"37.150","high_52week":"65.700","low_52week":"35.000","eps":"0.300","dividend":null,"stocks_sum":"20691320413","pricechange":"0.950","changepercent":"2.6243094"},{"symbol":"00006","name":"电能实业","engname":"POWER ASSETS","tradetype":"EQTY","lasttrade":"43.600","prevclose":"42.150","open":"42.350","high":"43.700","low":"42.350","volume":"3919228","currentvolume":"25500","amount":"168517293","ticktime":"2020-07-02 15:32:18","buy":"43.600","sell":"43.650","high_52week":"58.500","low_52week":"41.600","eps":"2.992","dividend":null,"stocks_sum":"2134261654","pricechange":"1.450","changepercent":"3.4400949"},{"symbol":"00008","name":"电讯盈科","engname":"PCCW","tradetype":"EQTY","lasttrade":"4.410","prevclose":"4.420","open":"4.420","high":"4.420","low":"4.380","volume":"6051311","currentvolume":"3000","amount":"26632714","ticktime":"2020-07-02 15:32:29","buy":"4.400","sell":"4.410","high_52week":"4.830","low_52week":"3.850","eps":null,"dividend":null,"stocks_sum":"7729638249","pricechange":"-0.010","changepercent":"-0.2262443"},{"symbol":"00010","name":"恒隆集团","engname":"HANG LUNG GROUP","tradetype":"EQTY","lasttrade":"18.800","prevclose":"18.020","open":"18.200","high":"18.880","low":"18.200","volume":"1482000","currentvolume":"1000","amount":"27309760","ticktime":"2020-07-02 15:29:36","buy":"18.780","sell":"18.800","high_52week":"22.650","low_52week":"14.020","eps":"5.010","dividend":null,"stocks_sum":"1361618242","pricechange":"0.780","changepercent":"4.3285239"},{"symbol":"00011","name":"恒生银行","engname":"HANG SENG BANK","tradetype":"EQTY","lasttrade":"132.400","prevclose":"130.100","open":"132.500","high":"132.700","low":"131.000","volume":"1753584","currentvolume":"100","amount":"231507157","ticktime":"2020-07-02 15:32:30","buy":"132.300","sell":"132.400","high_52week":"197.400","low_52week":"117.500","eps":"12.770","dividend":null,"stocks_sum":"1911842736","pricechange":"2.300","changepercent":"1.7678709"},{"symbol":"00012","name":"恒基地产","engname":"HENDERSON LAND","tradetype":"EQTY","lasttrade":"30.450","prevclose":"29.400","open":"29.900","high":"30.600","low":"29.500","volume":"4792282","currentvolume":"2000","amount":"144763178","ticktime":"2020-07-02 15:32:07","buy":"30.450","sell":"30.500","high_52week":"44.700","low_52week":"26.050","eps":"3.144","dividend":null,"stocks_sum":"4841387003","pricechange":"1.050","changepercent":"3.5714286"},{"symbol":"00014","name":"希慎兴业","engname":"HYSAN DEV","tradetype":"EQTY","lasttrade":"25.000","prevclose":"24.850","open":"24.600","high":"25.750","low":"24.550","volume":"2101349","currentvolume":"1000","amount":"52993536","ticktime":"2020-07-02 15:31:40","buy":"25.000","sell":"25.050","high_52week":"42.500","low_52week":"20.000","eps":"0.594","dividend":null,"stocks_sum":"1041900891","pricechange":"0.150","changepercent":"0.6036217"},{"symbol":"00016","name":"新鸿基地产","engname":"SHK PPT","tradetype":"EQTY","lasttrade":"101.000","prevclose":"98.950","open":"98.950","high":"101.300","low":"98.950","volume":"8006393","currentvolume":"500","amount":"803570112","ticktime":"2020-07-02 15:32:31","buy":"101.000","sell":"101.100","high_52week":"137.600","low_52week":"87.600","eps":"4.766","dividend":null,"stocks_sum":"2897780274","pricechange":"2.050","changepercent":"2.0717534"},{"symbol":"00019","name":"太古股份公司Ａ","engname":"SWIRE PACIFIC A","tradetype":"EQTY","lasttrade":"41.300","prevclose":"41.100","open":"40.900","high":"41.700","low":"40.850","volume":"4896974","currentvolume":"30500","amount":"202605285","ticktime":"2020-07-02 15:32:24","buy":"41.300","sell":"41.400","high_52week":"99.800","low_52week":"40.150","eps":"6.000","dividend":null,"stocks_sum":"905206000","pricechange":"0.200","changepercent":"0.4866180"},{"symbol":"00020","name":"会德丰","engname":"WHEELOCK","tradetype":"EQTY","lasttrade":"0.000","prevclose":"61.300","open":"0.000","high":"0.000","low":"0.000","volume":"0","currentvolume":"0","amount":"0","ticktime":"2020-07-02 09:20:00","buy":"0.000","sell":"0.000","high_52week":"71.000","low_52week":"43.400","eps":"4.013","dividend":null,"stocks_sum":"2052849287","pricechange":"0.000","changepercent":"0.0000000"},{"symbol":"00023","name":"东亚银行","engname":"BANK OF E ASIA","tradetype":"EQTY","lasttrade":"18.180","prevclose":"17.700","open":"17.860","high":"18.780","low":"17.560","volume":"1586515","currentvolume":"600","amount":"28793098","ticktime":"2020-07-02 15:32:27","buy":"18.180","sell":"18.200","high_52week":"22.950","low_52week":"13.980","eps":"0.797","dividend":null,"stocks_sum":"2914783467","pricechange":"0.480","changepercent":"2.7118644"},{"symbol":"00027","name":"银河娱乐","engname":"GALAXY ENT","tradetype":"EQTY","lasttrade":"53.400","prevclose":"52.750","open":"53.600","high":"53.900","low":"52.500","volume":"11831237","currentvolume":"5000","amount":"630067287","ticktime":"2020-07-02 15:32:16","buy":"53.400","sell":"53.450","high_52week":"63.400","low_52week":"37.000","eps":"0.387","dividend":null,"stocks_sum":"4335518812","pricechange":"0.650","changepercent":"1.2322275"},{"symbol":"00038","name":"第一拖拉机股份","engname":"FIRST TRACTOR","tradetype":"EQTY","lasttrade":"1.920","prevclose":"1.850","open":"1.880","high":"1.920","low":"1.850","volume":"3850000","currentvolume":"2000","amount":"7269920","ticktime":"2020-07-02 15:32:27","buy":"1.910","sell":"1.920","high_52week":"2.600","low_52week":"1.250","eps":"0.062","dividend":null,"stocks_sum":"391940000","pricechange":"0.070","changepercent":"3.7837838"},{"symbol":"00066","name":"港铁公司","engname":"MTR CORPORATION","tradetype":"EQTY","lasttrade":"41.500","prevclose":"40.150","open":"40.650","high":"41.500","low":"40.450","volume":"8654609","currentvolume":"500","amount":"356915755","ticktime":"2020-07-02 15:32:34","buy":"41.450","sell":"41.500","high_52week":"55.750","low_52week":"36.200","eps":"0.249","dividend":null,"stocks_sum":"6159612411","pricechange":"1.350","changepercent":"3.3623910"},{"symbol":"00069","name":"香格里拉（亚洲）","engname":"SHANGRI-LA ASIA","tradetype":"EQTY","lasttrade":"6.730","prevclose":"6.660","open":"6.860","high":"6.860","low":"6.700","volume":"784000","currentvolume":"2000","amount":"5303360","ticktime":"2020-07-02 15:26:27","buy":"6.710","sell":"6.720","high_52week":"10.120","low_52week":"5.110","eps":"0.332","dividend":null,"stocks_sum":"3585525056","pricechange":"0.070","changepercent":"1.0510511"},{"symbol":"00083","name":"信和置业","engname":"SINO LAND","tradetype":"EQTY","lasttrade":"10.220","prevclose":"9.750","open":"10.000","high":"10.260","low":"9.700","volume":"7353134","currentvolume":"2000","amount":"74027227","ticktime":"2020-07-02 15:32:35","buy":"10.200","sell":"10.220","high_52week":"13.760","low_52week":"8.030","eps":"0.400","dividend":null,"stocks_sum":"7045158938","pricechange":"0.470","changepercent":"4.8205128"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * totalCount : 318
         * page : 1
         * num : 20
         * data : [{"symbol":"00001","name":"长和","engname":"CHEUNG KONG","tradetype":"EQTY","lasttrade":"51.200","prevclose":"49.800","open":"49.050","high":"51.350","low":"49.050","volume":"8842157","currentvolume":"25500","amount":"447686834","ticktime":"2020-07-02 15:32:21","buy":"51.100","sell":"51.250","high_52week":"78.850","low_52week":"45.050","eps":"10.330","dividend":"0.000","stocks_sum":"3856240500","pricechange":"1.400","changepercent":"2.8112450"},{"symbol":"00002","name":"中电控股","engname":"CLP HOLDINGS","tradetype":"EQTY","lasttrade":"77.100","prevclose":"76.000","open":"75.050","high":"77.200","low":"75.050","volume":"2982419","currentvolume":"2000","amount":"228121561","ticktime":"2020-07-02 15:32:37","buy":"77.050","sell":"77.100","high_52week":"88.750","low_52week":"65.000","eps":"1.840","dividend":null,"stocks_sum":"2526450570","pricechange":"1.100","changepercent":"1.4473684"},{"symbol":"00003","name":"香港中华煤气","engname":"HK & CHINA GAS","tradetype":"EQTY","lasttrade":"12.060","prevclose":"12.000","open":"12.200","high":"12.220","low":"11.960","volume":"15710454","currentvolume":"1000","amount":"189464002","ticktime":"2020-07-02 15:32:37","buy":"12.060","sell":"12.080","high_52week":"18.000","low_52week":"11.740","eps":"0.412","dividend":null,"stocks_sum":"17771304856","pricechange":"0.060","changepercent":"0.5000000"},{"symbol":"00004","name":"九龙仓集团","engname":"WHARF HOLDINGS","tradetype":"EQTY","lasttrade":"15.640","prevclose":"15.760","open":"15.860","high":"15.920","low":"15.500","volume":"3014172","currentvolume":"1000","amount":"47123276","ticktime":"2020-07-02 15:29:12","buy":"15.620","sell":"15.640","high_52week":"22.350","low_52week":"12.040","eps":"0.994","dividend":null,"stocks_sum":"3049427327","pricechange":"-0.120","changepercent":"-0.7614213"},{"symbol":"00005","name":"汇丰控股","engname":"HSBC HOLDINGS","tradetype":"EQTY","lasttrade":"37.150","prevclose":"36.200","open":"37.000","high":"37.200","low":"36.350","volume":"32255422","currentvolume":"400","amount":"1184839659","ticktime":"2020-07-02 15:32:36","buy":"37.100","sell":"37.150","high_52week":"65.700","low_52week":"35.000","eps":"0.300","dividend":null,"stocks_sum":"20691320413","pricechange":"0.950","changepercent":"2.6243094"},{"symbol":"00006","name":"电能实业","engname":"POWER ASSETS","tradetype":"EQTY","lasttrade":"43.600","prevclose":"42.150","open":"42.350","high":"43.700","low":"42.350","volume":"3919228","currentvolume":"25500","amount":"168517293","ticktime":"2020-07-02 15:32:18","buy":"43.600","sell":"43.650","high_52week":"58.500","low_52week":"41.600","eps":"2.992","dividend":null,"stocks_sum":"2134261654","pricechange":"1.450","changepercent":"3.4400949"},{"symbol":"00008","name":"电讯盈科","engname":"PCCW","tradetype":"EQTY","lasttrade":"4.410","prevclose":"4.420","open":"4.420","high":"4.420","low":"4.380","volume":"6051311","currentvolume":"3000","amount":"26632714","ticktime":"2020-07-02 15:32:29","buy":"4.400","sell":"4.410","high_52week":"4.830","low_52week":"3.850","eps":null,"dividend":null,"stocks_sum":"7729638249","pricechange":"-0.010","changepercent":"-0.2262443"},{"symbol":"00010","name":"恒隆集团","engname":"HANG LUNG GROUP","tradetype":"EQTY","lasttrade":"18.800","prevclose":"18.020","open":"18.200","high":"18.880","low":"18.200","volume":"1482000","currentvolume":"1000","amount":"27309760","ticktime":"2020-07-02 15:29:36","buy":"18.780","sell":"18.800","high_52week":"22.650","low_52week":"14.020","eps":"5.010","dividend":null,"stocks_sum":"1361618242","pricechange":"0.780","changepercent":"4.3285239"},{"symbol":"00011","name":"恒生银行","engname":"HANG SENG BANK","tradetype":"EQTY","lasttrade":"132.400","prevclose":"130.100","open":"132.500","high":"132.700","low":"131.000","volume":"1753584","currentvolume":"100","amount":"231507157","ticktime":"2020-07-02 15:32:30","buy":"132.300","sell":"132.400","high_52week":"197.400","low_52week":"117.500","eps":"12.770","dividend":null,"stocks_sum":"1911842736","pricechange":"2.300","changepercent":"1.7678709"},{"symbol":"00012","name":"恒基地产","engname":"HENDERSON LAND","tradetype":"EQTY","lasttrade":"30.450","prevclose":"29.400","open":"29.900","high":"30.600","low":"29.500","volume":"4792282","currentvolume":"2000","amount":"144763178","ticktime":"2020-07-02 15:32:07","buy":"30.450","sell":"30.500","high_52week":"44.700","low_52week":"26.050","eps":"3.144","dividend":null,"stocks_sum":"4841387003","pricechange":"1.050","changepercent":"3.5714286"},{"symbol":"00014","name":"希慎兴业","engname":"HYSAN DEV","tradetype":"EQTY","lasttrade":"25.000","prevclose":"24.850","open":"24.600","high":"25.750","low":"24.550","volume":"2101349","currentvolume":"1000","amount":"52993536","ticktime":"2020-07-02 15:31:40","buy":"25.000","sell":"25.050","high_52week":"42.500","low_52week":"20.000","eps":"0.594","dividend":null,"stocks_sum":"1041900891","pricechange":"0.150","changepercent":"0.6036217"},{"symbol":"00016","name":"新鸿基地产","engname":"SHK PPT","tradetype":"EQTY","lasttrade":"101.000","prevclose":"98.950","open":"98.950","high":"101.300","low":"98.950","volume":"8006393","currentvolume":"500","amount":"803570112","ticktime":"2020-07-02 15:32:31","buy":"101.000","sell":"101.100","high_52week":"137.600","low_52week":"87.600","eps":"4.766","dividend":null,"stocks_sum":"2897780274","pricechange":"2.050","changepercent":"2.0717534"},{"symbol":"00019","name":"太古股份公司Ａ","engname":"SWIRE PACIFIC A","tradetype":"EQTY","lasttrade":"41.300","prevclose":"41.100","open":"40.900","high":"41.700","low":"40.850","volume":"4896974","currentvolume":"30500","amount":"202605285","ticktime":"2020-07-02 15:32:24","buy":"41.300","sell":"41.400","high_52week":"99.800","low_52week":"40.150","eps":"6.000","dividend":null,"stocks_sum":"905206000","pricechange":"0.200","changepercent":"0.4866180"},{"symbol":"00020","name":"会德丰","engname":"WHEELOCK","tradetype":"EQTY","lasttrade":"0.000","prevclose":"61.300","open":"0.000","high":"0.000","low":"0.000","volume":"0","currentvolume":"0","amount":"0","ticktime":"2020-07-02 09:20:00","buy":"0.000","sell":"0.000","high_52week":"71.000","low_52week":"43.400","eps":"4.013","dividend":null,"stocks_sum":"2052849287","pricechange":"0.000","changepercent":"0.0000000"},{"symbol":"00023","name":"东亚银行","engname":"BANK OF E ASIA","tradetype":"EQTY","lasttrade":"18.180","prevclose":"17.700","open":"17.860","high":"18.780","low":"17.560","volume":"1586515","currentvolume":"600","amount":"28793098","ticktime":"2020-07-02 15:32:27","buy":"18.180","sell":"18.200","high_52week":"22.950","low_52week":"13.980","eps":"0.797","dividend":null,"stocks_sum":"2914783467","pricechange":"0.480","changepercent":"2.7118644"},{"symbol":"00027","name":"银河娱乐","engname":"GALAXY ENT","tradetype":"EQTY","lasttrade":"53.400","prevclose":"52.750","open":"53.600","high":"53.900","low":"52.500","volume":"11831237","currentvolume":"5000","amount":"630067287","ticktime":"2020-07-02 15:32:16","buy":"53.400","sell":"53.450","high_52week":"63.400","low_52week":"37.000","eps":"0.387","dividend":null,"stocks_sum":"4335518812","pricechange":"0.650","changepercent":"1.2322275"},{"symbol":"00038","name":"第一拖拉机股份","engname":"FIRST TRACTOR","tradetype":"EQTY","lasttrade":"1.920","prevclose":"1.850","open":"1.880","high":"1.920","low":"1.850","volume":"3850000","currentvolume":"2000","amount":"7269920","ticktime":"2020-07-02 15:32:27","buy":"1.910","sell":"1.920","high_52week":"2.600","low_52week":"1.250","eps":"0.062","dividend":null,"stocks_sum":"391940000","pricechange":"0.070","changepercent":"3.7837838"},{"symbol":"00066","name":"港铁公司","engname":"MTR CORPORATION","tradetype":"EQTY","lasttrade":"41.500","prevclose":"40.150","open":"40.650","high":"41.500","low":"40.450","volume":"8654609","currentvolume":"500","amount":"356915755","ticktime":"2020-07-02 15:32:34","buy":"41.450","sell":"41.500","high_52week":"55.750","low_52week":"36.200","eps":"0.249","dividend":null,"stocks_sum":"6159612411","pricechange":"1.350","changepercent":"3.3623910"},{"symbol":"00069","name":"香格里拉（亚洲）","engname":"SHANGRI-LA ASIA","tradetype":"EQTY","lasttrade":"6.730","prevclose":"6.660","open":"6.860","high":"6.860","low":"6.700","volume":"784000","currentvolume":"2000","amount":"5303360","ticktime":"2020-07-02 15:26:27","buy":"6.710","sell":"6.720","high_52week":"10.120","low_52week":"5.110","eps":"0.332","dividend":null,"stocks_sum":"3585525056","pricechange":"0.070","changepercent":"1.0510511"},{"symbol":"00083","name":"信和置业","engname":"SINO LAND","tradetype":"EQTY","lasttrade":"10.220","prevclose":"9.750","open":"10.000","high":"10.260","low":"9.700","volume":"7353134","currentvolume":"2000","amount":"74027227","ticktime":"2020-07-02 15:32:35","buy":"10.200","sell":"10.220","high_52week":"13.760","low_52week":"8.030","eps":"0.400","dividend":null,"stocks_sum":"7045158938","pricechange":"0.470","changepercent":"4.8205128"}]
         */

        private String totalCount;
        private String page;
        private String num;
        private List<DataBean> data;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * symbol : 00001
             * name : 长和
             * engname : CHEUNG KONG
             * tradetype : EQTY
             * lasttrade : 51.200
             * prevclose : 49.800
             * open : 49.050
             * high : 51.350
             * low : 49.050
             * volume : 8842157
             * currentvolume : 25500
             * amount : 447686834
             * ticktime : 2020-07-02 15:32:21
             * buy : 51.100
             * sell : 51.250
             * high_52week : 78.850
             * low_52week : 45.050
             * eps : 10.330
             * dividend : 0.000
             * stocks_sum : 3856240500
             * pricechange : 1.400
             * changepercent : 2.8112450
             */

            private String symbol;
            private String name;
            private String engname;
            private String tradetype;
            private String lasttrade;
            private String prevclose;
            private String open;
            private String high;
            private String low;
            private String volume;
            private String currentvolume;
            private String amount;
            private String ticktime;
            private String buy;
            private String sell;
            private String high_52week;
            private String low_52week;
            private String eps;
            private String dividend;
            private String stocks_sum;
            private String pricechange;
            private String changepercent;

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEngname() {
                return engname;
            }

            public void setEngname(String engname) {
                this.engname = engname;
            }

            public String getTradetype() {
                return tradetype;
            }

            public void setTradetype(String tradetype) {
                this.tradetype = tradetype;
            }

            public String getLasttrade() {
                return lasttrade;
            }

            public void setLasttrade(String lasttrade) {
                this.lasttrade = lasttrade;
            }

            public String getPrevclose() {
                return prevclose;
            }

            public void setPrevclose(String prevclose) {
                this.prevclose = prevclose;
            }

            public String getOpen() {
                return open;
            }

            public void setOpen(String open) {
                this.open = open;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getCurrentvolume() {
                return currentvolume;
            }

            public void setCurrentvolume(String currentvolume) {
                this.currentvolume = currentvolume;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getTicktime() {
                return ticktime;
            }

            public void setTicktime(String ticktime) {
                this.ticktime = ticktime;
            }

            public String getBuy() {
                return buy;
            }

            public void setBuy(String buy) {
                this.buy = buy;
            }

            public String getSell() {
                return sell;
            }

            public void setSell(String sell) {
                this.sell = sell;
            }

            public String getHigh_52week() {
                return high_52week;
            }

            public void setHigh_52week(String high_52week) {
                this.high_52week = high_52week;
            }

            public String getLow_52week() {
                return low_52week;
            }

            public void setLow_52week(String low_52week) {
                this.low_52week = low_52week;
            }

            public String getEps() {
                return eps;
            }

            public void setEps(String eps) {
                this.eps = eps;
            }

            public String getDividend() {
                return dividend;
            }

            public void setDividend(String dividend) {
                this.dividend = dividend;
            }

            public String getStocks_sum() {
                return stocks_sum;
            }

            public void setStocks_sum(String stocks_sum) {
                this.stocks_sum = stocks_sum;
            }

            public String getPricechange() {
                return pricechange;
            }

            public void setPricechange(String pricechange) {
                this.pricechange = pricechange;
            }

            public String getChangepercent() {
                return changepercent;
            }

            public void setChangepercent(String changepercent) {
                this.changepercent = changepercent;
            }
        }
    }
}
