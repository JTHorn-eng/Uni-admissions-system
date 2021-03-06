package security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 
 * Authenticate.java 13/11/2020
 * 
 * Provides password encryption for user's passwords
 *			
 *		   
 *
 * Credit to
 * https://dev.to/awwsmm/how-to-encrypt-a-password-in-java-42dh and
 * https://www.baeldung.com/java-password-hashing
 */
public class Authenticate {

	// store usernames and passwords in Users table
	// hash passwords with string(prevent dictionary attacks)

	//use many iterations to make key stretching more powerful
	static final int ITERATIONS = 65536;
	static final int KEY_LENGTH = 512;
	static final String ALGORITHM = "PBKDF2WithHmacSHA512";
	static final SecureRandom RAND = new SecureRandom();

	//
	static Optional<String> generateSalt(int length) {
		byte[] salt = new byte[length];

		// prevent 3rd parties from performing dictionary attacks by
		// generating another random string and applying to hash

		RAND.nextBytes(salt);
		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}

	public static Optional<String> encrypt(String password, String salt) {
		char[] chars = password.toCharArray();
		byte[] bytes = salt.getBytes();

		// Create hashing object
		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

		Arrays.fill(chars, Character.MIN_VALUE);

		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] securePassword = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(securePassword));

		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			System.err.println("Exception encountered in hashPassword()");
			return Optional.empty();

		} finally {
			spec.clearPassword();
		}
	}

	public static String createKey(String pswd, String salt) {
		return encrypt(pswd, salt).get();
	}

	public static boolean verify(String password, String key, String salt) {
		Optional<String> optEncrypted = encrypt(password, salt);
		if (!optEncrypted.isPresent()) {
			return false;
		}

		return optEncrypted.get().equals(key);
	}
	
	//store keys and salts.
	public static void main(String[] args) {
		System.out.println(encrypt("james", "password"));
	}

}
