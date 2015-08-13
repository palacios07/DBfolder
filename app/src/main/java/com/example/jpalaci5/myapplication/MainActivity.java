package com.example.jpalaci5.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


public class MainActivity extends ActionBarActivity {

    private EditText nameET,ageET,emailTV;
    private Button saveBtn;

    RequestQueue requestQueue;

//    private View.OnClickListener onClickListener=new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            User user=new User();
//            user.setName(nameET.getText().toString());
//            user.setEmail(emailTV.getText().toString());
//            user.setAge(Integer.parseInt(ageET.getText().toString()));
//
//            StringRequest stringRequest=new StringRequest(Request.Method.GET
//                    ,"http://fudora.mybluemix.net/api/v1/save/get?name="+user.getName()+"&email="+user.getEmail()+"&age="+user.getAge()
//                    ,new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
//                }
//            },new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue=MySingelton.getInstance(getApplicationContext()).getRequestQueue();

        nameET=(EditText)findViewById(R.id.nameET);
        emailTV=(EditText)findViewById(R.id.emailET);
        ageET=(EditText)findViewById(R.id.ageET);
        saveBtn=(Button)findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person user=new Person();
                user.setName(nameET.getText().toString());
                user.setEmail(emailTV.getText().toString());
                user.setAge(Integer.parseInt(ageET.getText().toString()));

                StringRequest stringRequest=new StringRequest(Request.Method.GET
                        ,"http://foodapplication.mybluemix.net/api/db/folder/?name="+user.getName()+"&email="+user.getEmail()+"&age="+user.getAge()
                        ,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

                requestQueue.add(stringRequest);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
