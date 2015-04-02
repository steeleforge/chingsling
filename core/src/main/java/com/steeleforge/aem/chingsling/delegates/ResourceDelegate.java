package com.steeleforge.aem.chingsling.delegates;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.steeleforge.aem.chingsling.λ;

public enum ResourceDelegate {
    INSTANCE;
    
    public static final Optional<String> getPath(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getPath());
    }
    
    public static final Optional<String> getName(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getName());
    }
    
    public static final Optional<Resource> getParent(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getParent());
    }

    public static final Stream<Resource> listChildren(final Resource resource) {
        if (null == resource) {
            return Stream.empty();
        }
        return ResourceResolverDelegate.listChildren(resource.getResourceResolver()
                , resource);
    }
    
    public static final Stream<Resource> getChildren(final Resource resource) {
        if (null == resource) {
            return Stream.empty();
        }
        return ResourceResolverDelegate.getChildren(resource.getResourceResolver()
                , resource);
    }
    
    public static final Optional<Resource> getChild(final Resource resource, final String relPath) {
        if (null == resource) {
            return Optional.empty();
        }
        return ResourceResolverDelegate.getResource(
                        resource.getResourceResolver(), relPath);
    }
    
    public static final Optional<String> getResourceType(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getResourceType());
    }

    
    public static final Optional<String> getResourceSuperType(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return ResourceResolverDelegate.getParentResourceType(resource.getResourceResolver(), resource);
    }
    
    public static final Optional<ResourceMetadata> getResourceMetadata(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getResourceMetadata());
    }

    
    public static final Optional<ResourceResolver> getResourceResolver(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getResourceResolver());
    }

    
    public static final Optional<ValueMap> getValueMap(final Resource resource) {
        if (null == resource) {
            return Optional.empty();
        }
        return λ.ofNullable(resource.getValueMap());
    }
}
