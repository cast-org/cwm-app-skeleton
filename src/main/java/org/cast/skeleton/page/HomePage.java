package org.cast.skeleton.page;

import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Home page for "student" role.
 */
@AuthorizeInstantiation("STUDENT")
@Slf4j
public class HomePage extends BasePage {

    public HomePage(final PageParameters parameters) {
        super(parameters);
    }

    @Override
    public String getPageTitle() {
        return "Home";
    }

    @Override
    public String getPageName() {
        return "Home";
    }

}
