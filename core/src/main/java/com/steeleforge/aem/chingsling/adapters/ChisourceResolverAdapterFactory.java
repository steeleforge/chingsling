package com.steeleforge.aem.chingsling.adapters;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.steeleforge.aem.chingsling.resource.ChisourceResolver;
import com.steeleforge.aem.chingsling.resource.impl.ChisourceResolverImpl;

@Component(metatype = false)
@Service(value = AdapterFactory.class)
public class ChisourceResolverAdapterFactory implements AdapterFactory {
    @SuppressWarnings("unused")
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private static final Class<ChisourceResolver> CHISOURCERESOLVER = ChisourceResolver.class;
    
    @Property(name="adapters")
    public static final String[] ADAPTERS = { CHISOURCERESOLVER.getName() };
    
    @Property(name="adaptables")
    public static final String[] ADAPTABLES = { 
        ResourceResolver.class.getName()
    };
    
    @Override
    public <AdapterType> AdapterType getAdapter(Object adaptable,
            Class<AdapterType> type) {
        if (null == adaptable) return null;
        if (adaptable instanceof ResourceResolver) {
            return getAdapter((ResourceResolver)adaptable, type);
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public <AdapterType> AdapterType getAdapter(ResourceResolver adaptable,
            Class<AdapterType> type) {
        return (AdapterType) new ChisourceResolverImpl(adaptable);
    }
}
