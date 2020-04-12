package edu.escuelaing.arep.services;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.model.User;

public class UserService {
	
	private static Map<String, User> registeredUsers = new HashMap<>();

	/**
	 * Guarda un usuario localmente con la contrseña encryptada con SHA1
	 * @param user usuario a guardar
	 */
	public static void registry(User user) {
		System.out.println("usuario registrado: "+user.getUserName());
		String passwEncoded = passwordEncoder(user.getPassword());
		user.setPassEncrypt(passwEncoded);
		System.out.println(user.getPassEncrypt());
		registeredUsers.put(user.getUserName(),user);
	}
	
	/**
	 * Verifica que el usuario que ingresa existe y su contraseña es correcta
	 * @param user Usuario que ingresa
	 * @return Usuario guardado con todos sus datos
	 */
	public static User verifyUser(User user) {
		System.out.println("Verificando Usuario: "+user.toString());
		User userRepository = registeredUsers.get(user.getUserName());
		String passToVerify = passwordEncoder(user.getPassword());
		if (!registeredUsers.containsKey(user.getUserName())) {
			System.err.println("El Usuario "+user.getUserName()+" no existe");
		
		} else if (userRepository.getPassEncrypt().equals(passToVerify)) {
			return userRepository;
			
		} else {
			System.err.println("La contrasena es erronea");
		}
		return user;
	}
	
	/**
	 * Encrypta un string con SHA1 y retorna el resultado
	 * @param input Un string
	 * @return Resultado de la encriptación
	 */
	public static String passwordEncoder(String input) {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff)+0x100,16).substring(1));	
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
