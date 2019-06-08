package com.fy.fanying20190603.core;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:33
 * @Description：描述信息
 */
public interface ConteatInterfac {
    public interface PresenterInterfac {
        public void getResultsss(String keyword);
        public void  getData(String id);
        public void onDestory();
    }

    public interface Fragment1Interfac {
        public void showResultsss(Object object);
    }
    public interface ActivityInterfac {
        public void showData(Object object);
    }
}
