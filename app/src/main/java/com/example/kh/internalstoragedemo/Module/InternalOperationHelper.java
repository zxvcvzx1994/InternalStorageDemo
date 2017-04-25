package com.example.kh.internalstoragedemo.Module;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kh on 4/25/2017.
 */

public class InternalOperationHelper {
    private static   InternalOperationHelper internalOperationHelper;
    public static InternalOperationHelper getInstance(){
        if(internalOperationHelper==null)
            internalOperationHelper = new InternalOperationHelper();
        return internalOperationHelper;
    }

    public String getData(String filename, Context context) throws IOException {
        FileInputStream fileInputStream = context.openFileInput(filename);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line ;
        StringBuffer stringBuffer = new StringBuffer();
        while((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line+"\n");
        }
        bufferedReader.close();
        fileInputStream.close();
        return  stringBuffer.toString();
    }
    public void setData(String data, String filename, Context context) throws IOException {
        FileOutputStream fileOutputStream = context.openFileOutput(filename,context.MODE_PRIVATE);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();

    }

}
