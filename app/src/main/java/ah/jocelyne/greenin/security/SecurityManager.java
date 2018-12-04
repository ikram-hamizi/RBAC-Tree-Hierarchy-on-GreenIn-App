package ah.jocelyne.greenin.security;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class SecurityManager {

    // inspired by https://www.mytrendin.com/store-password-securely-android/
    public String generateSalt() {
        // Generate a 256-bit key
        final int outputKeyLength = 256;

        SecureRandom secureRandom = new SecureRandom();
        // Do *not* seed secureRandom! instead Automatically seed from system entropy.
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGen.init(outputKeyLength, secureRandom);
        SecretKey secretKey = keyGen.generateKey();

        //now convert it into String
        byte encoded[] = secretKey.getEncoded();
        String key = Base64.encodeToString(encoded,0);

        return key;
    }

    public String hashedPassword(String password, String salt) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.reset();
        password = salt + password; // add salt
        try {
            md.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //now let's view the hash code
        byte hashCode[] = md.digest();
        StringBuffer generatedOutput = new StringBuffer();
        for (int index = 0; index < hashCode.length; index++) {
            String hex = Integer.toHexString(0xFF & hashCode[index]);
            if (hex.length() == 1) {
                generatedOutput.append('0');
            }
            generatedOutput.append(hex);
        }
        return generatedOutput.toString();
    }
}
