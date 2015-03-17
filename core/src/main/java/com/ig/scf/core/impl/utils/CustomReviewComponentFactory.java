package com.ig.scf.core.impl.utils;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.SocialComponent;
import com.adobe.cq.social.commons.client.api.SocialComponentFactory;
import com.adobe.cq.social.commons.comments.listing.CommentSocialComponentListProviderManager;
import com.adobe.cq.social.review.client.api.ReviewSocialComponentFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import javax.jcr.RepositoryException;

/**
 * Created with IntelliJ IDEA.
 * User: Rima
 * Date: 3/18/15
 * Time: 1:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(name = "Custom Review Component Factory")
@Service
public class CustomReviewComponentFactory extends ReviewSocialComponentFactory implements SocialComponentFactory {

    @Reference
    CommentSocialComponentListProviderManager commentListProviderManager;

    public SocialComponent getSocialComponent(Resource resource){
        try {
            return new CustomReview(resource, this.getClientUtilities(resource.getResourceResolver()),commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public SocialComponent getSocialComponent(final Resource resource, final SlingHttpServletRequest request) {
        try {
            return new CustomReview(resource, this.getClientUtilities(request),this.getQueryRequestInfo(request),commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SocialComponent getSocialComponent(Resource resource, ClientUtilities clientUtils, QueryRequestInfo listInfo) {
        try {
            return new CustomReview(resource, clientUtils, listInfo,commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getPriority(){
        return 11;
    }
}
