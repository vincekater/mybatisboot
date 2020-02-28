
import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HttpClient {
    public static void main(String[] args) throws Exception{
        try {
            String t = "number(20,2)";
            System.out.println(t.matches("number\\(+\\d{1,2}\\,\\d{1,2}\\)"));
//            //URL url = new URL("http://192.168.102.32:5009/plsup/commons/SWFUpload/SWFUploadJCJ");
//            URL url = new URL("http://192.168.102.7:7035/PlatSSO/rest/loginauth");
//            //URL url = new URL("http://192.168.102.32:6666/plsupService/commons/RSUpload");
//            //URL url = new URL("http://10.10.13.129:7001/plsupService/commons/RSUpload");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            // 发送POST请求必须设置如下两行
//            con.setDoInput(true);
//            con.setDoOutput(true);
//            con.setUseCaches(false);
//            con.setRequestMethod("POST");//post方式提交
//            con.setRequestProperty("Connection", "Keep-Alive");//保持长连接
//            con.setRequestProperty("Charset", "UTF-8");//设置字符格式
//            con.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:12.0) Gecko/20100101 Firefox/12.0");//设置代理信息
//            con.setRequestProperty("Content-Type","text/plain;charset=UTF-8");//设置内容类型为multipart/form-data
//            con.setRequestProperty("Accept","application/json,application/x-www-form-urlencoded,text/plain");
//            con.setRequestProperty("Accept-Encoding","gzip, deflate");
//            con.setConnectTimeout(100000);
//            StringBuffer sb = new StringBuffer();
//            sb.append("{\"account\":\"dengsy\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\"}");
//            //设置传输内容长度，采用加密方式后内容长度无法确定
//            DataOutputStream ds = new DataOutputStream(con.getOutputStream());
//            ds.writeBytes(sb.toString());
//            //把内存内容全部强制输出
//            ds.flush();
//            //读取url返回结果,定义BufferedReader输入流来读取URL的响应
//            InputStream is = con.getInputStream();
//            int ch;
//            StringBuffer b = new StringBuffer();
//            while ((ch = is.read()) != -1) {
//                b.append((char) ch);
//            }
//            String s = b.toString();
//            System.out.println(s);
//            is.close();
//            ds.close();
//            con.disconnect();
//            ds = null;
//            con = null;
        }catch( Exception ex){
            ex.printStackTrace();

        }
    }
}
