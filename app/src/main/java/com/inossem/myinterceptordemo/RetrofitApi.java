package com.inossem.myinterceptordemo;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by caihan on 2017/1/11.
 *
 * @GET 表明这是get请求
 * @POST 表明这是post请求
 * @PUT 表明这是put请求
 * @DELETE 表明这是delete请求
 * @PATCH 表明这是一个patch请求，该请求是对put请求的补充，用于更新局部资源
 * @HEAD 表明这是一个head请求
 * @OPTIONS 表明这是一个option请求
 * @HTTP 通用注解, 可以替换以上所有的注解，其拥有三个属性：method，path，hasBody
 * @Headers 用于添加固定请求头，可以同时添加多个。通过该注解添加的请求头不会相互覆盖，而是共同存在
 * @Header 作为方法的参数传入，用于添加不固定值的Header，该注解会更新已有的请求头
 * @Body 多用于post请求发送非表单数据, 比如想要以post方式传递json格式数据
 * @Filed 多用于post请求中表单字段, Filed和FieldMap需要FormUrlEncoded结合使用
 * @FiledMap 和@Filed作用一致，用于不确定表单参数
 * @Part 用于表单字段, Part和PartMap与Multipart注解结合使用, 适合文件上传的情况
 * @PartMap 用于表单字段, 默认接受的类型是Map<String,REquestBody>，可用于实现多文件上传
 * <p>
 * Part标志上文的内容可以是富媒体形势，比如上传一张图片，上传一段音乐，即它多用于字节流传输。
 * 而Filed则相对简单些，通常是字符串键值对。
 * </p>
 * Part标志上文的内容可以是富媒体形势，比如上传一张图片，上传一段音乐，即它多用于字节流传输。
 * 而Filed则相对简单些，通常是字符串键值对。
 * @Path 用于url中的占位符,{占位符}和PATH只用在URL的path部分，url中的参数使用Query和QueryMap代替，保证接口定义的简洁
 * @Query 用于Get中指定参数
 * @QueryMap 和Query使用类似
 * @Url 指定请求路径
 */

public interface RetrofitApi {

    //图片集合 例子     // 如果有参数为[] 的文件集合
//    File file = new File(路径);
//    RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
//    MultipartBody.Part form = MultipartBody.Part.createFormData("images[]", file.getName(), requestBody);
    //  然后将  MultipartBody.Part 集合传入  files
    @Multipart
    @POST("")
    Call<String> eg(@PartMap Map<String, RequestBody> params, @Part List<MultipartBody.Part> files);

//    @Multipart
//    @POST("url")
//    Observable<Object> test2(@Part("user_realname") RequestBody user_realname);
    //使用时候参数
//    RequestBody card_no2 = RequestBody.create(MediaType.parse("multipart/form-data"), card_no);

    //上传视频或者其他文件
//    @Multipart
//    @POST("url")
//    Call<Object> uploadVedio(@Part("vedioTitle") RequestBody vedioTitle, @Part MultipartBody.Part file);
    //使用时候参数
//    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//    MultipartBody.Part bodyFile = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

    // 分类列表
    @POST("shop/goods/getGoodsClass")
    Call<String> getGoodsClass();

}
