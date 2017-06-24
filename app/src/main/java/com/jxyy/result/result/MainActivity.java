package com.jxyy.result.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jxyy.result.result.util.Myhttp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    List<Cookie> cookies = new ArrayList<Cookie>();
    HttpClient client = new DefaultHttpClient();
    HttpResponse response;

    //提交路径
    String Url = "http://jw.jxyyxy.com/default2.aspx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            public void run(){
                connect2();
            }
        }.start();
    }


    private void connect1(){


        final Myhttp myhttp = new Myhttp();

        new Thread(){
            public void run(){
                String url = "http://jw.jxyyxy.com/%28eosu4vf0jmtorbbanbdroo45%29/default2.aspx?__VIATE=dDwyOTIzOTAzMDY7Oz7gTm7Lj6715kvFkfvLWBEaHDN6dA%3D%3D&TextBox1=2015131879&TextBox2=19970304&RadioButtonList1=%D1%A7%C9%FA&Button1=";
                String u = "http://jw.jxyyxy.com/%28eosu4vf0jmtorbbanbdroo45%29/default2.aspx";
                String bai = "http://www.baidu.com";

                String post = "Accept\t\n" +
                        "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                        "Accept-Encoding\t\n" +
                        "gzip, deflate\n" +
                        "Accept-Language\t\n" +
                        "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3\n" +
                        "Connection\t\n" +
                        "keep-alive\n" +
                        "Cookie\t\n" +
                        "ASP.NET_SessionId=mmnlpcubpzsgss3huhchnq45\n" +
                        "Host\t\n" +
                        "jw.jxyyxy.com\n" +
                        "Upgrade-Insecure-Requests\t\n" +
                        "1\n" +
                        "User-Agent\t\n" +
                        "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0";

                String q = "{\"__VIEWSTATE\":\"dDwyOTIzOTAzMDY7Oz7gTm7Lj6715kvFkfvLWBEaHDN6dA%3D%3D\",\"TextBox1\":\"2015131879\",\"TextBox2\":\"131313\",\"RadioButtonList1\":\"%D1%A7%C9%FA&Button1=\"}";

                myhttp.getdata(url,post);
            }
        }.start();
    }

    private void connect2(){

        HttpPost httprequest = new HttpPost(Url);

        //提交信息
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("TextBox1","2015131879"));
        params.add(new BasicNameValuePair("TextBox2","19970304"));
        params.add(new BasicNameValuePair("RadioButtonList1","ѧ��"));
        params.add(new BasicNameValuePair("Button1",""));
        params.add(new BasicNameValuePair("__VIEWSTATE","dDwyOTIzOTAzMDY7Oz7gTm7Lj6715kvFkfvLWBEaHDN6dA=="));

        try {
            httprequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            response = client.execute(httprequest);
            if(response.getStatusLine().getStatusCode()==200){
                System.out.println("提交信息成功");
                cookies = ((AbstractHttpClient)client).getCookieStore().getCookies();
                System.out.println(cookies);


                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "GB2312"));
                //是读取要改编码的源，源的格式是GB2312的，安源格式读进来，然后再对源码转换成想要的编码就行

                String result = "";
                String data = "";
                StringBuffer sb = new StringBuffer();
                while ((data = br.readLine()) != null) {
                    sb.append(data);
                    System.out.println(data);
                }
                result = sb.toString();  //此时result中就是我们成绩的HTML的源代码了
                System.out.println(result);
                is.close();
                httprequest.getEntity().getContent().close();
                EntityUtils.getContentCharSet(entity);

                        connect3();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void connect3(){

        client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS,true);
        String url = "http://jw.jxyyxy.com/xscj_gc.aspx?xh=2015131879&xm=%B5%CB%CE%C4%D0%FB&gnmkdm=N121605";
        String url2 = "http://jw.jxyyxy.com/xscj_gc.aspx";
        String url3 = "http://www.baidu.com";
        String url4 = "http://210.43.188.41/xscj/Stu_MyScore_rpt.aspx";
        HttpPost httprequest = new HttpPost(url2);
        //提交信息
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("gnmkdm","N121605"));
        params.add(new BasicNameValuePair("xh","2015131879"));
        params.add(new BasicNameValuePair("xm","µËÎÄÐû"));
        params.add(new BasicNameValuePair("Button5","°´Ñ§Äê²éÑ¯"));
        params.add(new BasicNameValuePair("ddlXN","2016-2017"));
        params.add(new BasicNameValuePair("ddlXQ",""));
