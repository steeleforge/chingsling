package com.steeleforge.aem.chingsling.resource;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

public interface Chisource extends Adaptable {
    Optional<String>  getPath();
    Optional<String>  getName();
    Optional<Resource> getParent();
    Stream<Resource> listChildren();
    Stream<Resource> getChildren();
    Optional<Resource> getChild(String relPath);
    Optional<String>  getResourceType();
    Optional<String>  getResourceSuperType();
    boolean hasChildren();
    boolean isResourceType(String resourceType);
    Optional<ResourceMetadata> getResourceMetadata();
    Optional<ResourceResolver> getResourceResolver();
    Optional<ValueMap> getValueMap();
    Optional<Resource> getResource();
    Optional<ModifiableValueMap> getModifiableValueMap();
}
