package com.dyq.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class Base64Util {

	public static Key DEFAULT_KET = null;
	public static final String DEFAULT_SECRET_KEY = "1qaz2wsx3edc$RFV%TGB^YHN&UJM";
	public static final String DES = "DES";
	
	private static final Logger log = LoggerFactory.getLogger(Base64Util.class);

	static {
		DEFAULT_KET = obtainKey(DEFAULT_SECRET_KEY);
	}
	
	/**
	  * 获得key
	 * @param key
	 * @return
	 */
	public static Key obtainKey(String key) {
		if(StringUtils.isEmpty(key)) {
			return DEFAULT_KET;
		}
		KeyGenerator generator = null;
		try {
			generator = KeyGenerator.getInstance(DES);
		}catch(NoSuchAlgorithmException e) {
			log.warn("-->>>获取Key失败");
		}
		generator.init(new SecureRandom(key.getBytes()));
		Key newKey = generator.generateKey();
		generator = null;
		return newKey;
	}
	
	/**
	  * 加密
	  * 以byte[]明文输入,byte[]密文输出
	 * @param key
	 * @param str
	 * @return
	 */
	public static byte[] obtainEncode(String key, byte[] str) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			Key newKey = obtainKey(key);
			cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.ENCRYPT_MODE, newKey);
			byteFina = cipher.doFinal(str);
		}catch (Exception e) {
			log.warn("-->>>加密失败");
		}finally {
			cipher = null;
		}
		return byteFina;
	}
	
	/**
	  * 解密
	  * 以byte[]密文输入,以byte[]明文输出
	 * @param key
	 * @param str
	 * @return
	 */
	public static byte[] obtainDecode(String key, byte[] str) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			Key newKey = obtainKey(key);
			cipher = Cipher.getInstance(DES);
			cipher.init(Cipher.DECRYPT_MODE, newKey);
			byteFina = cipher.doFinal(str);
		}catch(Exception e) {
			log.warn("-->>>解密失败");
		}finally {
			cipher = null;
		}
		return byteFina;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	  *  加密
	 * String明文输入,String密文输出 
	 * @param key
	 * @param str
	 * @return
	 */
	public static String encode(String key, String str) {
		return Hex.encodeHexString(obtainEncode(key, str.getBytes()));
    }
	
	/**
	  * 解密
	  * 以String密文输入,String明文输出
	 * @param key
	 * @param str
	 * @return
	 */
	public static String decode(String key, String str) {
		try {
			return new String(obtainDecode(key, Hex.decodeHex(str.toCharArray())));
		} catch (DecoderException e) {
			return "";
		}
    }
	
	/**
	  * 加密
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
        return encode(null, str);
    }
	
	/**
	  * 解密
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
        return decode(null, str);
    }
	
}
