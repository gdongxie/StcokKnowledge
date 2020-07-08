package com.stock.knowledge.beans;

import java.util.List;

public class UsaStockBean {

    /**
     * error_code : 0
     * reason : SUCCESSED!
     * result : {"totalCount":"4329","page":"1","num":"20","data":[{"cname":"苹果公司","category":"计算机","symbol":"AAPL","price":"364.11","diff":"-0.69","chg":"-0.19","preclose":"364.80","open":"365.12","high":"367.36","low":"363.91","amplitude":"0.95%","volume":"27684309","mktcap":"1578174653359","market":"NASDAQ"},{"cname":"微软公司","category":"软件","symbol":"MSFT","price":"204.70","diff":"1.19","chg":"0.58","preclose":"203.51","open":"203.14","high":"206.35","low":"201.77","amplitude":"2.25%","volume":"32061206","mktcap":"1552330195418","market":"NASDAQ"},{"cname":"亚马逊公司","category":"互联网","symbol":"AMZN","price":"2878.70","diff":"119.88","chg":"4.35","preclose":"2758.82","open":"2757.99","high":"2895.00","low":"2754.00","amplitude":"5.11%","volume":"6363439","mktcap":"1435826538964","market":"NASDAQ"},{"cname":"谷歌A类股","category":"媒体内容","symbol":"GOOGL","price":"1442.00","diff":"23.95","chg":"1.69","preclose":"1418.05","open":"1419.17","high":"1448.48","low":"1414.18","amplitude":"2.42%","volume":"2109124","mktcap":"984338347146","market":"NASDAQ"},{"cname":"谷歌","category":"互联网","symbol":"GOOG","price":"1438.04","diff":"24.43","chg":"1.73","preclose":"1413.61","open":"1411.10","high":"1443.00","low":"1409.82","amplitude":"2.35%","volume":"1775167","mktcap":"981635197767","market":"NASDAQ"},{"cname":"Facebook","category":"媒体内容","symbol":"FB","price":"237.55","diff":"10.48","chg":"4.62","preclose":"227.07","open":"228.50","high":"239.00","low":"227.56","amplitude":"5.04%","volume":"43399339","mktcap":"676804497610","market":"NASDAQ"},{"cname":"领航 国际股票 ETF","category":"股权","symbol":"VXUS","price":"49.42","diff":"0.25","chg":"0.51","preclose":"49.17","open":"49.20","high":"49.56","low":"49.19","amplitude":"0.75%","volume":"2796398","mktcap":"335084802943","market":"NASDAQ"},{"cname":"英特尔公司","category":"半导体","symbol":"INTC","price":"58.81","diff":"-1.02","chg":"-1.70","preclose":"59.83","open":"59.91","high":"60.03","low":"58.76","amplitude":"2.12%","volume":"14748072","mktcap":"249001545815","market":"NASDAQ"},{"cname":"英伟达公司","category":"半导体","symbol":"NVDA","price":"381.20","diff":"1.29","chg":"0.34","preclose":"379.91","open":"380.83","high":"383.03","low":"376.52","amplitude":"1.71%","volume":"8166070","mktcap":"234438008270","market":"NASDAQ"},{"cname":"奈飞公司","category":"","symbol":"NFLX","price":"485.64","diff":"30.60","chg":"6.72","preclose":"455.04","open":"454.00","high":"488.23","low":"454.00","amplitude":"7.52%","volume":"9705870","mktcap":"213586438000","market":"NASDAQ"},{"cname":"Adobe","category":"软件","symbol":"ADBE","price":"439.81","diff":"4.50","chg":"1.03","preclose":"435.31","open":"434.80","high":"442.05","low":"433.62","amplitude":"1.94%","volume":"2581983","mktcap":"210961568033","market":"NASDAQ"},{"cname":"PayPal","category":null,"symbol":"PYPL","price":"177.43","diff":"3.20","chg":"1.84","preclose":"174.23","open":"174.62","high":"178.24","low":"172.56","amplitude":"3.26%","volume":"6869584","mktcap":"208331355984","market":"NASDAQ"},{"cname":"特斯拉","category":"汽车制造","symbol":"TSLA","price":"1119.63","diff":"39.82","chg":"3.69","preclose":"1079.81","open":"1083.00","high":"1135.33","low":"1080.50","amplitude":"5.08%","volume":"13326896","mktcap":"207663924894","market":"NASDAQ"},{"cname":"思科系统公司","category":"电信","symbol":"CSCO","price":"46.06","diff":"-0.58","chg":"-1.24","preclose":"46.64","open":"46.54","high":"46.72","low":"46.00","amplitude":"1.54%","volume":"17129255","mktcap":"194478968863","market":"NASDAQ"},{"cname":"康卡斯特公司","category":"媒体","symbol":"CMCSA","price":"39.70","diff":"0.72","chg":"1.85","preclose":"38.98","open":"39.61","high":"40.21","low":"39.40","amplitude":"2.08%","volume":"18269683","mktcap":"181197060917","market":"NASDAQ"},{"cname":"阿斯麦公司","category":"半导体","symbol":"ASML","price":"367.59","diff":"-0.44","chg":"-0.12","preclose":"368.03","open":"368.03","high":"370.19","low":"365.27","amplitude":"1.34%","volume":"516687","mktcap":"156308453987","market":"NASDAQ"},{"cname":"安进公司","category":"生物技术","symbol":"AMGN","price":"255.12","diff":"19.26","chg":"8.17","preclose":"235.86","open":"235.52","high":"256.23","low":"232.58","amplitude":"10.03%","volume":"6575764","mktcap":"150073673561","market":"NASDAQ"},{"cname":"开市客公司","category":"","symbol":"COST","price":"304.75","diff":"1.54","chg":"0.51","preclose":"303.21","open":"302.50","high":"305.58","low":"300.75","amplitude":"1.59%","volume":"1906372","mktcap":"134554350927","market":"NASDAQ"},{"cname":"Vanguard国际全债市指数ETF","category":"股权","symbol":"BNDX","price":"57.55","diff":"-0.13","chg":"-0.23","preclose":"57.68","open":"57.50","high":"57.55","low":"57.45","amplitude":"0.17%","volume":"2960641","mktcap":"128251403201","market":"NASDAQ"},{"cname":"博通","category":"半导体","symbol":"AVGO","price":"312.73","diff":"-2.88","chg":"-0.91","preclose":"315.61","open":"315.11","high":"316.85","low":"311.94","amplitude":"1.56%","volume":"1566197","mktcap":"125775407971","market":"NASDAQ"}]}
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
         * totalCount : 4329
         * page : 1
         * num : 20
         * data : [{"cname":"苹果公司","category":"计算机","symbol":"AAPL","price":"364.11","diff":"-0.69","chg":"-0.19","preclose":"364.80","open":"365.12","high":"367.36","low":"363.91","amplitude":"0.95%","volume":"27684309","mktcap":"1578174653359","market":"NASDAQ"},{"cname":"微软公司","category":"软件","symbol":"MSFT","price":"204.70","diff":"1.19","chg":"0.58","preclose":"203.51","open":"203.14","high":"206.35","low":"201.77","amplitude":"2.25%","volume":"32061206","mktcap":"1552330195418","market":"NASDAQ"},{"cname":"亚马逊公司","category":"互联网","symbol":"AMZN","price":"2878.70","diff":"119.88","chg":"4.35","preclose":"2758.82","open":"2757.99","high":"2895.00","low":"2754.00","amplitude":"5.11%","volume":"6363439","mktcap":"1435826538964","market":"NASDAQ"},{"cname":"谷歌A类股","category":"媒体内容","symbol":"GOOGL","price":"1442.00","diff":"23.95","chg":"1.69","preclose":"1418.05","open":"1419.17","high":"1448.48","low":"1414.18","amplitude":"2.42%","volume":"2109124","mktcap":"984338347146","market":"NASDAQ"},{"cname":"谷歌","category":"互联网","symbol":"GOOG","price":"1438.04","diff":"24.43","chg":"1.73","preclose":"1413.61","open":"1411.10","high":"1443.00","low":"1409.82","amplitude":"2.35%","volume":"1775167","mktcap":"981635197767","market":"NASDAQ"},{"cname":"Facebook","category":"媒体内容","symbol":"FB","price":"237.55","diff":"10.48","chg":"4.62","preclose":"227.07","open":"228.50","high":"239.00","low":"227.56","amplitude":"5.04%","volume":"43399339","mktcap":"676804497610","market":"NASDAQ"},{"cname":"领航 国际股票 ETF","category":"股权","symbol":"VXUS","price":"49.42","diff":"0.25","chg":"0.51","preclose":"49.17","open":"49.20","high":"49.56","low":"49.19","amplitude":"0.75%","volume":"2796398","mktcap":"335084802943","market":"NASDAQ"},{"cname":"英特尔公司","category":"半导体","symbol":"INTC","price":"58.81","diff":"-1.02","chg":"-1.70","preclose":"59.83","open":"59.91","high":"60.03","low":"58.76","amplitude":"2.12%","volume":"14748072","mktcap":"249001545815","market":"NASDAQ"},{"cname":"英伟达公司","category":"半导体","symbol":"NVDA","price":"381.20","diff":"1.29","chg":"0.34","preclose":"379.91","open":"380.83","high":"383.03","low":"376.52","amplitude":"1.71%","volume":"8166070","mktcap":"234438008270","market":"NASDAQ"},{"cname":"奈飞公司","category":"","symbol":"NFLX","price":"485.64","diff":"30.60","chg":"6.72","preclose":"455.04","open":"454.00","high":"488.23","low":"454.00","amplitude":"7.52%","volume":"9705870","mktcap":"213586438000","market":"NASDAQ"},{"cname":"Adobe","category":"软件","symbol":"ADBE","price":"439.81","diff":"4.50","chg":"1.03","preclose":"435.31","open":"434.80","high":"442.05","low":"433.62","amplitude":"1.94%","volume":"2581983","mktcap":"210961568033","market":"NASDAQ"},{"cname":"PayPal","category":null,"symbol":"PYPL","price":"177.43","diff":"3.20","chg":"1.84","preclose":"174.23","open":"174.62","high":"178.24","low":"172.56","amplitude":"3.26%","volume":"6869584","mktcap":"208331355984","market":"NASDAQ"},{"cname":"特斯拉","category":"汽车制造","symbol":"TSLA","price":"1119.63","diff":"39.82","chg":"3.69","preclose":"1079.81","open":"1083.00","high":"1135.33","low":"1080.50","amplitude":"5.08%","volume":"13326896","mktcap":"207663924894","market":"NASDAQ"},{"cname":"思科系统公司","category":"电信","symbol":"CSCO","price":"46.06","diff":"-0.58","chg":"-1.24","preclose":"46.64","open":"46.54","high":"46.72","low":"46.00","amplitude":"1.54%","volume":"17129255","mktcap":"194478968863","market":"NASDAQ"},{"cname":"康卡斯特公司","category":"媒体","symbol":"CMCSA","price":"39.70","diff":"0.72","chg":"1.85","preclose":"38.98","open":"39.61","high":"40.21","low":"39.40","amplitude":"2.08%","volume":"18269683","mktcap":"181197060917","market":"NASDAQ"},{"cname":"阿斯麦公司","category":"半导体","symbol":"ASML","price":"367.59","diff":"-0.44","chg":"-0.12","preclose":"368.03","open":"368.03","high":"370.19","low":"365.27","amplitude":"1.34%","volume":"516687","mktcap":"156308453987","market":"NASDAQ"},{"cname":"安进公司","category":"生物技术","symbol":"AMGN","price":"255.12","diff":"19.26","chg":"8.17","preclose":"235.86","open":"235.52","high":"256.23","low":"232.58","amplitude":"10.03%","volume":"6575764","mktcap":"150073673561","market":"NASDAQ"},{"cname":"开市客公司","category":"","symbol":"COST","price":"304.75","diff":"1.54","chg":"0.51","preclose":"303.21","open":"302.50","high":"305.58","low":"300.75","amplitude":"1.59%","volume":"1906372","mktcap":"134554350927","market":"NASDAQ"},{"cname":"Vanguard国际全债市指数ETF","category":"股权","symbol":"BNDX","price":"57.55","diff":"-0.13","chg":"-0.23","preclose":"57.68","open":"57.50","high":"57.55","low":"57.45","amplitude":"0.17%","volume":"2960641","mktcap":"128251403201","market":"NASDAQ"},{"cname":"博通","category":"半导体","symbol":"AVGO","price":"312.73","diff":"-2.88","chg":"-0.91","preclose":"315.61","open":"315.11","high":"316.85","low":"311.94","amplitude":"1.56%","volume":"1566197","mktcap":"125775407971","market":"NASDAQ"}]
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
             * cname : 苹果公司
             * category : 计算机
             * symbol : AAPL
             * price : 364.11
             * diff : -0.69
             * chg : -0.19
             * preclose : 364.80
             * open : 365.12
             * high : 367.36
             * low : 363.91
             * amplitude : 0.95%
             * volume : 27684309
             * mktcap : 1578174653359
             * market : NASDAQ
             */

            private String cname;
            private String category;
            private String symbol;
            private String price;
            private String diff;
            private String chg;
            private String preclose;
            private String open;
            private String high;
            private String low;
            private String amplitude;
            private String volume;
            private String mktcap;
            private String market;

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDiff() {
                return diff;
            }

            public void setDiff(String diff) {
                this.diff = diff;
            }

            public String getChg() {
                return chg;
            }

            public void setChg(String chg) {
                this.chg = chg;
            }

            public String getPreclose() {
                return preclose;
            }

            public void setPreclose(String preclose) {
                this.preclose = preclose;
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

            public String getAmplitude() {
                return amplitude;
            }

            public void setAmplitude(String amplitude) {
                this.amplitude = amplitude;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getMktcap() {
                return mktcap;
            }

            public void setMktcap(String mktcap) {
                this.mktcap = mktcap;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }
        }
    }
}
