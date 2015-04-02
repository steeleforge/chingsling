package com.steeleforge.aem.chingsling.resource;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

public interface ChisourceResolver extends Adaptable {
    Optional<Resource> resolve(HttpServletRequest request, String absPath);
    Optional<Resource> resolve(String absPath);
    Optional<String> map(String resourcePath);
    Optional<String> map(HttpServletRequest request, String resourcePath);
    Optional<Resource> getResource(String path);
    Optional<Resource> getResource(Resource base, String path);
    Optional<String[]> getSearchPath();
    Stream<Resource> listChildren(Resource parent);
    Stream<Resource> getChildren(Resource parent);
    Stream<Resource> findResources(String query, String language);
    Stream<Map<String, Object>> queryResources(String query, String language);
    boolean hasChildren(Resource resource);
    Optional<ResourceResolver> clone(Map<String, Object> authenticationInfo) throws LoginException;
    boolean isLive();
    void close();
    Optional<String> getUserID();
    Stream<String> getAttributeNames();
    Optional<Object> getAttribute(String name);
    void delete(Resource resource) throws PersistenceException;
    Optional<Resource> create(Resource parent, String name, Map<String, Object> properties) throws PersistenceException;
    void revert();
    void commit() throws PersistenceException;
    boolean hasChanges();
    Optional<String> getParentResourceType(final Resource resource);
    public Optional<String> getParentResourceType(final String resourceType);
    boolean isResourceType(final Resource resource, final String resourceType);
    void refresh();
}
