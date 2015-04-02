package com.steeleforge.aem.chingsling.delegates;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.steeleforge.aem.chingsling.λ;

public enum ResourceResolverDelegate {
    INSTANCE;
    
    public static final Optional<Resource> resolve(final ResourceResolver resourceResolver, final HttpServletRequest request, final String absPath) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.resolve(request, absPath));
    }
    
    public static final Optional<Resource> resolve(final ResourceResolver resourceResolver, final String absPath) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.resolve(absPath));
    }
    
    public static final Optional<String> map(final ResourceResolver resourceResolver, final String resourcePath) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.map(resourcePath));
    }
    
    public static final Optional<String> map(final ResourceResolver resourceResolver, final HttpServletRequest request, final String resourcePath) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.map(request, resourcePath));
    }
    
    public static final Optional<Resource> getResource(final ResourceResolver resourceResolver, final String path) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getResource(path));
    }
    
    public static final Optional<Resource> getResource(final ResourceResolver resourceResolver, final Resource base, final String path) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getResource(base, path));
    }
    
    public static final Optional<String[]> getSearchPath(final ResourceResolver resourceResolver) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getSearchPath());
    }
    
    public static final Stream<Resource> listChildren(final ResourceResolver resourceResolver, final Resource parent) {
        if (null == resourceResolver) {
            return Stream.empty();
        }
        return λ.stream(resourceResolver.getChildren(parent));
    }
    
    public static final Stream<Resource> getChildren(final ResourceResolver resourceResolver, final Resource parent) {
        if (null == resourceResolver) {
            return Stream.empty();
        }
        return λ.stream(resourceResolver.getChildren(parent));
    }
    
    public static final Stream<Resource> findResources(final ResourceResolver resourceResolver, final String query, final String language) {
        if (null == resourceResolver) {
            return Stream.empty();
        }
        return  λ.stream(resourceResolver.findResources(query, language));
    }
    
    public static final Stream<Map<String, Object>> queryResources(final ResourceResolver resourceResolver, final String query, final String language) {
        if (null == resourceResolver) {
            return Stream.empty();
        }
        return  λ.stream(resourceResolver.queryResources(query, language));
    }
    
    public static final Optional<ResourceResolver> clone(final ResourceResolver resourceResolver, final Map<String, Object> authenticationInfo)
            throws LoginException {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.clone(authenticationInfo));
    }

    public static final Optional<String> getUserID(final ResourceResolver resourceResolver) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getUserID());
    }

    
    public static final Stream<String> getAttributeNames(final ResourceResolver resourceResolver) {
        if (null == resourceResolver) {
            return Stream.empty();
        }
        return λ.stream(resourceResolver.getAttributeNames());
    }
    
    public static final Optional<Object> getAttribute(final ResourceResolver resourceResolver, final String name) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getAttribute(name));
    }
    
    public static final Optional<Resource> create(final ResourceResolver resourceResolver, final Resource parent, final String name,
            Map<String, Object> properties) throws PersistenceException {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.create(parent, name, properties));
    }
    
    public static final Optional<String> getParentResourceType(final ResourceResolver resourceResolver, final Resource resource) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getParentResourceType(resource));
    }
    
    public static final Optional<String> getParentResourceType(final ResourceResolver resourceResolver, final String resourceType) {
        if (null == resourceResolver) {
            return Optional.empty();
        }
        return λ.ofNullable(resourceResolver.getParentResourceType(resourceType));
    }
}
