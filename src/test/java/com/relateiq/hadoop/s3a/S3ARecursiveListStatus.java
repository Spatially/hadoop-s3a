package com.relateiq.hadoop.s3a;

import junit.framework.TestCase;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.s3a.S3AFileSystem;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * Created by jsoumet on 7/20/15.
 */
public class S3ARecursiveListStatus extends TestCase {
    S3AFileSystem fs;
    Path rootPath;

//    @Override
//    public void setUp() throws Exception {
//        Configuration conf = new Configuration();
//        fs = new S3AFileSystem();
//        conf.set("fs.s3a.access.key", "AKIAIPCAKS5FZG4OZBXA");
//        conf.set("fs.s3a.secret.key", "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");
//        fs.initialize(new URI("s3a://usw2-relateiq-hadoop-staging"), conf);
//        rootPath = new Path("/tests3a");
//        fs.mkdirs(rootPath);
//        for (int i = 0; i < 100; ++i) {
//            Path subPath1 = new Path(rootPath, String.format("%03d", i));
//            fs.mkdirs(subPath1);
//            for (int j = 0; j < 100; ++j) {
//                Path subPath2 = new Path(subPath1, String.format("%03d", j));
//                fs.mkdirs(subPath2);
//                fs.create(new Path(subPath2, "test.txt"));
//            }
//
//
//        }
//        super.setUp();
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }
//
//
//    @Test(timeout = 10000)
//    public void testListRecursive() throws IOException {
//
//    }


}
