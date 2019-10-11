package com.inossem.myinterceptordemo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        // 1.通过传进来的Chain获取Request
        Request request = chain.request();

        // 2. 处理 Request  逻辑自己写

        // 3. 调用Chain的proceed（Request）方法处理请求，得到Response
        Response response = chain.proceed(request);

        // 4. 处理Response ， 逻辑自己写

        // 5. 返回Responce
        return response;
    }
}