//        params.add(new BasicNameValuePair("__VIEWSTATE","dDwtMTA1MTQ3MjIyMjt0PHA8bDx4aDtzZmRjYms7ZHlieXNjajt6eGNqY3h4czs+O2w8MjAxNTEzMTg3OTtcZTtcZTswOz4+O2w8aTwxPjs\n" +
//                "+O2w8dDw7bDxpPDE+O2k8Mz47aTw1PjtpPDc+O2k8OT47aTwxMT47aTwxMz47aTwxNT47aTwyND47aTwyNT47aTwyNj47aTwzMz47aTwzNT47aTwzNz47aTwzOT47aTw0MT47aTw0Mz47aTw0NT47aTw1NT47aTw2MD47PjtsPHQ8cDxwPGw8VGV4dDs\n" +
//                "+O2w85a2m5Y+377yaMjAxNTEzMTg3OTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85aeT5ZCN77ya6YKT5paH5a6jOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrabpmaLvvJrnlLXlrZDkv6Hmga\n" +
//                "/lt6XnqIvns7s7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOS4k+S4mu+8mjs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86L2v5Lu25oqA5pyvOz4\n" +
//                "+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzooYzmlL/nj63vvJoxNei9r+S7tjAyOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwyMDE1NzIyNDs\n" +
//                "+Pjs+Ozs+O3Q8dDw7dDxpPDE4PjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY\n" +
//                "7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTM\n" +
//                "tMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7PjtAPFxlOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjA\n" +
//                "wMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjA\n" +
//                "xMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7Pj47Pjs7Pjt0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cucHJpbnQoKVw7Oz4\n" +
//                "+Pjs7Pjt0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cuY2xvc2UoKVw7Oz4+Pjs7Pjt0PHA8cDxsPFZpc2libGU7PjtsPG88dD47Pj47Pjs7Pjt0PEAwPDs7Ozs7Ozs7Ozs\n" +
//                "+Ozs+O3Q8QDA8Ozs7Ozs7Ozs7Oz47Oz47dDxAMDw7Ozs7Ozs7Ozs7Pjs7Pjt0PEAwPDs7Ozs7Ozs7Ozs+Ozs+O3Q8QDA8Ozs7Ozs7Ozs7Oz47Oz47dDxAMDxwPHA8bDxWaXNpYmxlOz47bDxvPGY\n" +
//                "+Oz4+Oz47Ozs7Ozs7Ozs7Pjs7Pjt0PEAwPHA8cDxsPFZpc2libGU7PjtsPG88Zj47Pj47Pjs7Ozs7Ozs7Ozs+Ozs+O3Q8cDxwPGw8VGV4dDs\n" +
//                "+O2w8emY7Pj47Pjs7Pjt0PEAwPDs7Ozs7Ozs7Ozs+Ozs+Oz4+Oz4+Oz6RPg+4kRkDhnC7tRoxTVoVH1od0w=="));

//        httprequest.addHeader("Accept-Encoding", "gzip, deflate");
//        httprequest.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
//        httprequest.addHeader("Connection", "keep-alive");
//        httprequest.addHeader("Content-Length", "1862");
//        httprequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
//        httprequest.addHeader("Referer", "http://jw.jxyyxy.com/xscj_gc.aspx?xh=2015131879&xm=%B5%CB%CE%C4%D0%FB&gnmkdm=N121605");
//        httprequest.addHeader("Upgrade-Insecure-Requests", "1");
//        httprequest.addHeader("Host", "jw.jxyyxy.com");
//        httprequest.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//        httprequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
//        httprequest.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; QQDownload 1.7; .NET CLR 1.1.4322; CIBA; .NET CLR 2.0.50727)");
        httprequest.setHeader("Cookie","ASP.NET_SessionId="+ cookies.get(0).getValue());





        System.out.println( cookies.get(0).getValue());
        System.out.println(httprequest.getHeaders("Cookie").toString());
        try {
            httprequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse response = new DefaultHttpClient().execute(httprequest);
            System.out.println("获取response对象");
            if(response.getStatusLine().getStatusCode()==200){
                System.out.println("二次提交信息成功");
                cookies = ((AbstractHttpClient)client).getCookieStore().getCookies();
                System.out.println(cookies);

                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "GB2312"));
                //是读取要改编码的源，源的格式是GB2312的，安源格式读进来，然后再对源码转换成想要的编码就行

                String result = "";
                String data = "";
                StringBuffer sb = new StringBuffer();
                while ((data = br.readLine()) != null) {
                    sb.append(data);
                    System.out.println(data);
                }
                result = sb.toString();  //此时result中就是我们成绩的HTML的源代码了
                System.out.println(result);



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
