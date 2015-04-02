package com.steeleforge.aem.chingsling.resource.impl;

import java.util.Optional;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.apache.sling.adapter.annotations.Adaptable;
import org.apache.sling.adapter.annotations.Adapter;
import org.apache.sling.api.adapter.SlingAdaptable;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;

import com.steeleforge.aem.chingsling.λ;
import com.steeleforge.aem.chingsling.resource.Chisource;

@Adaptable(
    adaptableClass = Chisource.class,
    adapters = {
        @Adapter({ Resource.class, ValueMap.class })
    }
)
@Model(adaptables=Resource.class)
public class ChisourceImpl extends SlingAdaptable implements Chisource {
    @Inject
    private Resource resource;
    
    private ChisourceImpl() {
        // NO-OP
    }
    public ChisourceImpl(Resource resource) {
        this();
        if (null == this.resource) {
            this.resource = resource;
        }
    }

    @Override
    public Optional<String> getPath() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getPath(resource);
    }

    @Override
    public Optional<String> getName() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getName(resource);
    }

    @Override
    public Optional<Resource> getParent() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getParent(resource);
    }

    @Override
    public Stream<Resource> listChildren() {
        if (null == this.resource) {
            return Stream.empty();
        }
        return λ.listChildren(resource);
    }

    @Override
    public Stream<Resource> getChildren() {
        if (null == this.resource) {
            return Stream.empty();
        }
        return λ.getChildren(resource);
    }

    @Override
    public Optional<Resource> getChild(String relPath) {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getChild(resource, relPath);
    }

    @Override
    public Optional<String> getResourceType() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getResourceType(resource);
    }

    @Override
    public Optional<String> getResourceSuperType() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getResourceSuperType(resource);
    }

    @Override
    public boolean hasChildren() {
        if (null == this.resource) {
            return false;
        }
        return resource.hasChildren();
    }

    @Override
    public boolean isResourceType(String resourceType) {
        if (null == this.resource) {
            return false;
        }
        return resource.isResourceType(resourceType);
    }

    @Override
    public Optional<ResourceMetadata> getResourceMetadata() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getResourceMetadata(resource);
    }

    @Override
    public Optional<ResourceResolver> getResourceResolver() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getResourceResolver(resource);
    }

    @Override
    public Optional<ValueMap> getValueMap() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return λ.getValueMap(resource);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <AdapterType> AdapterType adaptTo(Class<AdapterType> type) {
        if (null == this.resource) {
            return (AdapterType)Optional.empty();
        }
        return this.resource.adaptTo(type);
    }
    @Override
    public Optional<Resource> getResource() {
        if (null == this.resource) {
            return Optional.empty();
        }
        return Optional.ofNullable(resource);
    }
}
