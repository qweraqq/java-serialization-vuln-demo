package com.shen1991.vuln.serialization;

import com.shen1991.vuln.serialization.beans.UserBean;

import java.io.*;

public class WhitelistObjectInputStream extends ObjectInputStream {
    public WhitelistObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    /**
     * Only deserialize instances of our expected  class
     */
    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        if (!desc.getName().equals(UserBean.class.getName())) {
            throw new InvalidClassException("Unauthorized deserialization attempt", desc.getName());
        }
        return super.resolveClass(desc);
    }
}
