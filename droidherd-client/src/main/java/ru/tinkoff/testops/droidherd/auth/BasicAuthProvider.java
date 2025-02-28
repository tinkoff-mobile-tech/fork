package ru.tinkoff.testops.droidherd.auth;

import java.util.Base64;
import java.util.Optional;

public class BasicAuthProvider implements AuthProvider {
    private final DroidherdAuthData data;
    private final String clientId;
    private final String token;

    public BasicAuthProvider() {
        this.data = new DroidherdAuthData() {
            @Override
            public String getClientId() {
                return clientId;
            }

            @Override
            public String getToken() {
                return token;
            }
        };
        this.clientId = Optional.ofNullable(System.getenv("DROIDHERD_CLIENT_ID"))
                .orElse("droidherd-default");
        this.token = Optional.ofNullable(System.getenv("DROIDHERD_AUTH_TOKEN"))
                .orElse("Basic " + Base64.getEncoder().encodeToString(String.format("%s:", clientId).getBytes()));
    }

    @Override
    public DroidherdAuthData get() {
        return data;
    }

    @Override
    public String toString() {
        return BasicAuthProvider.class.getSimpleName();
    }

}
