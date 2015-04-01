package com.steeleforge.aem.chingsling.delegates;

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
import org.apache.sling.api.resource.ResourceResolver;

public enum ResourceResolverDelegate {
	INSTANCE;
	
	public static final Optional<Resource> resolve(ResourceResolver resourceResolver, HttpServletRequest request, String absPath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.resolve(request, absPath));
	}
	
	public static final Optional<Resource> resolve(ResourceResolver resourceResolver, String absPath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.resolve(absPath));
	}
	
	public static final Optional<String> map(ResourceResolver resourceResolver, String resourcePath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.map(resourcePath));
	}
	
	public static final Optional<String> map(ResourceResolver resourceResolver, HttpServletRequest request, String resourcePath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.map(request, resourcePath));
	}
	
	public static final Optional<Resource> getResource(ResourceResolver resourceResolver, String path) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getResource(path));
	}
	
	public static final Optional<Resource> getResource(ResourceResolver resourceResolver, Resource base, String path) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getResource(base, path));
	}
	
	public static final Optional<String[]> getSearchPath(ResourceResolver resourceResolver) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getSearchPath());
	}
	
	public static final Stream<Resource> listChildren(ResourceResolver resourceResolver, Resource parent) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return StreamSupport.stream(resourceResolver.getChildren(parent).spliterator(), true);
	}
	
	public static final Stream<Resource> getChildren(ResourceResolver resourceResolver, Resource parent) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return StreamSupport.stream(
				resourceResolver.getChildren(parent).spliterator()
				, true);
	}
	
	public static final Stream<Resource> findResources(ResourceResolver resourceResolver, String query, String language) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(
						resourceResolver.findResources(query, language)
						, Spliterator.ORDERED), true);
	}
	
	public static final Stream<Map<String, Object>> queryResources(ResourceResolver resourceResolver, String query,
			String language) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(
						resourceResolver.queryResources(query, language)
						, Spliterator.ORDERED), true);
	}
	
	public static final Optional<ResourceResolver> clone(ResourceResolver resourceResolver, Map<String, Object> authenticationInfo)
			throws LoginException {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.clone(authenticationInfo));
	}

	public static final Optional<String> getUserID(ResourceResolver resourceResolver) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getUserID());
	}

	
	public static final Stream<String> getAttributeNames(ResourceResolver resourceResolver) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(
					resourceResolver.getAttributeNames(), Spliterator.ORDERED), true);
	}
	
	public static final Optional<Object> getAttribute(ResourceResolver resourceResolver, String name) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getAttribute(name));
	}
	
	public static final Optional<Resource> create(ResourceResolver resourceResolver, Resource parent, String name,
			Map<String, Object> properties) throws PersistenceException {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.create(parent, name, properties));
	}
	
	public static final Optional<String> getParentResourceType(ResourceResolver resourceResolver, Resource resource) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getParentResourceType(resource));
	}
	
	public static final Optional<String> getParentResourceType(ResourceResolver resourceResolver, String resourceType) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return Optional.ofNullable(resourceResolver.getParentResourceType(resourceType));
	}
}
