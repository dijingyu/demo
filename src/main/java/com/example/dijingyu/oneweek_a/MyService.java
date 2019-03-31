package com.example.dijingyu.oneweek_a;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 作者：邸某某
 * 时间：2019/3/31
 */

public interface MyService {

    String http = "http://c.m.163.com/nc/article/list/T1348654151579/";
    @GET("0-20.html")
    Observable<Bean> getData();


}
