package com.gmail.khanhit100896.myapplication;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.khanhit100896.myapplication.Service.XPSApiEndpoint;
import com.gmail.khanhit100896.myapplication.Service.XPSClient;
import com.gmail.khanhit100896.myapplication.Service.XPSCredsParam;
import com.google.gson.Gson;

import org.json.JSONObject;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName, edtPassword;
    Button btnLogin;
    CheckBox chkRemember;
    TextView txtSignUp;

    private final String getURL = "https://test01.e300.vn/web/session/authenticate";
    private final String db = "hhd_e300_vn_test01";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("DataLoginWithEmail",MODE_PRIVATE);

        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();

            }
        });
    }

    private void init() {
        edtUserName     = findViewById(R.id.edtUserName);
        edtPassword     = findViewById(R.id.edtpassword);
        btnLogin        =findViewById(R.id.btnLogin);
        chkRemember     = findViewById(R.id.chkRemember);
        txtSignUp       = findViewById(R.id.txtSignUp);
        txtSignUp.setPaintFlags(txtSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        edtUserName.setText(sharedPreferences.getString("email",""));
        edtPassword.setText(sharedPreferences.getString("password",""));
        chkRemember.setChecked(sharedPreferences.getBoolean("checked",false));
    }

    private void saveEmailPassword(String email, String password){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(chkRemember.isChecked()){
            editor.putString("email",email);
            editor.putString("password",password);
            editor.putBoolean("checked",true);
            editor.commit();
        }
        else{
            editor.remove("email");
            editor.remove("password");
            editor.remove("checked");
            editor.commit();
        }
    }

    private boolean doLogin(String username , String password) {
        XPSApiEndpoint xps = XPSClient.getXPSClient();
        try {
            Call<String> call = xps.authenticate(new XPSCredsParam(db, username, password));
            JSONObject objectResponse = new JSONObject(call.execute().body());

            Toast.makeText(getApplicationContext(),objectResponse.getString("session_id") + "",Toast.LENGTH_SHORT).show();

            if(objectResponse.has("result")) {
                Gson gson = new Gson();
                ResultUserLogin user = gson.fromJson(objectResponse.getString("result"), ResultUserLogin.class);
                XPSClient xpsClient = new XPSClient();
                xpsClient.session_id=user.getSession_id();
                return  true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

    private void postData(){
        final String username = edtUserName.getText().toString();
        final String password = edtPassword.getText().toString();
        if(!username.equals("") && !password.equals("")){
            saveEmailPassword(username,password);
            doLogin(username,password);
        }else{
            Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
        }
    }
}
