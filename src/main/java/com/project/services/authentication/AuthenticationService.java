package com.project.services.authentication;

import com.project.exceptions.ServiceException;
import com.project.models.Tutor;
import com.project.services.TutorService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenticationService {

    private final TutorService tutorService;

    public AuthenticationService(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    private static byte[] getSalt() {
        return new byte[16];
    }

    /**
     * Check credentials and return the tutor if authentication correct
     *
     * @param email    the tutor email
     * @param password the tutor password
     * @return user logged or null if invalid credentials
     */
    public Tutor authWithEmailAndPassword(String email, String password) throws ServiceException {

        byte[] salt = getSalt();
        String hashedPassword;
        Tutor tutor = tutorService.findByEmail(email);
        if (tutor != null) {
            hashedPassword = getHashedPassword(password, salt);
            if (hashedPassword != null && hashedPassword.equals(tutor.getPassword())) {
                return tutor;
            }
        }
        return null;
    }

    private String getHashedPassword(String password, byte[] salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(salt);
            byte[] bytes = md5.digest(password.getBytes());
            StringBuilder stringbuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringbuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return stringbuilder.toString();
        } catch (NoSuchAlgorithmException ignored) {
            return null;
        }
    }
}
