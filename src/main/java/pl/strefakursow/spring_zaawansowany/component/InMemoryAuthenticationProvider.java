package pl.strefakursow.spring_zaawansowany.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class InMemoryAuthenticationProvider implements AuthenticationProvider {

    private static final String USERNAME_CANNOT_BE_NULL = "Username cannot be null.";
    private static final String CREDENTIALS_CANNOT_BE_NULL = "Credentials cannot be null.";
    public static final String INCORRECT_PASSWORD = "Incorrect password.";
    UserDetailsService userDetailsService;

    @Autowired
    public InMemoryAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        Object credentials = authentication.getCredentials();


        Assert.notNull(username, USERNAME_CANNOT_BE_NULL);
        Assert.notNull(credentials, CREDENTIALS_CANNOT_BE_NULL);

        if (!(credentials instanceof String)) {
            return null;
        }

        String password = credentials.toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException(INCORRECT_PASSWORD);
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
