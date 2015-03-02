package com.ig.scf.core.impl.utils;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.SocialComponent;
import com.adobe.cq.social.commons.client.api.SocialComponentFactory;
import com.adobe.cq.social.commons.comments.api.CommentSocialComponentFactory;
import com.adobe.cq.social.commons.comments.listing.CommentSocialComponentListProviderManager;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import javax.jcr.RepositoryException;

/**
 * Created with IntelliJ IDEA.
 * User: Rima
 * Date: 2/28/15
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Component(name = "Custom Comment Component Factory")
@Service
public class CustomCommentComponentFactoy extends CommentSocialComponentFactory implements SocialComponentFactory {

    @Reference
    CommentSocialComponentListProviderManager commentListProviderManager;

    public SocialComponent getSocialComponent(Resource resource){
        try {
            return new CustomComment(resource, this.getClientUtilities(resource.getResourceResolver()),commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    @Override
    public SocialComponent getSocialComponent(final Resource resource, final SlingHttpServletRequest request) {
        try {
            return new CustomComment(resource, this.getClientUtilities(request),this.getQueryRequestInfo(request),commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SocialComponent getSocialComponent(Resource resource, ClientUtilities clientUtils, QueryRequestInfo listInfo) {
        try {
            return new CustomComment(resource, clientUtils, listInfo,commentListProviderManager);
        } catch (RepositoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*SocialComponent getSocialComponent(Resource resource, org.apache.sling.api.SlingHttpServletRequest slingHttpServletRequest);

    SocialComponent getSocialComponent(Resource resource, com.adobe.cq.social.commons.client.api.ClientUtilities clientUtilities, com.adobe.cq.social.commons.client.api.QueryRequestInfo queryRequestInfo);
*/
    public int getPriority(){
        return 10;
    }
}
