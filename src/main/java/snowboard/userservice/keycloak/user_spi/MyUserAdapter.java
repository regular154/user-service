package snowboard.userservice.keycloak.user_spi;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;
import snowboard.userservice.entity.User;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
public class MyUserAdapter extends AbstractUserAdapterFederatedStorage {

    private final User user;

    public MyUserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, User user) {
        super(session, realm, model);
        this.user = user;
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
    }

    @Override
    public String getId() {
        if (storageId == null) {
            storageId = new StorageId(storageProviderModel.getId(), user.getId());
        }
        return storageId.getId();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public void setUsername(String username) {
        user.setLogin(username);
    }
}
