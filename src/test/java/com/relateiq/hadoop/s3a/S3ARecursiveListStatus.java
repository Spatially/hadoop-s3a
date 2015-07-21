package com.relateiq.hadoop.s3a;

import junit.framework.TestCase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.s3a.S3AFileSystem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.assertTrue;

/**
 * Created by jsoumet on 7/20/15.
 */
public class S3ARecursiveListStatus {
    static S3AFileSystem fs;
    static final Path rootPath = new Path("/tests3a");
    static final int pathLevel1 = 2, pathLevel2 = 5;

    @BeforeClass
    public static void initialize() throws Exception {
        Configuration conf = new Configuration();
        fs = new S3AFileSystem();
        conf.set("fs.s3a.access.key", "AKIAIPCAKS5FZG4OZBXA");
        conf.set("fs.s3a.secret.key", "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");
        fs.initialize(new URI("s3a://usw2-relateiq-hadoop-staging"), conf);
        fs.mkdirs(rootPath);
        for (int i = 0; i < pathLevel1; ++i) {
            Path subPath1 = new Path(rootPath, String.format("%03d", i));
            fs.mkdirs(subPath1);
            for (int j = 0; j < pathLevel2; ++j) {
                Path subPath2 = new Path(subPath1, String.format("%03d", j));
                fs.mkdirs(subPath2);
                FSDataOutputStream out = fs.create(new Path(subPath2, "test.txt"));
                out.writeChars("sample");
                out.close();
            }
        }
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        fs.delete(rootPath, true);
    }


    @Test(timeout = 10000)
    public void testListRecursive() throws IOException {
        FileStatus[] list = fs.listStatus(rootPath, true);
        assertTrue("Should list all paths recursively", list.length == (pathLevel1 * pathLevel2));
    }

    @Test(timeout = 10000)
    public void testListNonRecursive() throws IOException {
        FileStatus[] list = fs.listStatus(rootPath);
        assertTrue("Should list only first level folders", list.length == pathLevel1);
    }



}
