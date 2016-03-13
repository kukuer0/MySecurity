package mysecurity.wencheng.com.mysecurity.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import mysecurity.wencheng.com.mysecurity.utils.CommonUtils;
import mysecurity.wencheng.com.mysecurity.R;

public class SplashActivity extends AppCompatActivity {

    private TextView mVersionText;
    private int mVersion;
    private String mDesc;
    private String mDownLoadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        initView();
        initVersionName();
        initVersionCode();
    }


    private void initView() {

        mVersionText = (TextView) findViewById(R.id.splash_version_txt);
    }

    /*compare the version to the internet*/
    private void initVersionName() {
        String versionName = CommonUtils.getVersionName(this);
        if (!TextUtils.isEmpty(versionName)) {

            mVersionText.setText("Version:" + versionName);
        } else {
            mVersionText.setText("CopyRight of Jim");

        }

    }

    /*fetch method*/
    private void initVersionCode() {
        int versionCode = CommonUtils.getVersionCode(this);
        checkVersion(versionCode);
    }


    /*visit internet,get internet versioncode*/
    private void checkVersion(int versionCode) {

        String url = "http://10.0.0.17:8080/info.json";

       /* use tow method: 1.use xutils 2.use volley*/
        parseForxutils(url, versionCode);

        //2.use volley
//        parserForVolley(url, versionCode);

    }

    private void parserForVolley(String url, final int versionCode) {
        RequestQueue requestQueue = Volley.newRequestQueue(SplashActivity.this);

       StringRequest request =  new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                compareVersion(versionCode,s);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("volleyTag","volleyerror");
                loadMainUi();

            }
        });

        requestQueue.add(request);
    }

    /*xutils method*/
    private void parseForxutils(String url, final int versionCode) {
        HttpUtils httpUtils = new HttpUtils(3000);
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                compareVersion(versionCode, responseInfo.result);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                e.printStackTrace();
                loadMainUi();
            }
        });


    }

    private void compareVersion(int versionCode, String result) {
//        {"downloadurl":"http://10.0.0.17:8080/mysecurity-debug.apk","version":2,"desc":"下载安装送大礼包"}
        try {
            JSONObject jsonObject = new JSONObject(result);
            mDownLoadUrl = jsonObject.getString("downloadurl");
            mVersion = jsonObject.getInt("version");
            mDesc = jsonObject.getString("desc");
            Log.i("PARSE_TARGER", mDownLoadUrl + ", " + mVersion + "," + mDesc);

            if (versionCode <= mVersion) {
                //upadate
                hindDailog(mDownLoadUrl, mDesc);
            } else {
                //no update
                loadMainUi();
            }

        } catch (JSONException e) {
            e.printStackTrace();
            loadMainUi();
        }


    }

    private void hindDailog(String mDownLoadUrl, String mDesc) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("NOTICE: UPDATE NEW VERSION").setMessage(mDesc);
        builder.setPositiveButton("update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //download app to update
                upDateApp();
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadMainUi();
                dialog.dismiss();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                loadMainUi();
            }
        });
        builder.show();
    }


    private void upDateApp() {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.download(mDownLoadUrl, "/mnt/sdcard/temp.apk", new RequestCallBack<File>() {
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {
                installApp("/mnt/sdcard/temp.apk");
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(SplashActivity.this, "apk download failure!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });

    }


    private void installApp(String s) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        // 设置数据和类型
        // 第一个参数：uri
        // 第二个参数：类型
        intent.setDataAndType(Uri.fromFile(new File(s)),
                "application/vnd.android.package-archive");

        startActivityForResult(intent, 0);

    }

    /*load main activity*/
    private void loadMainUi() {
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this, MainActivity.class);
        startActivity(intent);

    }


}
