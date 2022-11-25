package com.android.developer.techworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.developer.techworld.DAO.AccountDAO;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    //Widget
    private TextInputEditText edt_account_id,edt_account_password;
    private Button btn_login ;
    private CheckBox chk_remember ;
    private void initUI() {
        edt_account_id = findViewById(R.id.edt_account_id);
        edt_account_password = findViewById(R.id.edt_account_password);
        btn_login = findViewById(R.id.btn_login);
        chk_remember = findViewById(R.id.chk_remember);
    }
    AccountDAO accountDAO;
    SharedPreferences sharedPreferences;
    //Var
    private void var() {
        accountDAO = new AccountDAO(this);
        sharedPreferences = getSharedPreferences(MainActivity.PREFS_FILE,MODE_PRIVATE);
    }

    //Launcher UI
    private void launcherUI() {
        if(sharedPreferences.getBoolean("PREFS_REMEMBER",false)){
            edt_account_id.setText(sharedPreferences.getString("ID",""));
            edt_account_password.setText(sharedPreferences.getString("PASSWORD",""));
            chk_remember.setChecked(sharedPreferences.getBoolean("PREFS_REMEMBER",false));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Widget - Var
        initUI();
        var();



        //check Login
        btn_login.setOnClickListener(v -> {
            String id = edt_account_id.getText().toString().trim();
            String pass = edt_account_password.getText().toString().trim();

            if (accountDAO.queryDatabase_Login(id, pass)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("PREFS_REMEMBER", chk_remember.isChecked());
                editor.apply();

                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Username và Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
            }
        });

        //Launcher UI
        launcherUI();
    }
}