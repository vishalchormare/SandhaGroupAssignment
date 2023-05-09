package assignment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jasypt.util.text.BasicTextEncryptor;

public class WriteEncryptedTextToFile {

		public static void writeEncyptedTextFile()  {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		String fileName = "C:\\Users\\Admin\\Desktop\\myFile.txt";
		try {
			fos = new FileOutputStream(fileName);
			bos = new BufferedOutputStream(fos);
			String originalText = "You are learning File IO from javaMadeSoEasy.com";
			System.out.println("originalText = " + originalText );

			/*
			 * Encrypting a text
			 */
			BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
			// Must remember this password, as it will be required at time of decryption
			basicTextEncryptor.setPassword("password");
			String encryptedText = basicTextEncryptor.encrypt(originalText);
			System.out.println("encryptedText = " + encryptedText);

			// convert encryptedText into byte array to write it in file
			bos.write(encryptedText.getBytes());
			bos.flush();

			System.out.println("encryptedText has been written successfully in " + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close(); // close FileOutputStream
				}
				if (fos != null) {
					fos.close(); // close FileOutputStream
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void readEncryptedTextFromFile() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\myFile.txt");
			bis = new BufferedInputStream(fis);

			// create byteArray of file's size
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes); // Read file in ByteArray

			String encryptedTextOfFile = new String(bytes); // convert ByteArray to String
			System.out.println("encryptedTextOfFile = " + encryptedTextOfFile);

			/*
			 * Decrypting text of file
			 */
			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
			// Give password given at time of encryption
			textEncryptor.setPassword("password");

			String decryptedTextOfFile = textEncryptor.decrypt(encryptedTextOfFile);
			System.out.println("decryptedTextOfFile = " + decryptedTextOfFile);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close(); // close FileInputStream
				if (bis != null)
					bis.close(); // close BufferedInputStream
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
