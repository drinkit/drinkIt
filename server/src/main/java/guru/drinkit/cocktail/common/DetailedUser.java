package guru.drinkit.cocktail.common;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@SuppressWarnings("unused")
public class DetailedUser extends User {

    private final String displayName;
    private Integer userId;

    public DetailedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String displayName) {
        super(username, password, authorities);
        this.userId = id;
        this.displayName = displayName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return "DetailedUser{" +
                "displayName='" + displayName + '\'' +
                ", userId=" + userId +
                "} " + super.toString();
    }
}