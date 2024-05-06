package com.shen1991.vuln.serialization.beans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Base64;

@SuppressWarnings("all")
public class GadgetBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(GadgetBean.class);

    @Serial
    private static final long serialVersionUID = 8277249180565044958L;

    private String username;
    private String command;

    public GadgetBean(String username, String command) {
        this.username = username;
        this.command = command;
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws Exception{
        ois.defaultReadObject();

        // vulnerable
        logger.info("User {} deserialized", username); // log forging
        Runtime.getRuntime().exec(this.command);       // code execution
    }

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        GadgetBean gadgetBean = new GadgetBean(
                "xxxx \r\n2024-XX-XXTXX:XX:XX.000+08:00  INFO XXXX --- HACKED",
                "calc");
        os.writeObject(gadgetBean);
        String base64 = Base64.getUrlEncoder().encodeToString(bos.toByteArray());
        System.out.println(base64);
    }
}
