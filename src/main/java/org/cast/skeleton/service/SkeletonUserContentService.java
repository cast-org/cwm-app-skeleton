package org.cast.skeleton.service;

import org.cast.cwm.data.IContentType;
import org.cast.cwm.service.IUserContentService;
import org.cast.skeleton.data.ContentType;

/**
 *
 */
public class SkeletonUserContentService implements IUserContentService {

	@Override
	public Class<? extends IContentType> getContentTypeClass() {
		return ContentType.class;
	}

	@Override
	public IContentType getContentType(String name) {
		return ContentType.valueOf(name);
	}

}
