package snowboard.userservice.keycloak.user_spi;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;
import snowboard.userservice.repo.UserRepo;

import java.util.List;

public class MyUserStorageProviderFactory implements UserStorageProviderFactory<MyUserStorageProvider> {

    private final UserRepo userRepo;

    public MyUserStorageProviderFactory(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public MyUserStorageProvider create(KeycloakSession session, ComponentModel model) {
        // here you can setup the user storage provider, initiate some connections, etc.
        return new MyUserStorageProvider(session, model, userRepo);
    }

    @Override
    public String getId() {
        return "demo-user-provider";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return ProviderConfigurationBuilder.create()
                .property("myParam", "My Param", "Some Description", ProviderConfigProperty.STRING_TYPE, "some value", null)
                .build();
    }
}
