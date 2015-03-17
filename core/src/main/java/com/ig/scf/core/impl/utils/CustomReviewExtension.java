package com.ig.scf.core.impl.utils;

import com.adobe.cq.social.commons.Comment;
import com.adobe.cq.social.commons.client.endpoints.Operation;
import com.adobe.cq.social.commons.client.endpoints.OperationException;
import com.adobe.cq.social.review.client.endpoints.ReviewOperationExtension;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;

import javax.jcr.Session;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Rima
 * Date: 3/18/15
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(name = "Review Operation Extension", immediate = true, metatype = true)
@Service
public class CustomReviewExtension implements ReviewOperationExtension{
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getName() {
        return "Review Custom";
    }

    @Override
    public List<ReviewOperation> getOperationsToHookInto() {
        return Arrays.asList(ReviewOperation.CREATE);
    }

    @Override
    public void beforeAction(Operation operation, Session session, Resource resource, Map<String, Object> stringObjectMap) throws OperationException {
        stringObjectMap.put("authorName","IGWEBINAR");
        stringObjectMap.put("message",stringObjectMap.get("message")+"-- IGWEBINAR");
    }

    @Override
    public void afterAction(Operation operation, Session session, Comment comment, Map<String, Object> stringObjectMap) throws OperationException {

    }
}
