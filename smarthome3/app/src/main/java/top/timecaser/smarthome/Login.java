package top.timecaser.smarthome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends AppCompatActivity {
    private EditText yhm;
    private EditText pwd;
    private CheckBox cb_remember;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = this.getSharedPreferences("config", this.MODE_PRIVATE);


        cb_remember = (CheckBox) findViewById(R.id.cb_remember);

        Button dlu = (Button)this.findViewById(R.id.button);
        Button chz = (Button)this.findViewById(R.id.button2);
         yhm = (EditText)this.findViewById(R.id.editText);
         pwd = (EditText)this.findViewById(R.id.editText2);
        restoreInfo();
        dlu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String sname = yhm.getText().toString().trim();
                final String spwd = pwd.getText().toString().trim();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection cn= DriverManager.getConnection("jdbc:mysql://101.201.234.9:3306/smarthome?useUnicode=true&characterEncoding=UTF-8","root","ou302775954");
                            String sql="select password from manager where user='" + sname + "\'";
                            Statement st=(Statement)cn.createStatement();
                            ResultSet rs=st.executeQuery(sql);
                            while(rs.next()){
                                String ppwd=rs.getString("password");
                                if(spwd.equals(ppwd)) {

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (cb_remember.isChecked()) {
                                                // 被选中状态，需要记录用户名和密码
                                                // 3.将数据保存到sp文件中
                                                SharedPreferences.Editor editor = sp.edit();
                                                editor.putString("user1", sname);
                                                editor.putString("password1", spwd);
                                                editor.commit();// 提交数据，类似关闭流，事务
                                            }

                                            gotoMainActivity();
                                        }
                                    });
                                }
                                else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Login.this, "登陆失败", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                Log.i("Mainactivity",ppwd);
                            }
                            cn.close();
                            st.close();
                            rs.close();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        chz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                yhm.setText("");
                pwd.setText("");
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("user1", "");
                editor.putString("password1", "");
                editor.commit();// 提交数据，类似关闭流，事务
            }
        });

    }


    private void gotoMainActivity() {
        Intent it = new Intent(this, MainActivity.class); //创建 Intent 并设置目标 Activity
        startActivity(it); // 启动 Intent 中的目标 Activity
    }
    private void restoreInfo() {
        String user1 = sp.getString("user1", "");
        String pwd1 = sp.getString("password1", "");
        yhm.setText(user1);
        pwd.setText(pwd1);
    }

}
