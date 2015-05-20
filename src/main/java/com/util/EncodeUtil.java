package com.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodeUtil {
	 public static String encodingString(String oldstring, String oldEncoding, String newEncoding) throws UnsupportedEncodingException{
         OutputStreamWriter outputStreamWriter = null;
         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(oldstring.getBytes(oldEncoding));
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         InputStreamReader inputStreamRead = null;
         char cbuf[] = new char[1024];
         int retVal = 0;
         try {
             inputStreamRead = new InputStreamReader(byteArrayInputStream , oldEncoding);
             outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, newEncoding);
             while((retVal = inputStreamRead.read(cbuf)) != -1){
                 outputStreamWriter.write(cbuf, 0, retVal);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
             try {
                 inputStreamRead.close();
                 outputStreamWriter.close();
             } catch (Exception e) {

                 e.printStackTrace();
             }
         }
         String temp = null;
         try {
             temp = new String(byteArrayOutputStream.toByteArray(), newEncoding);
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         }
         return temp;
     }
}