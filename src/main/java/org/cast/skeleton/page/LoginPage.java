package org.cast.skeleton.page;

import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.cast.cwm.admin.SignInFormPanel;

/**
 * Login page, will intercept any request for a page requiring authentication.
 *
 * @author bgoldowsky
 */
@StatelessComponent
public class LoginPage extends WebPage {

	public LoginPage(PageParameters params) {
		super(params);
		add(new SignInFormPanel("loginPanel"));
	}

}
