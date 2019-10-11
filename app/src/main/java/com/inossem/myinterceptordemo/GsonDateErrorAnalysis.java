package com.inossem.myinterceptordemo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GsonDateErrorAnalysis implements JsonDeserializer<Date>, JsonSerializer<Date> {

    private String format = "yyyy-MM-dd HH:mm:ss";

    private GsonDateErrorAnalysis() {
    }

    private static GsonDateErrorAnalysis instance;

    public static synchronized GsonDateErrorAnalysis getInstance() {
        if (instance == null) {
            instance = new GsonDateErrorAnalysis();
        }
        return instance;
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            if (json.getAsString().equals("") || json.getAsString().equals("null")) {//定义为Date类型,如果后台返回""或者null,则返回null
                return null;
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                return simpleDateFormat.parse(json.getAsString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat simplsdfeDateFormat = new SimpleDateFormat(format);
        return new JsonPrimitive(simplsdfeDateFormat.format(src));
    }

}
