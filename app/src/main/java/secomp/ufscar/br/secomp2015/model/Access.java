package secomp.ufscar.br.secomp2015.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class Access implements Serializable {

    private String username;
    private Date when;

    public Access() {}

    public Access(final String username, final Date when) {
        this.username = username;
        this.when = when;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String toSendRemotely() throws JSONException {
        return new StringBuilder().append("username:").append(this.username).
                append("when:").append(this.when).toString();
    }
}
