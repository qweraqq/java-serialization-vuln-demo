package com.shen1991.vuln.serialization.beans;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.Base64;


@SuppressWarnings("all")
public class UserBean implements Serializable {
    @Serial
    private static final long serialVersionUID = 3788923205597784559L;
    private String first;
    private String last;

    public UserBean(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        UserBean user = new UserBean(
                "first name",
                "last name");
        os.writeObject(user);
        String base64 = Base64.getUrlEncoder().encodeToString(bos.toByteArray());
        System.out.println(base64);
    }
}
