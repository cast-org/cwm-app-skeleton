package org.cast.skeleton.page;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeActions;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.http.flow.AbortWithHttpErrorCodeException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.cast.cwm.data.Event;
import org.cast.cwm.data.LoggedWebPage;
import org.cast.cwm.service.IEventService;

/**
 * Base class for all SNUDLE2 student/teacher pages
 * (Not login, researcher, or admin pages).
 *
 * @author bgoldowsky
 */
@Slf4j
@AuthorizeActions(actions={@AuthorizeAction(action="RENDER", roles={"STUDENT"})})
public abstract class BasePage extends LoggedWebPage<Event> {

	@Inject
	private IEventService eventService;

	private static final String TITLE_PREFIX = "SKELETON: ";

	public BasePage(PageParameters params) {
		super(params);

		readPageParams(params);
		if (!checkPermission())
			throw new AbortWithHttpErrorCodeException(403, "You do not have permission for this");
		add(new Label("title", TITLE_PREFIX + getPageTitle()));
	}

	/**
	 * Determine whether it's ok to present this page, based on the parameters and any other information.
	 * This should be overridden by pages to test, for instance, whether the user has permission to view
	 * or edit the object requested by the URL.
	 * @return true if all is well, false if the action should be prevented.
	 */
	protected boolean checkPermission() {
		return true;
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// add global header items
	}

	protected void readPageParams(PageParameters params) {
	}

//	// Page names are all defined in SkeletonEventService.
//	// This is so that we can use the same set of names for link destinations, before a Page instance has been created.
//	@Override
//	public final String getPageName() {
//		String pageName = eventService.getPageName(this.getClass());
//		if (pageName == null)
//			log.warn("No name defined for page: {}", this);
//		return pageName;
//	}

	public abstract String getPageTitle();

}
