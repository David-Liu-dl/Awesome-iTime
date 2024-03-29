package org.unimelb.itime.base;

/**
 * Created by yinchuandong on 20/06/2016.
 * define some constants here
 */
public class C {
    public static class api{
        public final static String BASE = "http://dev2.timegenii.com/api/";
//        public final static String BASE = "http://dev.timegenii.com/api/";
//        public final static String BASE = "http://itime.demo.com/api/";
    }

    /**
     * constant value for sharedPreferences
     */
    public static class sp{
        public final static String DEFAULT = "unimelb.org.itime";
        public final static String TOKEN = "unimelb.org.itime.token";
    }

    public static class spkey{
        public final static String ITIME_JWT_TOKEN = "itime_jwt_token";
        public final static String EVENT_LIST_SYNC_TOKEN = "event_list_sync_token";
        public final static String MESSAGE_LIST_SYNC_TOKEN = "message_list_sync_token";
        public final static String USER_UID = "user_uid";
        public final static String USER_ID = "user_id";
    }

    public static class calendar{
        public final static String LAST_USED_CAL = "last_used_calendar";
    }

    public static class dao{
        public final static String SCHEMA_NAME = "itime-db";
    }

    public static class error{
    }


}
