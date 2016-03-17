package mysecurity.wencheng.com.mysecurity.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wang on 2016/3/18.
 */
public class SharedPrefUtils {


    public static SharedPreferences sp;

    public static String getString(Context context,String key,String defaultValue){
        if(null == sp){
            sp = context.getSharedPreferences(Constant.SP_CONFIG,Context.MODE_PRIVATE);
        }
        return  sp.getString(key,defaultValue);
    }

    public static void putString(Context context,String key,String value){

        if(null == sp){
            sp = context.getSharedPreferences(Constant.SP_CONFIG,Context.MODE_PRIVATE);
        }
        sp.edit().putString(key,value).commit();
    }


}
