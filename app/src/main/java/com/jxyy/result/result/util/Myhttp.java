package com.jxyy.result.result.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 98398 on 2017/5/31.
 */

public class Myhttp {
    public String getdata(String url,String post){
        System.out.println("++++++++++++++++++++++");
        String str = "";
        try {
            URL Url = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) Url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            httpURLConnection.setRequestProperty("Content-Type","application/json");
            OutputStream os = httpURLConnection.getOutputStream();
//            os.write(post.getBytes());
            os.flush();

            System.out.println(httpURLConnection.getResponseCode());
            if(httpURLConnection.getResponseCode()==200){
                System.out.println("22222222222222222222222222222");
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                byte buf[] = new byte[102400];
                int z = -1;
                int x = 0;

//                while ((z=is.read(buf))!=-1){
//                    x = z;
//                    if(z==1023){
//                        str = str+new String(buf,0,x);
//                        z = -1;
//                    }
//                }
//                str = new String(buf,0,x);
//                System.out.println(str);

                while((str = bf.readLine())!=null) {
                        String sss = "gb2312";
                        String s = new String(str.getBytes(),sss);
                        System.out.println(s);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
