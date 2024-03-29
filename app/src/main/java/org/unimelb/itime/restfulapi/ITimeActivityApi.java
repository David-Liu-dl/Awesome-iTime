package org.unimelb.itime.restfulapi;

import org.unimelb.itime.bean.MessageGroup;
import org.unimelb.itime.bean.MessageGroupRetrofitBody;
import org.unimelb.itime.restfulresponse.HttpResult;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Paul on 10/8/17.
 */

public interface ITimeActivityApi {
    @GET("message_group/list")
    Observable<HttpResult<List<MessageGroup>>> list(@Query("syncToken") String syncToken);


    @POST("message_group/read")
    Observable<HttpResult<List<MessageGroup>>> read(@Body MessageGroupRetrofitBody messageGroupRetrofitBody);

    @POST("message_group/read_all")
    Observable<HttpResult<List<MessageGroup>>> readAll(@Query("isRead") int isRead);
}
