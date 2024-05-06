package com.shen1991.vuln.serialization;

import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api")
public class DeserializationController {
    @PostMapping("unsafe-deserialize-base64")
    public String deserialize(@RequestParam String payload) {
        // Deserialization
        try {
            byte[] byteValue = Base64.getUrlDecoder().decode(payload);
            InputStream in = new ByteArrayInputStream(byteValue);
            ObjectInputStream obin = new ObjectInputStream(in);
            Object user = obin.readObject();
            return "deserialized";
        } catch (Exception ignored){
            return "not deserialized";
        }
    }

    @PostMapping("whitelist-deserialize-base64")
    public String customDeserialize(@RequestParam String payload) {
        // Deserialization
        try {
            byte[] byteValue = Base64.getUrlDecoder().decode(payload);
            InputStream in = new ByteArrayInputStream(byteValue);
            WhitelistObjectInputStream obin = new WhitelistObjectInputStream(in);
            Object user = obin.readObject();
            return "deserialized";
        } catch (Exception e){
            return "not deserialized, reason: " + e;
        }
    }
}
