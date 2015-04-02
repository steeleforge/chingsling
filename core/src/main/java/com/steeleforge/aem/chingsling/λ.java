package com.steeleforge.aem.chingsling;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.steeleforge.aem.chingsling.delegates.ResourceDelegate;
import com.steeleforge.aem.chingsling.delegates.ResourceResolverDelegate;

public enum λ {
	INSTANCE;
	
	public static final <T> Optional<T> ofNullable(T value) {
		return Optional.ofNullable(value);
	}

	public static final <T> Stream<T> stream(Iterable<T> iterable, boolean parallel) {
		if (null == iterable) {
			return Stream.empty();
		}
		return StreamSupport.stream(iterable.spliterator(), parallel);
	}
	
	public static final <T> Stream<T> stream(Iterator<T> iterator, boolean parallel) {
		if (null == iterator) {
			return Stream.empty();
		}
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iterator
						, Spliterator.ORDERED), parallel);
	}
	
	public static final <T> Stream<T> stream(Iterable<T> iterable) {
		return stream(iterable, true);
	}
	
	public static final <T> Stream<T> stream(Iterator<T> iterator) {
		return stream(iterator, true);
	}
	
	public static final Optional<Resource> resolve(ResourceResolver resourceResolver, HttpServletRequest request, String absPath) {
		return ResourceResolverDelegate.resolve(resourceResolver, request, absPath);
	}

	public static final Optional<Resource> resolve(ResourceResolver resourceResolver, String absPath) {
		return ResourceResolverDelegate.resolve(resourceResolver, absPath);
	}

	public static final Optional<String> map(ResourceResolver resourceResolver, String resourcePath) {
		return ResourceResolverDelegate.map(resourceResolver, resourcePath);
	}

	public static final Optional<String> map(ResourceResolver resourceResolver, HttpServletRequest request, String resourcePath) {
		return ResourceResolverDelegate.map(resourceResolver, request, resourcePath);
	}

	public static final Optional<Resource> getResource(ResourceResolver resourceResolver, String path) {
		return ResourceResolverDelegate.getResource(resourceResolver, path);
	}

	public static final Optional<Resource> getResource(ResourceResolver resourceResolver, Resource base, String path) {
		return ResourceResolverDelegate.getResource(resourceResolver, base, path);
	}

	public static final Optional<String[]> getSearchPath(ResourceResolver resourceResolver) {
		return ResourceResolverDelegate.getSearchPath(resourceResolver);
	}

	public static final Stream<Resource> listChildren(ResourceResolver resourceResolver, Resource parent) {
		return ResourceResolverDelegate.listChildren(resourceResolver, parent);
	}

	public static final Stream<Resource> getChildren(ResourceResolver resourceResolver, Resource parent) {
		return ResourceResolverDelegate.getChildren(resourceResolver, parent);
	}
	
	public static final Stream<Resource> findResources(ResourceResolver resourceResolver, String query, String language) {
		return ResourceResolverDelegate.findResources(resourceResolver, query, language);
	}

	public static final Stream<Map<String, Object>> queryResources(ResourceResolver resourceResolver, String query,
			String language) {
		return ResourceResolverDelegate.queryResources(resourceResolver, query, language);
	}
	
	public static final Optional<ResourceResolver> clone(ResourceResolver resourceResolver, Map<String, Object> authenticationInfo)
			throws LoginException {
		return ResourceResolverDelegate.clone(resourceResolver, authenticationInfo);
	}

	public static final Optional<String> getUserID(ResourceResolver resourceResolver) {
		return ResourceResolverDelegate.getUserID(resourceResolver);
	}
	
	public static final Stream<String> getAttributeNames(ResourceResolver resourceResolver) {
		return ResourceResolverDelegate.getAttributeNames(resourceResolver);
	}

	public static final Optional<Object> getAttribute(ResourceResolver resourceResolver, String name) {
		return ResourceResolverDelegate.getAttribute(resourceResolver, name);
	}
	
	public static final Optional<Resource> create(ResourceResolver resourceResolver, Resource parent, String name,
			Map<String, Object> properties) throws PersistenceException {
		return ResourceResolverDelegate.create(resourceResolver, parent, name, properties);
	}

	public static final Optional<String> getParentResourceType(ResourceResolver resourceResolver, Resource resource) {
		return ResourceResolverDelegate.getParentResourceType(resourceResolver, resource);
	}
	
	public static final Optional<String> getParentResourceType(ResourceResolver resourceResolver, String resourceType) {
		return ResourceResolverDelegate.getParentResourceType(resourceResolver, resourceType);
	}
	
	public static final Optional<String> getPath(Resource resource) {
		return ResourceDelegate.getPath(resource);
	}
	
	public static final Optional<String> getName(Resource resource) {
		return ResourceDelegate.getName(resource);
	}
	
	public static final Optional<Resource> getParent(Resource resource) {
		return ResourceDelegate.getParent(resource);
	}

	public static final Stream<Resource> listChildren(Resource resource) {
		return ResourceDelegate.listChildren(resource);
	}
	
	public static final Stream<Resource> getChildren(Resource resource) {
		return ResourceDelegate.getChildren(resource);
	}
	
	public static final Optional<Resource> getChild(Resource resource, String relPath) {
		return ResourceDelegate.getChild(resource, relPath);
	}
	
	public static final Optional<String> getResourceType(Resource resource) {
		return ResourceDelegate.getResourceSuperType(resource);
	}

	public static final Optional<String> getResourceSuperType(Resource resource) {
		return ResourceDelegate.getResourceSuperType(resource);
	}
	
	public static final Optional<ResourceMetadata> getResourceMetadata(Resource resource) {
		return ResourceDelegate.getResourceMetadata(resource);
	}
	public static final Optional<ResourceResolver> getResourceResolver(Resource resource) {
		return ResourceDelegate.getResourceResolver(resource);
	}
	
	public static final Optional<ValueMap> getValueMap(Resource resource) {
		return Optional.ofNullable(resource.getValueMap());
	}
}
