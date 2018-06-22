package com.example.zihan.sss;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Zihan on 2018/5/23.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");
    }

    @Override
    protected String doInBackground(String... params) {
        String method =params[0];
        if(method.equals("register")){
            return BackgroundRegister(params);
        }else if(method.equals("login")){
            return BackgroundLogin(params);
        }else if(method.equals("createSession")){
            return BackgroundCreateSession(params);
        }else if(method.equals("search")){
            return BackgroundSearchSession(params);
        }
        return "no condition met";
    }

    private String BackgroundSearchSession(String[] params) {
        return "seach session";
    }

    private String BackgroundLogin(String[] params) {
        String login_url = "http://10.0.2.2/login.php";
//        String login_url = "http://www.squareink.xyz/login.php";

        String login_name = params[1];
        String login_pass = params[2];
        try {
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String data = URLEncoder.encode("login_name", "UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                    URLEncoder.encode("login_pass", "UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String response = "";
            String line ="";
            while ((line=bufferedReader.readLine())!=null){
                response +=line;
            }
            bufferedReader.close();
            inputStream.close();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Login Fail";
    }

    private String BackgroundRegister(String[] params) {
        /* According to Emulator Networking IP 10.0.2.2 should be used instead of localhost/127.0.0.1. */
        String reg_url = "http://10.0.2.2/register.php";
    //    String reg_url ="http://www.squareink.xyz/register.php";
        String user_name = params[1];
        String user_pass = params[2];
        String user_roll = params[3];
        try {
            URL url = new URL(reg_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            //httpURLConnection.setDoInput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                    URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8")+"&"+
                    URLEncoder.encode("user_roll","UTF-8")+"="+URLEncoder.encode(user_roll,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Registration Success";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Debug: fail 1";
        } catch (IOException e) {
            e.printStackTrace();
            return "Debug: fail 2";
        }
    }

    private String BackgroundCreateSession(String[] params){
        String createSession_url = "http://10.0.2.2/createsession.php";
        //String reg_url ="http://www.squareink.xyz/register.php";
        String university = params[1];
        String coursename = params[2];
        String profname = params[3];
        try {
            URL url = new URL(createSession_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data = URLEncoder.encode("university","UTF-8")+"="+URLEncoder.encode(university,"UTF-8")+"&"+
                    URLEncoder.encode("course","UTF-8")+"="+URLEncoder.encode(coursename,"UTF-8")+"&"+
                    URLEncoder.encode("professor","UTF-8")+"="+URLEncoder.encode(profname,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Session Created";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Debug: fail 1";
        } catch (IOException e) {
            e.printStackTrace();
            return "Debug: fail 2";
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }else if(result.contains("Login Success")){
            alertDialog.setMessage(result);
            alertDialog.show();
            if(result.contains("Student")){
                MainActivity.setRoll("Student");
            }else{
                MainActivity.setRoll("Professor");
            }
            ctx.startActivity(new Intent(ctx, MainActivity.class));
        }else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}