package com.distributed.common.util;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Author: 周润斌
 * @Date: create in 下午 10:58 2018/1/3 0003
 * @Description:
 */
public class JarUtil {

    public static synchronized void decompress(String fileName,String outputPath){
        //保证输出的是一个目录
        if(!outputPath.endsWith(File.separator)){
            outputPath += File.separator;
        }
        //如果目录不存在 则创建一个目录
        File dir = new File(outputPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //解压到输出目录
        JarFile jf = null;
        try {
            jf = new JarFile(fileName);
            for(Enumeration<JarEntry> e = jf.entries();e.hasMoreElements();){
                JarEntry je = e.nextElement();
                String outFileName = outputPath + je.getName();
                File file = new File(outFileName);
                if(je.isDirectory()){
                    if(!file.exists()){
                        file.mkdirs();
                    }
                }else{
                    File pf = file.getParentFile();
                    if(!pf.exists()){
                        pf.mkdirs();
                    }
                    InputStream in = jf.getInputStream(je);
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                    byte[] buffer = new byte[2048];
                    int nBytes;
                    while ((nBytes = in.read(buffer))>0){
                        out.write(buffer,0,nBytes);
                    }
                    out.flush();
                    out.close();
                    in.close();
                }
            }
        } catch (IOException e) {
            System.out.println("解压" + fileName + "出错: "+e.getMessage());
            e.printStackTrace();
        }finally {
            if(jf != null){
                try {
                    jf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
