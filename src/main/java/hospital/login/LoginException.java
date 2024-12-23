package hospital.login;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LoginException extends Exception {


    public LoginException(String message) {
        super(message);
    }
}