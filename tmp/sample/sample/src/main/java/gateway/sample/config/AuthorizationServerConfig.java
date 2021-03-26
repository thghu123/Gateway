package gateway.sample.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    //토큰 발급, 리프레쉬, 액세스 토큰 발급으로 검증을 여기서 진행한다.

    //발급하는 토큰들을 저장하는 인메모리 저장소
    private final TokenStore tokenStore;

    //인증 열할
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        //인증 정보
        configurer
                //인메모리를 인증 서버로 변경
                .inMemory()
                .withClient("gyumin")
                .secret(passwordEncoder.encode("gm_password"))
                .authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
                .scopes("read","write","trust")
                .accessTokenValiditySeconds(1*60*60)
                .refreshTokenValiditySeconds(6*60*60);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
        //endpoint에 tocken store 생성, 빈으로 manager 등록
    }
}
