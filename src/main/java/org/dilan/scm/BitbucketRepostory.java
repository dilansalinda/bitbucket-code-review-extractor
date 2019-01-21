package org.dilan.scm;

import org.apache.log4j.Logger;

import java.io.IOException;

public class BitbucketRepostory {
    final static Logger LOGGER = Logger.getLogger(BitbucketRepostory.class);

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new HttpClient();
        LOGGER.info(httpClient.sendRequest("http://localhost:7990/rest/api/1.0/projects/scm/repos/tfs/commits"));
        System.out.println();
    }
}
