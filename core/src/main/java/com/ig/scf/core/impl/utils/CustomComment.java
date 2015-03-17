package com.ig.scf.core.impl.utils;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.User;
import com.adobe.cq.social.commons.comments.api.AbstractComment;
import com.adobe.cq.social.commons.comments.api.Comment;
import com.adobe.cq.social.commons.comments.listing.CommentSocialComponentListProviderManager;
import org.apache.sling.api.resource.Resource;

import javax.jcr.RepositoryException;

/**
 * Created with IntelliJ IDEA.
 * User: Rima
 * Date: 2/27/15
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomComment extends AbstractComment implements Comment{
    public CustomComment(Resource resource, ClientUtilities clientUtils, CommentSocialComponentListProviderManager commentListProviderManager) throws RepositoryException {
        super(resource, clientUtils, commentListProviderManager);
    }

    public CustomComment(final Resource resource, final ClientUtilities clientUtils,
                         final QueryRequestInfo queryInfo, final CommentSocialComponentListProviderManager commentListProviderManager)
            throws RepositoryException {
        super(resource, clientUtils, queryInfo, commentListProviderManager);
    }
}
