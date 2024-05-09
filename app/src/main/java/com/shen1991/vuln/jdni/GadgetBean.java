package com.shen1991.vuln.jdni;

import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class GadgetBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 8614038798373111905L;

    private String command;

    public GadgetBean(String command) {
        this.command = command;
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws Exception{
        ois.defaultReadObject();
        // vulnerable
        Runtime.getRuntime().exec(this.command);       // code execution
    }
}
