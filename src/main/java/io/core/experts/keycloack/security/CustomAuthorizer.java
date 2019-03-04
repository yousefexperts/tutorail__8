package io.core.experts.keycloack.security;

import org.pac4j.core.authorization.authorizer.ProfileAuthorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;
import java.util.List;

public class CustomAuthorizer extends ProfileAuthorizer<CommonProfile> {

    @Override
    protected boolean isProfileAuthorized(WebContext webContext, CommonProfile commonProfile) throws HttpAction {
        if (commonProfile == null) {
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean isAuthorized(WebContext webContext, List<CommonProfile> list) throws HttpAction {
        return isAnyAuthorized(webContext, list);
    }
}