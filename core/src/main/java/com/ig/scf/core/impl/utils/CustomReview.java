package com.ig.scf.core.impl.utils;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.User;
import com.adobe.cq.social.commons.comments.listing.CommentSocialComponentListProviderManager;
import com.adobe.cq.social.review.client.api.AbstractReview;
import com.adobe.cq.social.review.client.api.ReviewSocialComponent;
import org.apache.sling.api.resource.Resource;

import javax.jcr.RepositoryException;

/**
 * Created with IntelliJ IDEA.
 * User: Rima
 * Date: 3/18/15
 * Time: 1:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomReview extends AbstractReview implements ReviewSocialComponent {
    public CustomReview(Resource resource, ClientUtilities clientUtils, CommentSocialComponentListProviderManager listProviderManager) throws RepositoryException {
        super(resource, clientUtils, listProviderManager);
    }

    public CustomReview(Resource resource, ClientUtilities clientUtils, QueryRequestInfo queryInfo, CommentSocialComponentListProviderManager listProviderManager) throws RepositoryException {
        super(resource, clientUtils, queryInfo, listProviderManager);
    }
    //adding extra method
    public String getAuthorId(){
        // System.out.print("\n\n-->authorid");
        return "1rima";
        //return this.getAuthor().getUserId();
    }

    public User getAuthor() {
        System.out.print("\n\n-->authorr");
        return null;
    }

    public String getTestrima(){
        System.out.print("\n\n-->rima");
        return "RIma";
    }
}
