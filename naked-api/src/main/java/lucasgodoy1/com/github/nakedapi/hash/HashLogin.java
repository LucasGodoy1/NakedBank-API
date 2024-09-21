package lucasgodoy1.com.github.nakedapi.hash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashLogin {

    public static String encoder(String senha) {
        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
        return encoderSenha.encode(senha);
    }

    public Boolean compararSenha(String requestSenha, String senhaRegistrada) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(requestSenha, senhaRegistrada);
    }
}
