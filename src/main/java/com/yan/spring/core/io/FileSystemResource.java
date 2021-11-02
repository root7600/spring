package com.yan.spring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hairui
 * @date 2021/11/2
 * @des
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;


    public FileSystemResource(File file) {
        this.file = file;
        this.path=file.getPath();
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file=new File(this.path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.file);
        return fileInputStream;
    }

    public String getPath() {
        return path;
    }
}
