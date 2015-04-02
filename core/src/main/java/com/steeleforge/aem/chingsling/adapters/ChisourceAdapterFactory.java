package com.steeleforge.aem.chingsling.adapters;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.NonExistingResource;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.serviceusermapping.ServiceUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.steeleforge.aem.chingsling.λ;
import com.steeleforge.aem.chingsling.resource.Chisource;
import com.steeleforge.aem.chingsling.resource.impl.ChisourceImpl;

@Component(metatype = false)
@Service(value = AdapterFactory.class)
public class ChisourceAdapterFactory implements AdapterFactory {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private static final String SERVICENAME = "AdapterFactory";
    private static final Class<Chisource> CHISOURCE = Chisource.class;
    
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    
    @Reference
    ServiceUserMapper serviceUserMapper;
    
    @Property(name="adapters")
    public static final String[] ADAPTERS = { CHISOURCE.getName() };
    
    @Property(name="adaptables")
    public static final String[] ADAPTABLES = { 
        Resource.class.getName(), 
        Node.class.getName() 
    };
    
    Map<String, Object> serviceMap = new HashMap<String, Object>();
    
    @Override
    public <AdapterType> AdapterType getAdapter(Object adaptable,
            Class<AdapterType> type) {
        if (null == adaptable) return null;
        if (adaptable instanceof Resource) {
            return getAdapter((Resource)adaptable, type);
        }
        if (adaptable instanceof Node) {
            return getAdapter((Node)adaptable, type);
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public <AdapterType> AdapterType getAdapter(Resource adaptable,
            Class<AdapterType> type) {
        return (AdapterType) new ChisourceImpl(adaptable);
    }
    
    @SuppressWarnings("unchecked")
    public <AdapterType> AdapterType getAdapter(Node adaptable,
            Class<AdapterType> type) {
        ResourceResolver rr = null;
        Resource resource = null;
        try {
            rr = resourceResolverFactory.getServiceResourceResolver(serviceMap);
            resource = λ.getResource(rr, adaptable.getPath())
                    .orElse(new NonExistingResource(rr, adaptable.getPath()));
        } catch (LoginException e) {
            LOG.debug(e.getMessage());
        } catch (RepositoryException e) {
            LOG.debug(e.getMessage());
        } finally {
            rr.close();
        }
        return (AdapterType) new ChisourceImpl(resource);
    }
    
    @Activate
    public void activate() {
        this.serviceMap.put(ResourceResolverFactory.SUBSERVICE, SERVICENAME);
    }
}
