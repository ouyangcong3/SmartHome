package top.timecaser.smarthome;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup tv0,music0,fan0,light0;
    String musics1,tvs1,fans1,lights1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv0=(RadioGroup)findViewById(R.id.gtv) ;
        tv0.setOnCheckedChangeListener(this);
        music0=(RadioGroup)findViewById(R.id.gmusic) ;
        music0.setOnCheckedChangeListener(this);
        fan0=(RadioGroup)findViewById(R.id.gfan) ;
       fan0.setOnCheckedChangeListener(this);
        light0=(RadioGroup)findViewById(R.id.glight) ;
        light0.setOnCheckedChangeListener(this);

        Button update = (Button)findViewById(R.id.button4);
        Button flesh = (Button)findViewById(R.id.button3);
        final EditText acc = (EditText)findViewById(R.id.editText8);

      //  RadioGroup tvstatus = (RadioGroup) findViewById(R.id.gtv);
       // RadioGroup musicstatus = (RadioGroup) findViewById(R.id.gmusic);
      //  RadioGroup lightstatus = (RadioGroup) findViewById(R.id.glight);
       // RadioGroup fanstatus = (RadioGroup) findViewById(R.id.gfan);

       // int id;
       // id=musicstatus.getCheckedRadioButtonId();
      //  final RadioButton musics= (RadioButton)findViewById(id);
       // id=tvstatus.getCheckedRadioButtonId();
      //  final RadioButton tvs= (RadioButton)findViewById(id);
       // id=fanstatus.getCheckedRadioButtonId();
      //  final RadioButton fans= (RadioButton)findViewById(id);
       // id=lightstatus.getCheckedRadioButtonId();
       // final RadioButton lights= (RadioButton)findViewById(id);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             //   final String musics1 = musics.getText().toString();
               // final String tvs1 = tvs.getText().toString().trim();
               // final String fans1 = fans.getText().toString().trim();
               // final String lights1 = lights.getText().toString().trim();
                final String acc1 = acc.getText().toString().trim();
               // calc();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection cn= DriverManager.getConnection("jdbc:mysql://101.201.234.9:3306/smarthome?useUnicode=true&characterEncoding=UTF-8","root","ou302775954");
                            String sql="update furniture set MUSIC='"+musics1+"' ,TV='"+tvs1+"',LIGHT='"+lights1+"',FAN='"+fans1+"',AC='"+acc1+"'";
                            Statement st=(Statement)cn.createStatement();
                            st.executeUpdate(sql);

                            cn.close();
                            st.close();

                        } catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        flesh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView st1=(TextView)findViewById(R.id.textView12);
                final TextView st2=(TextView)findViewById(R.id.textView14);
                final TextView st3=(TextView)findViewById(R.id.textView15);
                final TextView st4=(TextView)findViewById(R.id.textView16);
                final TextView st5=(TextView)findViewById(R.id.textView11);
                final TextView st6=(TextView)findViewById(R.id.textView8);
                final String sa[]=new String[5];
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection cn= DriverManager.getConnection("jdbc:mysql://101.201.234.9:3306/smarthome?useUnicode=true&characterEncoding=UTF-8","root","ou302775954");
                            Statement st=(Statement)cn.createStatement();
                            String sql="select * from furniture";
                            ResultSet rs=st.executeQuery(sql);
                            if(rs.next())
                            {
                                sa[0]=rs.getString(1);
                                sa[1]=rs.getString(2);
                                sa[2]=rs.getString(3);
                                sa[3]=rs.getString(4);
                                sa[4]=rs.getString(5);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    st1.setText(sa[1]);
                                    st2.setText(sa[0]);
                                    st3.setText(sa[2]);
                                    st4.setText(sa[3]);
                                    st5.setText(sa[4]);
                                }
                            });
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        calc();
    }

    private void calc() {
        if (tv0.getCheckedRadioButtonId()==R.id.radioButton){tvs1="ON";}
        else{tvs1="OFF";}
        if (music0.getCheckedRadioButtonId()==R.id.radioButton12){musics1="ON";}
        else{musics1="OFF";}
        if (fan0.getCheckedRadioButtonId()==R.id.radioButton7){fans1="ON";}
        else{fans1="OFF";}
        if (light0.getCheckedRadioButtonId()==R.id.radioButton4){lights1="ON";}
        else{lights1="OFF";}

    }
    public void goBack(View v) {
        finish(); // 結束 Activity, 即可回到前一个 Activity
    }
}
